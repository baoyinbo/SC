package com.byb.sc.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.byb.sc.R;
import com.byb.sc.base.BaseMainFragment;
import com.byb.sc.ui.MainFragment;
import com.byb.sc.ui.car.CarEditFragment;
import com.byb.sc.ui.home.adapter.HomeMainAdapter;
import com.byb.sc.ui.home.adapter.HomeRollViewPagerAdapter;
import com.byb.sc.ui.stock.CarStockFragment;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午3:12
 */

public class HomeMainFragment extends BaseMainFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.activityMain) CoordinatorLayout activityMain;
    @BindView(R.id.appBarLayout) AppBarLayout appBarLayout;
    @BindView(R.id.refreshLayout) SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;


    @BindView(R.id.toolbar2) View toolbar2;
    @BindView(R.id.ivHomeStore2) ImageView ivHomeStore2;
    @BindView(R.id.ivHomeCarAdd2) ImageView ivHomeCarAdd2;
    @BindView(R.id.ivHomeCustomer2) ImageView ivHomeCustomer2;
    @BindView(R.id.ivHomeSub2) ImageView ivHomeSub2;
    @BindView(R.id.ivHomeSearch2) ImageView ivHomeSearch2;

    @BindView(R.id.toolbar1) View toolbar1;
    @BindView(R.id.llSearch) LinearLayout llSearch;     //搜索栏
    @BindView(R.id.ivHomeStore1) ImageView ivHomeStore1;
    @BindView(R.id.ivHomeCarAdd1) ImageView ivHomeCarAdd1;
    @BindView(R.id.ivHomeCustomer1) ImageView ivHomeCustomer1;
    @BindView(R.id.ivHomeSub1) ImageView ivHomeSub1;

    /**
     * headerview
     */
    private RollPagerView rollPagerView;
    private HomeMainAdapter mainAdapter;
    private HomeRollViewPagerAdapter rollViewPagerAdapter;

    public static HomeMainFragment newInstance() {

        Bundle args = new Bundle();
        HomeMainFragment fragment = new HomeMainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_home_main, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;

    }

    private void initView() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    //完全展开
                    toolbar1.setVisibility(View.VISIBLE);
                    toolbar2.setVisibility(View.GONE);
                    setToolbar1Alpha(255);
                } else if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    //appBarLayout.getTotalScrollRange() == 200
                    //完全折叠
                    toolbar1.setVisibility(View.GONE);
                    toolbar2.setVisibility(View.VISIBLE);
                    setToolbar2Alpha(255);
                } else {//0~200上滑下滑
                    if (toolbar1.getVisibility() == View.VISIBLE) {
//                        //操作Toolbar1
                        int alpha = 300 - 155 - Math.abs(verticalOffset);
                        setToolbar1Alpha(alpha);

                    } else if (toolbar2.getVisibility() == View.VISIBLE) {
                        if (Math.abs(verticalOffset) > 0 && Math.abs(verticalOffset) < 200) {
                            toolbar1.setVisibility(View.VISIBLE);
                            toolbar2.setVisibility(View.GONE);
                            setToolbar1Alpha(255);
                        }
//                        //操作Toolbar2
                        int alpha = (int) (255 * (Math.abs(verticalOffset) / 100f));
                        setToolbar2Alpha(alpha);
                    }
                }
            }
        });

        refreshLayout.setOnRefreshListener(this);

        mainAdapter = new HomeMainAdapter(getContext(), new ArrayList<String>());
        mainAdapter.addHeaderView(initHeaderView());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);


    }


    /**
     * 初始化适配器headerview
     * @return
     */
    private View initHeaderView() {
        View headerView = View.inflate(getContext(), R.layout.layout_home_head, null);
        rollPagerView = headerView.findViewById(R.id.rollPagerView);
        rollPagerView.setHintView(new ColorPointHintView(this.getContext(), Color.WHITE, 0xccddd7d2));
        rollViewPagerAdapter = new HomeRollViewPagerAdapter(rollPagerView);
        rollPagerView.setAdapter(rollViewPagerAdapter);
        return headerView;
    }

    @Override
    public void onRefresh() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        }, 2500);
    }

    private void setToolbar1Alpha(int alpha) {
        ivHomeStore1.getDrawable().setAlpha(alpha);
        ivHomeCarAdd1.getDrawable().setAlpha(alpha);
        ivHomeCustomer1.getDrawable().setAlpha(alpha);
        ivHomeSub1.getDrawable().setAlpha(alpha);
        llSearch.getBackground().setAlpha(alpha);
    }

    private void setToolbar2Alpha(int alpha) {
        ivHomeStore2.getDrawable().setAlpha(alpha);
        ivHomeCarAdd2.getDrawable().setAlpha(alpha);
        ivHomeCustomer2.getDrawable().setAlpha(alpha);
        ivHomeSub2.getDrawable().setAlpha(alpha);
        ivHomeSearch2.getDrawable().setAlpha(alpha);
    }

    @OnClick({R.id.ivHomeStore1, R.id.ivHomeStore2, R.id.ivHomeCarAdd1, R.id.ivHomeCarAdd2})
    protected void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.ivHomeStore1:
            case R.id.ivHomeStore2:
                /**
                 * 库存
                 */
//                ((MainFragment)getParentFragment()).startBrotherFragment(CarStockFragment.newInstance());
                ((MainFragment)getParentFragment()).start(CarStockFragment.newInstance());
                break;

            case R.id.ivHomeCarAdd1:
            case R.id.ivHomeCarAdd2:
                /**
                 * 添加车辆
                 */
                ((MainFragment)getParentFragment()).startBrotherFragment(CarEditFragment.newInstance());
                break;
        }
    }
}
