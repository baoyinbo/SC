package com.byb.sc.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.byb.sc.R;

import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午4:29
 */

public abstract class BaseQuickAdapter<T> extends com.chad.library.adapter.base.BaseQuickAdapter<T> {
    private Context context;
    private TextView textView;
    private View footView;
    public BaseQuickAdapter(Context context, int layoutResId, List<T> data) {
        super(layoutResId,data);
        this.context=context;
        footView = LayoutInflater.from(context).inflate(R.layout.layout_list_foot_load_more, null);
        textView=(TextView)footView.findViewById(R.id.textView);

    }


    public BaseQuickAdapter(Context context, List<T> data) {
        this(context,0, data);
    }

    public BaseQuickAdapter(View contentView, List<T> data) {
        this(contentView.getContext(),0, data);
    }

    @Override
    public void addData(List<T> data) {
        super.addData(data);
        if(data==null)return;
        if(getData().size() >= getPageSize()){
            completeLoadMore(data.size() == getPageSize());
        }
    }

    @Override
    public void setNewData(List<T> data) {
        removeAllFooterView();
        super.setNewData(data);
    }

    public Context getContext() {
        return context;
    }

    /**
     * 完成加载更多
     */
    public void completeLoadMore(boolean isNextLoad) {
        completeLoadMore(isNextLoad, null);
    }

    /**
     * 完成加载更多
     *
     * @param title
     */
    public void completeLoadMore(boolean isNextLoad, @Nullable String title) {
        completeLoadMore(isNextLoad,title,null);
    }

    /**
     * 完成加载更多
     *
     * @param title
     */
    public void completeLoadMore(boolean isNextLoad,
                                 @Nullable String title,
                                 @Nullable View.OnClickListener clickListener) {
        if (!isNextLoad) {
            if (!TextUtils.isEmpty(title)) {
                textView.setText(title);
            }else{
                textView.setText(context.getText(R.string.pull_up_over));
            }
            if(clickListener!=null){
                footView.setClickable(true);
                footView.setOnClickListener(clickListener);
            }else{
                footView.setClickable(false);
            }
            if (getFooterLayout() != null) {
                removeFooterView(footView);
            }
            addFooterView(footView);
        }
        notifyDataChangedAfterLoadMore(isNextLoad);
    }
}
