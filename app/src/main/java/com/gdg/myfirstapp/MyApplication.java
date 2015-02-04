package com.gdg.myfirstapp;

import android.app.Application;
import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * @author Santiago Carrillo
 */
public class MyApplication
    extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();
        initImageLoader( getApplicationContext() );
    }

    private void initImageLoader( Context applicationContext )
    {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder( applicationContext ).threadPriority(
            Thread.NORM_PRIORITY - 2 ).denyCacheImageMultipleSizesInMemory().diskCacheFileNameGenerator(
            new Md5FileNameGenerator() ).diskCacheSize( 50 * 1024 * 1024 ) // 50 Mb
            .tasksProcessingOrder( QueueProcessingType.LIFO ).writeDebugLogs() // Remove for release app
            .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init( config );
    }
}
