// "Therefore those skilled at the unorthodox
// are infinite as heaven and earth,
// inexhaustible as the great rivers.
// When they come to an end,
// they begin again,
// like the days and months;
// they die and are reborn,
// like the four seasons."
//
// - Sun Tsu,
// "The Art of War"

package com.theartofdev.fastimageloaderdemo;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.theartofdev.fastimageloader.FastImageLoader;
import com.theartofdev.fastimageloader.ImageLoadSpecBuilder;
import com.theartofdev.fastimageloader.enhancer.ImgIXUriEnhancer;

/**
 * TODO:a add doc
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FastImageLoader
                .init(this)
                .setUriEnhancer(new ImgIXUriEnhancer())
                .setDebugIndicator(true);

        Point p = new Point();
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        display.getSize(p);

        Specs.IMAGE = new ImageLoadSpecBuilder()
                .setDimension(p.x, getResources().getDimensionPixelSize(R.dimen.image_height))
                .setPixelConfig(Bitmap.Config.RGB_565)
                .build();
    }
}

