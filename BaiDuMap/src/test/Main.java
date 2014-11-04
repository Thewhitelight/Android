package test;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.mapapi.map.Symbol;
import com.baidu.mapapi.map.Symbol.Color;
import com.baidu.mapapi.map.TextItem;
import com.baidu.mapapi.map.TextOverlay;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.example.baidumap.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;


public class Main extends Activity{
	private BMapManager mBMapMan=null;
	MapView mMapView=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		mBMapMan=new BMapManager(getApplication());
		mBMapMan.init(null);
		setContentView(R.layout.main);
		mMapView=(MapView) findViewById(R.id.bmapView);
		mMapView.setBuiltInZoomControls(true);//设置启用内置的缩放控件  
		mMapView.setSatellite(true);//设置启用卫星图
		
		MapController mMapController=mMapView.getController();// 得到mMapView的控制权,可以用它控制和驱动平移和缩放
		GeoPoint point=new GeoPoint((int)(28.883* 1E6),(int)(121.174* 1E6));
		GeoPoint point2=new GeoPoint((int)(28.88044* 1E6),(int)(121.16985* 1E6));//121.169851,28.880445
		mMapController.setCenter(point);//设置中心点
		mMapController.setZoom(18);//设置zoom级别
		/* 
		 * 自定义图层：ItemizedOverlay
		 * */
		double mLat1=28.88540;
		double mLon1=121.17508;
		double mLat2=28.88322;
		double mLon2=121.17438;
		double mLat3=28.88229;
		double mLon3=121.17160;
		GeoPoint p1 = new GeoPoint((int) (mLat1 * 1E6), (int) (mLon1 * 1E6));  
		GeoPoint p2 = new GeoPoint((int) (mLat2 * 1E6), (int) (mLon2 * 1E6));  
		GeoPoint p3 = new GeoPoint((int) (mLat3 * 1E6), (int) (mLon3 * 1E6)); 
		Drawable mark=getResources().getDrawable(R.drawable.ic_launcher);
		OverlayItem item1=new OverlayItem(p1, "item1", "item1");
		OverlayItem item2=new OverlayItem(p2, "item2", "item2");
		item2.setMarker(getResources().getDrawable(R.drawable.location));;
		OverlayItem item3=new OverlayItem(p3, "item3", "item3");
		myOverLay itemOverLay=new myOverLay(mark, mMapView);
		mMapView.getOverlays().clear();
		mMapView.getOverlays().add(itemOverLay);
		itemOverLay.addItem(item1);  
		itemOverLay.addItem(item2);  
		itemOverLay.addItem(item3); 
		/*
		 * 文字绘制图层：TextOverlay
		 * */
		Symbol textSymbol=new Symbol();
		Symbol.Color textColor=textSymbol.new Color();
		textColor.alpha = 255;    
		textColor.red = 255;    
		textColor.blue = 0;    
		textColor.green = 0; 
		Symbol textSymboli=new Symbol();
		Symbol.Color textColori=textSymbol.new Color();
		textColori.alpha = 150;    
		textColori.red = 80;    
		textColori.blue = 80;    
		textColori.green = 80;  
		TextItem textItem=new TextItem();
		textItem.fontColor=textColor;//字体颜色
		textItem.bgColor=textColori;//字体背景颜色
		textItem.fontSize=20;
		textItem.text="这是第一段文字";
		textItem.pt=p1;
		//textItem.pt=mMapView.getMapCenter();
		TextItem textItem1=new TextItem();
		textItem1.fontColor=textColor;//字体颜色
		textItem1.bgColor=textColori;//字体背景颜色
		textItem1.fontSize=20;
		textItem1.text="这是第二段文字";
		textItem1.pt=point2;
		TextOverlay textOverlay = new TextOverlay(mMapView);    
		textOverlay.addText(textItem); 
		textOverlay.addText(textItem1);
		mMapView.getOverlays().add(textOverlay);	
		mMapView.refresh();  
	}

	class  myOverLay extends ItemizedOverlay<OverlayItem> {

		public myOverLay(Drawable mark, MapView mapView) {
			super(mark, mapView);
			// TODO 自动生成的构造函数存根
		}
		// TODO 自动生成的方法存根
		@Override
		protected boolean onTap(int index) {
			// TODO 自动生成的方法存根
			//Toast.makeText(getApplication(), "您点击的是第 " + index+"个气泡",Toast.LENGTH_SHORT).show();
			return true;
		}
		@Override
		public boolean onTap(GeoPoint pt, MapView mapView) {
			// TODO 自动生成的方法存根
		    super.onTap(pt, mapView);
			return false;
		}
	        
	}

	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		mMapView.destroy();
		if (mBMapMan!=null) {
			mBMapMan.destroy();
			mBMapMan=null;
		}
		super.onDestroy();
	}
	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		mMapView.onPause();
		if (mBMapMan!=null) {
			mBMapMan.stop();
		}
		super.onPause();
	}
	@Override
	protected void onResume() {
		// TODO 自动生成的方法存根
		mMapView.onResume();
		if (mBMapMan!=null) {
			mBMapMan.start();
		}
		super.onResume();
	}
 
}
