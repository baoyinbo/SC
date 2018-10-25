package com.byb.sc.ui.find.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.byb.sc.R;
import com.byb.sc.model.FindResultResponse;
import com.byb.sc.utils.GlideUtil;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/25 上午11:42
 */

public class FindCommonTypeAdapter extends BaseMultiItemQuickAdapter<FindResultResponse> {
    private Context context;
    public FindCommonTypeAdapter(Context context, List<FindResultResponse> data) {
        super(data);
        this.context = context;
        addItemType(FindResultResponse.NO_PIC, R.layout.item_find_common_type_list);
        addItemType(FindResultResponse.ONE_PIC, R.layout.item_find_common_type_one_list);
        addItemType(FindResultResponse.MORE_PIC, R.layout.item_find_common_type_more_list);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FindResultResponse response) {

        switch (baseViewHolder.getItemViewType()) {
            case 0:

                break;
            case 1:
                ImageView ivPic = baseViewHolder.getView(R.id.ivPic);
                GlideUtil.loadImg(context, response.getImages().get(0), ivPic, R.mipmap.ic_error);
                break;

            case 2:
                ImageView ivPic1 = baseViewHolder.getView(R.id.ivPic1);
                ImageView ivPic2 = baseViewHolder.getView(R.id.ivPic2);
                ImageView ivPic3 = baseViewHolder.getView(R.id.ivPic3);

                GlideUtil.loadImg(context, response.getImages().get(0), ivPic1, R.mipmap.ic_error);
                GlideUtil.loadImg(context, response.getImages().get(0), ivPic2, R.mipmap.ic_error);

                if (response.getImages().size() == 2) {
                    ivPic3.setVisibility(View.INVISIBLE);
                } else if (response.getImages().size() > 2){
                    ivPic3.setVisibility(View.VISIBLE);
                    GlideUtil.loadImg(context, response.getImages().get(0), ivPic3, R.mipmap.ic_error);
                }
                break;
        }

        baseViewHolder.setText(R.id.tvTitle, response.getDesc());
        baseViewHolder.setText(R.id.tvWho, "作者：" + response.getWho());
        baseViewHolder.setText(R.id.tvTime, response.getPublishedAt());
        baseViewHolder.setText(R.id.tvType, "类型：" + response.getType());
    }
}
