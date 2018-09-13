package com.byb.sc.ui.adapter;

import android.content.Context;

import com.byb.sc.R;
import com.byb.sc.base.BaseQuickAdapter;
import com.byb.sc.model.StockCarModel;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 类描述：库存车辆 联盟车辆 适配器
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午4:15
 */

public class UnionCarAdapter extends BaseQuickAdapter<StockCarModel> {

    public UnionCarAdapter(Context context, List<StockCarModel> data) {
        super(context, R.layout.item_stock_car_list, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, StockCarModel stockCarModel) {

    }
}
