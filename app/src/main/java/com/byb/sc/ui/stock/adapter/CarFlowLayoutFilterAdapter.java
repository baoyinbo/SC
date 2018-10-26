package com.byb.sc.ui.stock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.byb.sc.R;
import com.byb.sc.model.FilterFlowLayoutModel;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

/**
 * 类描述：筛选条件排列适配器
 *
 * @auther: baoyinbo
 * @date: 2018/10/26 上午9:44
 */

public class CarFlowLayoutFilterAdapter extends TagAdapter<FilterFlowLayoutModel> {
    private Context context;

    public CarFlowLayoutFilterAdapter(Context context, List<FilterFlowLayoutModel> datas) {
        super(datas);
        this.context = context;
    }

    @Override
    public View getView(FlowLayout parent, int position, final FilterFlowLayoutModel model) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_flow_close,
                        parent, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvName);
        tvLabel.setText(model.getName());

        tvLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callListener.itemClick(model);
            }
        });
        return view;
    }


    public interface CallbackListener{
        void itemClick(FilterFlowLayoutModel model);
    }

    /**回调*/
    public CallbackListener callListener;

    public void setCallbackListener (CallbackListener callListener) {
        this.callListener = callListener;
    }
}
