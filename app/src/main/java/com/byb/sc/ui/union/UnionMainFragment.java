package com.byb.sc.ui.union;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseMainFragment;
import com.byb.sc.model.CompanyModel;
import com.byb.sc.model.StockCarModel;
import com.byb.sc.ui.adapter.UnionCarAdapter;
import com.byb.sc.ui.union.adapter.CompanyRecommendViewPagerAdapter;
import com.byb.sc.ui.view.ScalePagerTransformer;
import com.byb.sc.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午1:32
 */

public class UnionMainFragment extends BaseMainFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.refreshLayout) SwipeRefreshLayout refreshLayout;

    /**
     * 推荐商户
     */
    @BindView(R.id.vpGaller) ViewPager vpGaller;
    private CompanyRecommendViewPagerAdapter companyAdapter;


    /**
     * 推荐车辆recyclerview
     */
    @BindView(R.id.carRecommendRecyclerView) RecyclerView carRecommendRecyclerView;
    private UnionCarAdapter adapter;

    public static UnionMainFragment newInstance() {
        Bundle args = new Bundle();
        UnionMainFragment fragment = new UnionMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_union_main, container, false);
        ButterKnife.bind(this, view);

        initCompanyRecommendView();
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        toolbar.setTitle(R.string.tab_union);

        refreshLayout.setOnRefreshListener(this);

        carRecommendRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(_mActivity, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(_mActivity, R.drawable.divide_recyclerview));
        carRecommendRecyclerView.addItemDecoration(divider);

        adapter = new UnionCarAdapter(this.getContext(), new ArrayList<StockCarModel>());

        carRecommendRecyclerView.setAdapter(adapter);
        /**
         * scrollview 包含 recyclerView
         * 滑动不流畅解决
         */
        carRecommendRecyclerView.setNestedScrollingEnabled(false);


        test();
    }

    /**
     * 测试数据
     */
    private void test() {
        List<StockCarModel> cars = new ArrayList<>();
        for (int i = 0; i < 6; i ++) {
            cars.add(new StockCarModel());
        }
        adapter.setNewData(cars);
    }

    private List<CompanyModel> testCompany() {
        List<CompanyModel> companys = new ArrayList<>();
        for (int i = 0; i < 6; i ++) {
            companys.add(new CompanyModel());
        }

        return companys;
    }


    private void initCompanyRecommendView() {
        vpGaller.setOffscreenPageLimit(3);
        vpGaller.setPageTransformer(true, new ScalePagerTransformer());
        //设置Pager之间的间距
        vpGaller.setPageMargin(ScreenUtils.dip2px(this.getContext(), 20));
        companyAdapter = new CompanyRecommendViewPagerAdapter(this.getContext());
        companyAdapter.setDatas(testCompany());
        vpGaller.setAdapter(companyAdapter);
        vpGaller.setCurrentItem(2000, true);
    }

    @OnClick({R.id.rlCompany})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlCompany:

                break;
        }

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
}
