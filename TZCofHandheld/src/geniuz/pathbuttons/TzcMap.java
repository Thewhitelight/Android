package geniuz.pathbuttons;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Symbol;
import com.baidu.mapapi.map.TextItem;
import com.baidu.mapapi.map.TextOverlay;
import com.baidu.platform.comapi.basestruct.GeoPoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class TzcMap extends Activity {
	private BMapManager mBMapManager = null;
	MapView mMapView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������û����
		super.onCreate(savedInstanceState);
		mBMapManager = new BMapManager(getApplication());
		mBMapManager.init(null);
		setContentView(R.layout.tzcmap);
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);//���뵭��Ч��
		mMapView = (MapView) findViewById(R.id.bmapView);
		mMapView.setBuiltInZoomControls(true);
		mMapView.setBuiltInZoomControls(true);// �����������õ����ſؼ�
		mMapView.setSatellite(true);// ������������ͼ
		MapController mMapController = mMapView.getController();// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		GeoPoint point = new GeoPoint((int) (28.883 * 1E6),
				(int) (121.174 * 1E6));
		mMapController.setCenter(point);// �������ĵ�
		mMapController.setZoom(18);// ����zoom����
		/*
		 * ���ֻ���ͼ�㣺TextOverlay
		 */
		GeoPoint pointNo1 = new GeoPoint((int) (28.882983 * 1E6),
				(int) (121.171509 * 1E6));
		GeoPoint pointNo2 = new GeoPoint((int) (28.883283 * 1E6),
				(int) (121.171522 * 1E6));
		GeoPoint pointNo3 = new GeoPoint((int) (28.883556 * 1E6),
				(int) (121.171257 * 1E6));
		GeoPoint pointNo4 = new GeoPoint((int) (28.882734 * 1E6),
				(int) (121.171019 * 1E6));
		GeoPoint pointNo5 = new GeoPoint((int) (28.882912 * 1E6),
				(int) (121.170557 * 1E6));
		GeoPoint pointNo6 = new GeoPoint((int) (28.883208 * 1E6),
				(int) (121.17066 * 1E6));
		GeoPoint pointNo7 = new GeoPoint((int) (28.883489 * 1E6),
				(int) (121.17079 * 1E6));
		GeoPoint pointNo8 = new GeoPoint((int) (28.881809 * 1E6),
				(int) (121.16969 * 1E6));
		GeoPoint pointNo9 = new GeoPoint((int) (28.881524 * 1E6),
				(int) (121.169676 * 1E6));
		GeoPoint pointNo10 = new GeoPoint((int) (28.881780 * 1E6),
				(int) (121.170431 * 1E6));
		GeoPoint pointNo11 = new GeoPoint((int) (28.881449 * 1E6),
				(int) (121.170426 * 1E6));
		GeoPoint pointNo12 = new GeoPoint((int) (28.881204 * 1E6),
				(int) (121.169703 * 1E6));
		GeoPoint pointNo13 = new GeoPoint((int) (28.881556 * 1E6),
				(int) (121.172479 * 1E6));
		GeoPoint pointNo14 = new GeoPoint((int) (28.881362 * 1E6),
				(int) (121.171769 * 1E6));
		GeoPoint pointNo15 = new GeoPoint((int) (28.881034 * 1E6),
				(int) (121.171769 * 1E6));
		GeoPoint pointNo16 = new GeoPoint((int) (28.880927 * 1E6),
				(int) (121.170983 * 1E6));
		GeoPoint pointNo17 = new GeoPoint((int) (28.880547 * 1E6),
				(int) (121.171055 * 1E6));
		GeoPoint pointNoBasket = new GeoPoint((int) (28.883809 * 1E6),
				(int) (121.171400 * 1E6));
		GeoPoint pointNoBird1 = new GeoPoint((int) (28.883852 * 1E6),
				(int) (121.171181 * 1E6));
		GeoPoint pointNoGym = new GeoPoint((int) (28.883868 * 1E6),
				(int) (121.170965 * 1E6));
		GeoPoint pointNoZF = new GeoPoint((int) (28.882267 * 1E6),
				(int) (121.170413 * 1E6));
		GeoPoint pointNoGW = new GeoPoint((int) (28.882085 * 1E6),
				(int) (121.169991 * 1E6));
		GeoPoint pointNoBird2 = new GeoPoint((int) (28.883374 * 1E6),
				(int) (121.171953 * 1E6));
		GeoPoint pointNoTLY = new GeoPoint((int) (28.881619 * 1E6),
				(int) (121.170449 * 1E6));
		GeoPoint pointNoSY = new GeoPoint((int) (28.880939 * 1E6),
				(int) (121.169824 * 1E6));
		GeoPoint pointNoZDS = new GeoPoint((int) (28.880757 * 1E6),
				(int) (121.169937 * 1E6));
		GeoPoint pointNoZGL = new GeoPoint((int) (28.881805 * 1E6),
				(int) (121.173058 * 1E6));
		GeoPoint pointNoWestGate = new GeoPoint((int) (28.880437 * 1E6),
				(int) (121.169901 * 1E6));
		GeoPoint pointNoSwming = new GeoPoint((int) (28.880172 * 1E6),
				(int) (121.170507 * 1E6));
		GeoPoint pointNoJX = new GeoPoint((int) (28.883422 * 1E6),
				(int) (121.172280 * 1E6));
		GeoPoint pointNoLYH = new GeoPoint((int) (28.882469 * 1E6),
				(int) (121.172838 * 1E6));
		GeoPoint pointNoSatherGate = new GeoPoint((int) (28.882117 * 1E6),
				(int) (121.175309 * 1E6));
		GeoPoint pointNoJH = new GeoPoint((int) (28.881872 * 1E6),
				(int) (121.174972 * 1E6));
		GeoPoint pointNoGH = new GeoPoint((int) (28.882295 * 1E6),
				(int) (121.175524 * 1E6));
		GeoPoint pointNoBG2 = new GeoPoint((int) (28.886066 * 1E6),
				(int) (121.173593 * 1E6));
		GeoPoint pointNoTennis = new GeoPoint((int) (28.886659 * 1E6),
				(int) (121.174181 * 1E6));
		GeoPoint pointNoPP = new GeoPoint((int) (28.887080 * 1E6),
				(int) (121.174210 * 1E6));
		GeoPoint pointNoZH = new GeoPoint((int) (28.881824 * 1E6),
				(int) (121.170808 * 1E6));
		/*
		 * GeoPoint pointNoFD=new GeoPoint((int) (28.882805 * 1E6), (int)
		 * (121.17588* 1E6));//�綯���� GeoPoint pointNoSMG=new GeoPoint((int)
		 * (28.882821 * 1E6), (int) (121.170673* 1E6));//����� GeoPoint
		 * pointNoRYSD=new GeoPoint((int) (28.882916 * 1E6), (int) (121.171621*
		 * 1E6));//�������
		 */
		GeoPoint pointNoXYS = new GeoPoint((int) (28.882176 * 1E6),
				(int) (121.171751 * 1E6));
		Symbol textSymbol = new Symbol();
		Symbol.Color textColor = textSymbol.new Color();
		textColor.alpha = 255;
		textColor.red = 255;
		textColor.blue = 0;
		textColor.green = 0;
		@SuppressWarnings("unused")
		Symbol textSymboli = new Symbol();
		Symbol.Color textColori = textSymbol.new Color();
		textColori.alpha = 150;
		textColori.red = 80;
		textColori.blue = 80;
		textColori.green = 80;
		TextItem textItem1 = new TextItem();
		textItem1.fontColor = textColor;// ������ɫ
		textItem1.bgColor = textColori;// ���屳����ɫ
		textItem1.fontSize = 20;
		textItem1.text = "1��¥";
		textItem1.pt = pointNo1;
		TextItem textItem2 = new TextItem();
		textItem2.fontColor = textColor;// ������ɫ
		textItem2.bgColor = textColori;// ���屳����ɫ
		textItem2.fontSize = 20;
		textItem2.text = "2��¥";
		textItem2.pt = pointNo2;
		TextItem textItem3 = new TextItem();
		textItem3.fontColor = textColor;// ������ɫ
		textItem3.bgColor = textColori;// ���屳����ɫ
		textItem3.fontSize = 20;
		textItem3.text = "3��¥";
		textItem3.pt = pointNo3;
		TextItem textItem4 = new TextItem();
		textItem4.fontColor = textColor;// ������ɫ
		textItem4.bgColor = textColori;// ���屳����ɫ
		textItem4.fontSize = 20;
		textItem4.text = "4��¥";
		textItem4.pt = pointNo4;
		TextItem textItem5 = new TextItem();
		textItem5.fontColor = textColor;// ������ɫ
		textItem5.bgColor = textColori;// ���屳����ɫ
		textItem5.fontSize = 20;
		textItem5.text = "5��¥";
		textItem5.pt = pointNo5;
		TextItem textItem6 = new TextItem();
		textItem6.fontColor = textColor;// ������ɫ
		textItem6.bgColor = textColori;// ���屳����ɫ
		textItem6.fontSize = 20;
		textItem6.text = "6��¥";
		textItem6.pt = pointNo6;
		TextItem textItem7 = new TextItem();
		textItem7.fontColor = textColor;// ������ɫ
		textItem7.bgColor = textColori;// ���屳����ɫ
		textItem7.fontSize = 20;
		textItem7.text = "7��¥";
		textItem7.pt = pointNo7;
		TextItem textItem8 = new TextItem();
		textItem8.fontColor = textColor;// ������ɫ
		textItem8.bgColor = textColori;// ���屳����ɫ
		textItem8.fontSize = 20;
		textItem8.text = "8��¥";
		textItem8.pt = pointNo8;
		TextItem textItem9 = new TextItem();
		textItem9.fontColor = textColor;// ������ɫ
		textItem9.bgColor = textColori;// ���屳����ɫ
		textItem9.fontSize = 20;
		textItem9.text = "9��¥";
		textItem9.pt = pointNo9;
		TextItem textItem10 = new TextItem();
		textItem10.fontColor = textColor;// ������ɫ
		textItem10.bgColor = textColori;// ���屳����ɫ
		textItem10.fontSize = 20;
		textItem10.text = "10��¥";
		textItem10.pt = pointNo10;
		TextItem textItem11 = new TextItem();
		textItem11.fontColor = textColor;// ������ɫ
		textItem11.bgColor = textColori;// ���屳����ɫ
		textItem11.fontSize = 20;
		textItem11.text = "11��¥";
		textItem11.pt = pointNo11;
		TextItem textItem12 = new TextItem();
		textItem12.fontColor = textColor;// ������ɫ
		textItem12.bgColor = textColori;// ���屳����ɫ
		textItem12.fontSize = 20;
		textItem12.text = "12��¥";
		textItem12.pt = pointNo12;
		TextItem textItem13 = new TextItem();
		textItem13.fontColor = textColor;// ������ɫ
		textItem13.bgColor = textColori;// ���屳����ɫ
		textItem13.fontSize = 20;
		textItem13.text = "13��¥";
		textItem13.pt = pointNo13;
		TextItem textItem14 = new TextItem();
		textItem14.fontColor = textColor;// ������ɫ
		textItem14.bgColor = textColori;// ���屳����ɫ
		textItem14.fontSize = 20;
		textItem14.text = "14��¥";
		textItem14.pt = pointNo14;
		TextItem textItem15 = new TextItem();
		textItem15.fontColor = textColor;// ������ɫ
		textItem15.bgColor = textColori;// ���屳����ɫ
		textItem15.fontSize = 20;
		textItem15.text = "15��¥";
		textItem15.pt = pointNo15;
		TextItem textItem16 = new TextItem();
		textItem16.fontColor = textColor;// ������ɫ
		textItem16.bgColor = textColori;// ���屳����ɫ
		textItem16.fontSize = 20;
		textItem16.text = "16��¥";
		textItem16.pt = pointNo16;
		TextItem textItem17 = new TextItem();
		textItem17.fontColor = textColor;// ������ɫ
		textItem17.bgColor = textColori;// ���屳����ɫ
		textItem17.fontSize = 20;
		textItem17.text = "17��¥";
		textItem17.pt = pointNo17;
		TextItem textItem18 = new TextItem();
		textItem18.fontColor = textColor;// ������ɫ
		textItem18.bgColor = textColori;// ���屳����ɫ
		textItem18.fontSize = 20;
		textItem18.text = "�����";
		textItem18.pt = pointNoBasket;
		TextItem textItem19 = new TextItem();
		textItem19.fontColor = textColor;// ������ɫ
		textItem19.bgColor = textColori;// ���屳����ɫ
		textItem19.fontSize = 20;
		textItem19.text = "��ë���";
		textItem19.pt = pointNoBird1;
		TextItem textItem20 = new TextItem();
		textItem20.fontColor = textColor;// ������ɫ
		textItem20.bgColor = textColori;// ���屳����ɫ
		textItem20.fontSize = 20;
		textItem20.text = "��ٹ�";
		textItem20.pt = pointNoGym;
		TextItem textItem21 = new TextItem();
		textItem21.fontColor = textColor;// ������ɫ
		textItem21.bgColor = textColori;// ���屳����ɫ
		textItem21.fontSize = 20;
		textItem21.text = "�𷢲���";
		textItem21.pt = pointNoZF;
		TextItem textItem22 = new TextItem();
		textItem22.fontColor = textColor;// ������ɫ
		textItem22.bgColor = textColori;// ���屳����ɫ
		textItem22.fontSize = 20;
		textItem22.text = "������Է";
		textItem22.pt = pointNoGW;
		TextItem textItem23 = new TextItem();
		textItem23.fontColor = textColor;// ������ɫ
		textItem23.bgColor = textColori;// ���屳����ɫ
		textItem23.fontSize = 20;
		textItem23.text = "��ë��";
		textItem23.pt = pointNoBird2;
		TextItem textItem24 = new TextItem();
		textItem24.fontColor = textColor;// ������ɫ
		textItem24.bgColor = textColori;// ���屳����ɫ
		textItem24.fontSize = 20;
		textItem24.text = "����Է����";
		textItem24.pt = pointNoTLY;// weiwandiaxu
		TextItem textItem25 = new TextItem();
		textItem25.fontColor = textColor;// ������ɫ
		textItem25.bgColor = textColori;// ���屳����ɫ
		textItem25.fontSize = 20;
		textItem25.text = "ʳԵ����";
		textItem25.pt = pointNoSY;
		TextItem textItem26 = new TextItem();
		textItem26.fontColor = textColor;// ������ɫ
		textItem26.bgColor = textColori;// ���屳����ɫ
		textItem26.fontSize = 20;
		textItem26.text = "У�д���";
		textItem26.pt = pointNoZDS;
		TextItem textItem27 = new TextItem();
		textItem27.fontColor = textColor;// ������ɫ
		textItem27.bgColor = textColori;// ���屳����ɫ
		textItem27.fontSize = 20;
		textItem27.text = "��У��";
		textItem27.pt = pointNoWestGate;
		TextItem textItem28 = new TextItem();
		textItem28.fontColor = textColor;// ������ɫ
		textItem28.bgColor = textColori;// ���屳����ɫ
		textItem28.fontSize = 20;
		textItem28.text = "��Ӿ��";
		textItem28.pt = pointNoSwming;
		TextItem textItem29 = new TextItem();
		textItem29.fontColor = textColor;// ������ɫ
		textItem29.bgColor = textColori;// ���屳����ɫ
		textItem29.fontSize = 20;
		textItem29.text = "��Ϫ";
		textItem29.pt = pointNoJX;
		TextItem textItem30 = new TextItem();
		textItem30.fontColor = textColor;// ������ɫ
		textItem30.bgColor = textColori;// ���屳����ɫ
		textItem30.fontSize = 20;
		textItem30.text = "��ְ��¥";
		textItem30.pt = pointNoZGL;
		TextItem textItem31 = new TextItem();
		textItem31.fontColor = textColor;// ������ɫ
		textItem31.bgColor = textColori;// ���屳����ɫ
		textItem31.fontSize = 20;
		textItem31.text = "�����";
		textItem31.pt = pointNoLYH;
		TextItem textItem32 = new TextItem();
		textItem32.fontColor = textColor;// ������ɫ
		textItem32.bgColor = textColori;// ���屳����ɫ
		textItem32.fontSize = 20;
		textItem32.text = "�ϴ���";
		textItem32.pt = pointNoSatherGate;
		TextItem textItem33 = new TextItem();
		textItem33.fontColor = textColor;// ������ɫ
		textItem33.bgColor = textColori;// ���屳����ɫ
		textItem33.fontSize = 20;
		textItem33.text = "����ATM";
		textItem33.pt = pointNoJH;
		TextItem textItem34 = new TextItem();
		textItem34.fontColor = textColor;// ������ɫ
		textItem34.bgColor = textColori;// ���屳����ɫ
		textItem34.fontSize = 20;
		textItem34.text = "����ATM";
		textItem34.pt = pointNoGH;
		TextItem textItem35 = new TextItem();
		textItem35.fontColor = textColor;// ������ɫ
		textItem35.bgColor = textColori;// ���屳����ɫ
		textItem35.fontSize = 40;
		textItem35.text = "��������";
		textItem35.pt = pointNoBG2;
		TextItem textItem36 = new TextItem();
		textItem36.fontColor = textColor;// ������ɫ
		textItem36.bgColor = textColori;// ���屳����ɫ
		textItem36.fontSize = 30;
		textItem36.text = "����";
		textItem36.pt = pointNoTennis;
		TextItem textItem37 = new TextItem();
		textItem37.fontColor = textColor;// ������ɫ
		textItem37.bgColor = textColori;// ���屳����ɫ
		textItem37.fontSize = 20;
		textItem37.text = "ƹ�����";
		textItem37.pt = pointNoPP;
		TextItem textItem38 = new TextItem();
		textItem38.fontColor = textColor;// ������ɫ
		textItem38.bgColor = textColori;// ���屳����ɫ
		textItem38.fontSize = 20;
		textItem38.text = "����ATM";
		textItem38.pt = pointNoZH;
		TextItem textItem39 = new TextItem();
		textItem39.fontColor = textColor;// ������ɫ
		textItem39.bgColor = textColori;// ���屳����ɫ
		textItem39.fontSize = 20;
		textItem39.text = "Уҽ��";
		textItem39.pt = pointNoXYS;
		TextOverlay textOverlay = new TextOverlay(mMapView);
		textOverlay.addText(textItem1);//
		textOverlay.addText(textItem2);
		textOverlay.addText(textItem3);
		textOverlay.addText(textItem4);
		textOverlay.addText(textItem5);
		textOverlay.addText(textItem6);
		textOverlay.addText(textItem7);
		textOverlay.addText(textItem8);
		textOverlay.addText(textItem9);
		textOverlay.addText(textItem10);
		textOverlay.addText(textItem11);
		textOverlay.addText(textItem12);
		textOverlay.addText(textItem13);
		textOverlay.addText(textItem14);
		textOverlay.addText(textItem15);
		textOverlay.addText(textItem16);
		textOverlay.addText(textItem17);
		textOverlay.addText(textItem18);
		textOverlay.addText(textItem19);
		textOverlay.addText(textItem20);
		textOverlay.addText(textItem21);
		textOverlay.addText(textItem22);
		textOverlay.addText(textItem23);
		textOverlay.addText(textItem24);
		textOverlay.addText(textItem25);
		textOverlay.addText(textItem26);
		textOverlay.addText(textItem27);
		textOverlay.addText(textItem28);
		textOverlay.addText(textItem29);
		textOverlay.addText(textItem30);
		textOverlay.addText(textItem31);
		textOverlay.addText(textItem32);
		textOverlay.addText(textItem33);
		textOverlay.addText(textItem34);
		textOverlay.addText(textItem35);
		textOverlay.addText(textItem36);
		textOverlay.addText(textItem37);
		textOverlay.addText(textItem38);
		textOverlay.addText(textItem39);
		mMapView.getOverlays().add(textOverlay);
		mMapView.refresh();
	}

	@Override
	protected void onDestroy() {
		// TODO �Զ����ɵķ������
		mMapView.destroy();
		if (mBMapManager != null) {
			mBMapManager.destroy();
			mBMapManager = null;
		}
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO �Զ����ɵķ������
		mMapView.onPause();
		if (mBMapManager != null) {
			mBMapManager.stop();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO �Զ����ɵķ������
		mMapView.onResume();
		if (mBMapManager != null) {
			mBMapManager.start();
		}
		super.onResume();
	}
}
