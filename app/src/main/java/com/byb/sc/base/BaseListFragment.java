package com.byb.sc.base;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午3:54
 */

public abstract class BaseListFragment extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.refreshLayout) SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recy) RecyclerView recy;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private BaseQuickAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fra_recyclerview, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        refreshLayout.setOnRefreshListener(this);

        recy.setLayoutManager(new LinearLayoutManager(_mActivity));
        recy.setHasFixedSize(true);
        final int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.5f, getResources().getDisplayMetrics());
        recy.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, space);
            }
        });

    }


    public RecyclerView getRecyclerView() {
        return recy;
    }

    public SwipeRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    protected void setAdapter(BaseQuickAdapter adapter) {
        this.adapter = adapter;
        this.adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                onLoadMoreListener();
            }
        });
        this.adapter.openLoadMore(true);
        recy.setAdapter(this.adapter);
    }

    @Override
    public void onRefresh() {
        onPullDownRefreshListener();
    }

    /**
     * 结束下拉刷新
     */
    protected void completePullDownRefresh() {
        refreshLayout.setRefreshing(false);
    }

    /***
     * 下拉刷新回调方法
     */
    protected abstract void onPullDownRefreshListener();

    /***
     * 加载更多回调方法
     */
    protected abstract void onLoadMoreListener();
}
