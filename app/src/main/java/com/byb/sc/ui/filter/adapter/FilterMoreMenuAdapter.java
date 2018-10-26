package com.byb.sc.ui.filter.adapter;

import android.content.Context;
import android.widget.TextView;

import com.byb.sc.R;
import com.byb.sc.base.BaseQuickAdapter;
import com.byb.sc.model.FilterMenuModel;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/26 下午3:15
 */

public class FilterMoreMenuAdapter extends BaseQuickAdapter<FilterMenuModel> {
    private Context context;

    public FilterMoreMenuAdapter(Context context, List<FilterMenuModel> data) {
        super(context, R.layout.item_filter_more_menu_list, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FilterMenuModel model) {

        TextView tvName = baseViewHolder.getView(R.id.tvName);
        tvName.setText(model.getName());
        tvName.setSelected(model.isSelect());

    }
}
