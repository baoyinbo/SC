package com.byb.sc.ui.union.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.byb.sc.R;
import com.byb.sc.model.CompanyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午7:30
 */

public class CompanyRecommendViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<CompanyModel> dataList = new ArrayList<>();

    public CompanyRecommendViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CompanyModel> list) {
        if (list.size() <= 0) {
            dataList.clear();
            notifyDataSetChanged();
            return;
        }
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= dataList.size();
        if (position < 0){
            position = dataList.size() + position;
        }

        ViewHolder viewHolder = null;
        View view = LayoutInflater.from(context).inflate(
                R.layout.item_union_company_recommend, null);
        if (viewHolder == null) {
            viewHolder = new ViewHolder(view);
        }
        bindView(viewHolder, dataList.get(position));

        container.addView(view, RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        return view;
    }

    /**
     * 处理数据或点击事件
     * @param viewholder
     * @param data
     */
    private void bindView(ViewHolder viewholder, final CompanyModel data) {

    }

        @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }



    class ViewHolder {

        ViewHolder(View view) {

            view.setTag(this);
        }


    }
}
