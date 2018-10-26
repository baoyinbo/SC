package com.byb.sc.ui.filter.adapter;

import android.content.Context;
import android.widget.TextView;

import com.byb.sc.R;
import com.byb.sc.base.BaseQuickAdapter;
import com.byb.sc.model.FilterSingleModel;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/26 下午6:23
 */

public class FilterMorePriceAdapter extends BaseQuickAdapter<FilterSingleModel> {

    private Context context;

    public FilterMorePriceAdapter(Context context, List<FilterSingleModel> data) {
        super(context, R.layout.item_filter_more_content_grid, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FilterSingleModel model) {
        TextView tvName = baseViewHolder.getView(R.id.tvName);
        tvName.setText(model.getName());
        tvName.setSelected(model.isSelect());
    }
}
