package com.szq;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.image_loader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MainActivity extends Activity {
	private ListView lv;
	private String[] imgUrls = ImageUrl.imgUrls;
	DisplayImageOptions options;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.loading)
				// 载入时显示的图片
				.showImageForEmptyUri(R.drawable.loading_empty)
				// uri为空时或错误时加载的图片
				.showImageOnFail(R.drawable.loading_fail)
				// 图片加载错误或解码错误时加载的图片
				.cacheInMemory(true)
				// 是否使用内存缓存
				.cacheOnDisk(true)
				// 是否使用SD卡缓存
				.imageScaleType(ImageScaleType.EXACTLY)
				.considerExifParams(true).build();
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new MyAdapter(getBaseContext()));
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		AnimateFirstDisplayListener.displayedImages.clear();
	}

	public class MyAdapter extends BaseAdapter {
		private LayoutInflater mInflater;
		private AnimateFirstDisplayListener animateFirstListener = new AnimateFirstDisplayListener();

		public MyAdapter(Context context) {
			// TODO Auto-generated constructor stub
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imgUrls.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return imgUrls[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder viewHolder;
			View view = convertView;
			if (convertView == null) {
				viewHolder = new ViewHolder();
				view = mInflater.inflate(R.layout.layout_listview_item, parent,
						false);
				viewHolder.img = (ImageView) view.findViewById(R.id.img);
				view.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) view.getTag();
			}
			ImageLoader.getInstance().displayImage(imgUrls[position],
					viewHolder.img, options, animateFirstListener);
			return view;
		}

	}

	public class ViewHolder {
		private ImageView img;
	}

	private static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {

		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}
}
