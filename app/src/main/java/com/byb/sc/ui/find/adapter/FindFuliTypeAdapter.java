package com.byb.sc.ui.find.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.byb.sc.R;
import com.byb.sc.base.BaseQuickAdapter;
import com.byb.sc.model.FindResultResponse;
import com.byb.sc.utils.GlideUtil;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/25 下午3:54
 */

public class FindFuliTypeAdapter extends BaseQuickAdapter<FindResultResponse> {
    private Context context;

    public FindFuliTypeAdapter(Context context, List<FindResultResponse> data) {
        super(context, R.layout.item_find_fuli_type_list, data);
        this.context = context;
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, FindResultResponse response) {
        GlideUtil.loadImg(context,
                response.getUrl(),
                (ImageView) baseViewHolder.getView(R.id.ivPic),
                R.mipmap.ic_error);
    }
}
