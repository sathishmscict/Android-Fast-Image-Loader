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
import android.graphics.Bitmap;

import com.theartofdev.fastimageloader.FastImageLoader;
import com.theartofdev.fastimageloader.ImageLoadSpecBuilder;
import com.theartofdev.fastimageloader.UriEnhancerImgIX;

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FastImageLoader
                .init(this)
                .setUriEnhancer(new UriEnhancerImgIX())
                .setDebugIndicator(true);

        Specs.IMAGE = new ImageLoadSpecBuilder()
                .setDimensionByDisplay()
                .setHeightByResource(getResources().getDimensionPixelSize(R.dimen.image_height))
                .setPixelConfig(Bitmap.Config.RGB_565)
                .build();
    }
}

