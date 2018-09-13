package com.byb.sc.utils;

import android.content.Context;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午7:53
 */

public class ScreenUtils {
    /**
     * dp2px
     *
     */
    public static int dip2px(Context ctx,float dpValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    /**
     *	p2תdp
     */
    public static int px2dip(Context ctx,float pxValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
