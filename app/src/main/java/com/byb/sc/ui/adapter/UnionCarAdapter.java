package com.byb.sc.ui.adapter;

import android.content.Context;

import com.byb.sc.R;
import com.byb.sc.base.BaseQuickAdapter;
import com.byb.sc.model.StockCarModel;
import com.byb.sc.utils.ResourceUtils;
import com.byb.sc.utils.StringUtils;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 类描述：库存车辆 联盟车辆 适配器
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午4:15
 */

public class UnionCarAdapter extends BaseQuickAdapter<StockCarModel> {
    private Context context;
    public UnionCarAdapter(Context context, List<StockCarModel> data) {
        super(context, R.layout.item_stock_car_list, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, StockCarModel stockCarModel) {

        baseViewHolder.setText(R.id.tvPrice,
                StringUtils.modifyStrSizeAndColor("15.60万", "15.60", 17,
                        ResourceUtils.getColor(context, R.color.text_red)));
    }
}
