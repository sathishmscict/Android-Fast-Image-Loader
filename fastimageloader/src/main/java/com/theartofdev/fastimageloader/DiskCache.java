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

package com.theartofdev.fastimageloader;

import com.theartofdev.fastimageloader.impl.ImageRequest;

import java.io.File;

/**
 * TODO:a add doc
 */
public interface DiskCache {

    /**
     * Gets the representation of the online uri on the local disk.
     *
     * @param uri The online image uri
     * @return The path of the file on the disk
     */
    File getCacheFile(String uri, ImageLoadSpec spec);

    /**
     * Get disk cached image for the given request.<br>
     * If the image is NOT in the cache the callback will be executed immediately.<br>
     * If the image is in cache an async operation will load the image from disk and then execute the callback.
     *
     * @param imageRequest the request to load the image from disk for.
     * @param decoder Used to decode images from the disk to bitmap.
     * @param memoryPool Used to provide reusable bitmaps for image decoding into.
     * @param callback The callback to execute on async requests to the cache
     */
    void getAsync(ImageRequest imageRequest, ImageLoadSpec altSpec, Decoder decoder, MemoryPool memoryPool, Callback callback);

    void imageAdded(long size);

    void clear();

    //region: Inner class: Callbacks

    /**
     * Callback for getting cached image.
     */
    public static interface Callback {

        /**
         * Callback for getting cached image, if not cached will have null.
         */
        void loadImageDiskCacheCallback(ImageRequest imageRequest, boolean canceled);
    }
    //endregion
}