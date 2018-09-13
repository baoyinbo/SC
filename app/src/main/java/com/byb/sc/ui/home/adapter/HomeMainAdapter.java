package com.byb.sc.ui.home.adapter;

import android.content.Context;

import com.byb.sc.R;
import com.byb.sc.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 类描述：首页适配器
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 上午11:17
 */

public class HomeMainAdapter extends BaseQuickAdapter<String> {
    private Context context;
    public HomeMainAdapter(Context context, List<String> data) {
        super(context, R.layout.item_home_main_list, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {

    }
}
