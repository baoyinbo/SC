package com.byb.sc.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

/**
 * 类描述：处理各种字符串的工具集
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午5:25
 */

public class StringUtils {

    /**
     * 修改大小与颜色
     * @param source
     * @param subString
     * @param size
     * @param color
     * Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前后都不包括，即在指定范围的前面和后面插入新字符都不会应用新样式
     * Spannable.SPAN_EXCLUSIVE_INCLUSIVE ：前面不包括，后面包括。即仅在范围字符的后面插入新字符时会应用新样式
     * Spannable.SPAN_INCLUSIVE_EXCLUSIVE ：前面包括，后面不包括。
     * Spannable.SPAN_INCLUSIVE_INCLUSIVE ：前后都包括。
     * @return
     */
    public static SpannableString modifyStrSizeAndColor(String source, String subString, int size, int color) {

        int index = source.indexOf(subString);
        SpannableString style = new SpannableString(source);
        if (index < 0) return style;
        style.setSpan(new ForegroundColorSpan(color), index,
                index + subString.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style.setSpan(new AbsoluteSizeSpan(size, true), index, index + subString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        /**
         * 设置粗斜体
         */
        style.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), index, index + subString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //粗斜体

        return style;
    }
}
