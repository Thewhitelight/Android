package com.szq;

import java.io.File;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		initImageLoader(getApplicationContext());
	}

	private void initImageLoader(Context context) {
		// TODO Auto-generated method stub
		File cacheDir = StorageUtils.getOwnCacheDirectory(context,
				"Image-Loader/Cache");// 设置缓存目录
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context)
				.memoryCacheExtraOptions(480, 800)
				// 每个缓存文件的最大尺寸，默认为手机屏幕尺寸
				.threadPoolSize(3)
				// 线程池内线程数
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				// Uri MD5加密
				.memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024)
				// 内存最大缓存值
				.diskCacheSize(50 * 1024 * 1024)
				// SD卡最大缓存值
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.diskCache(new UnlimitedDiskCache(cacheDir))
				.imageDownloader(
						new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
				.writeDebugLogs().build();
		ImageLoader.getInstance().init(config);
	}
}
