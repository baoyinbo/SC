package com.byb.sc.ui.filter;

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
 * @date: 2018/9/18 上午10:10
 */

public class FilterSingleAdapter extends BaseQuickAdapter<FilterSingleModel> {
    private Context context;

    public FilterSingleAdapter(Context context, List<FilterSingleModel> data) {
        super(context, R.layout.item_filter_single_list, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FilterSingleModel model) {
        TextView tvName = baseViewHolder.getView(R.id.tvName);
        tvName.setText(model.getName());
        tvName.setSelected(model.isSelect());
        baseViewHolder.setVisible(R.id.ivSelect, model.isSelect());
    }
}
