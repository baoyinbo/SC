package com.byb.sc.ui.stock;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.ui.stock.adapter.CarStockViewPagerAdapter;
import com.byb.sc.utils.ToastShowUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：企业车辆库存
 *
 * @auther: baoyinbo
 * @date: 2018/9/17 下午4:26
 */

public class CarStockFragment extends BaseBackFragment {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tab) TabLayout tab;
    @BindView(R.id.viewPager) ViewPager viewPager;
    private CarStockViewPagerAdapter pagerAdapter;

    public static CarStockFragment newInstance() {
        Bundle args = new Bundle();
        CarStockFragment fragment = new CarStockFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_car_stock, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return attachToSwipeBack(view);
    }


    private void initView(View view){
        initToolbarNav(toolbar);
        tab.addTab(tab.newTab());
        tab.addTab(tab.newTab());

        pagerAdapter = new CarStockViewPagerAdapter(getChildFragmentManager(),
                "在库车辆", "已售车辆");


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ToastShowUtils.showTextToast("" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        viewPager.setAdapter(pagerAdapter);
        tab.setupWithViewPager(viewPager);
    }


    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        pagerAdapter.onFragmentResult(requestCode, resultCode, data);
    }
}
