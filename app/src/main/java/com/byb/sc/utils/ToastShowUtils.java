package com.byb.sc.utils;

import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import com.byb.sc.App;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午2:36
 */

public class ToastShowUtils {
    private static Toast toast;


    /**
     * 显示文字toast
     * @param text
     */
    public static void showTextToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (toast == null) {
                toast = Toast.makeText(App.getApplication(), text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
            } else {
                toast.setText(text);
            }
            toast.show();
        }
    }

    public static void showTextToast(int id) {
        if (toast == null) {
            toast = Toast.makeText(App.getApplication(),
                    ResourceUtils.getString(App.getApplication(), id),
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(ResourceUtils.getString(App.getApplication(), id));
        }
        toast.show();
    }
}
