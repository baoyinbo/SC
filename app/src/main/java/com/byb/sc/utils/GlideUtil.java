package com.byb.sc.utils;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.io.File;

/**
 *
 * Glide的为此封装
 */
public final class GlideUtil {

    /**
     * 加载网络图片到imageview
     *
     * @param imgUrl
     * @param imageView
     */
    public static void loadImg(Context context, String imgUrl, ImageView imageView, Integer id) {
        Glide.with(context)
                .load(imgUrl)
                .asBitmap()
                .centerCrop()
                .placeholder(id)
                .error(id)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    /**
     * 从资源文件中加载图片
     *
     * @param imgRes
     * @param imageView
     */
    public static void loadImg(int imgRes, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(imgRes)
                .dontAnimate()
                //.placeholder(R.drawable.bg_placeholder)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    /**
     * 加载本地图片
     * @param path
     * @param imageView
     */
    public static void loadImg(String path, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(path)
                .dontAnimate()
                //.placeholder(R.drawable.bg_placeholder)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    public static void loadWithoutPlaceholder(int imgRes, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(imgRes)
                .dontAnimate()
                .into(imageView);
    }


    /**
     * 加载圆形图片到imageview
     *
     * @param imgUrl
     * @param imageView
     */
    public static void loadRoundImg(Context context, String imgUrl, ImageView imageView, int id) {
        Glide.with(context)
                .load(imgUrl)
                .placeholder(id)
                .error(id)
                .dontAnimate()
                .centerCrop()
                .transform(new GlideCircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    public static void loadRoundImg(int imgRes, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(imgRes)
//                 .placeholder(R.drawable.ic_avater_placeholder)
                .dontAnimate()
                .centerCrop()
                .transform(new GlideCircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    public static void loadRoundImg(File file, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(file)
                // .placeholder(R.drawable.ic_avater_placeholder)
                .dontAnimate()
                .centerCrop()
                .transform(new GlideCircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    public static void loadRoundImg(String uri, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(uri)
                //.placeholder(R.drawable.ic_avater_placeholder)
                .dontAnimate()
                .centerCrop()
                .transform(new GlideCircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
    }

    public static void loadImgUrlWithoutCrop(String imgUrl, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(imgUrl)
                .dontAnimate()
                //.placeholder(R.drawable.bg_placeholder)
                .into(imageView);
    }

    static class GlideCircleTransform extends BitmapTransformation {

        public GlideCircleTransform(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }
}
