package com.byb.sc.ui.stock;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    @BindView(R.id.activityMain) CoordinatorLayout activityMain;
    @BindView(R.id.appBarLayout) AppBarLayout appBarLayout;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tab) TabLayout tab;
    @BindView(R.id.viewPager) ViewPager viewPager;
    private CarStockViewPagerAdapter pagerAdapter;

    @BindView(R.id.toolbar1) View toolbar1;

    @BindView(R.id.toolbar2) View toolbar2;
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.ivSearch) ImageView ivSearch;
    @BindView(R.id.ivCarAdd) ImageView ivCarAdd;

    /**
     * 标记当前显示的页面
     */
    private int viewPagerIndex = 0; //0：在库车辆 1：已售车辆

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
                    setTitle();

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
                viewPagerIndex = position;
                setTitle();
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



    private void setToolbar1Alpha(int alpha) {
//        ivHomeStore1.getDrawable().setAlpha(alpha);
//        ivHomeCarAdd1.getDrawable().setAlpha(alpha);
//        ivHomeCustomer1.getDrawable().setAlpha(alpha);
//        ivHomeSub1.getDrawable().setAlpha(alpha);
//        llSearch.getBackground().setAlpha(alpha);
    }

    private void setToolbar2Alpha(int alpha) {
        ivSearch.getDrawable().setAlpha(alpha);
        ivSearch.getDrawable().setAlpha(alpha);
    }


    private void setTitle() {
        tvTitle.setText(viewPagerIndex == 0 ? "在库车辆" : "已售车辆");
    }
}
