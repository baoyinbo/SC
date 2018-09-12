package com.byb.sc.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.byb.sc.R;
import com.byb.sc.base.BaseMainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午3:12
 */

public class HomeMainFragment extends BaseMainFragment {
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
    @BindView(R.id.llSearch) View llSearch;     //搜索栏
    @BindView(R.id.ivHomeStore1) ImageView ivHomeStore1;
    @BindView(R.id.ivHomeCarAdd1) ImageView ivHomeCarAdd1;
    @BindView(R.id.ivHomeCustomer1) ImageView ivHomeCustomer1;
    @BindView(R.id.ivHomeSub1) ImageView ivHomeSub1;

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

        return view;

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
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


        
    }



    private void setToolbar1Alpha(int alpha) {
        ivHomeStore1.getDrawable().setAlpha(alpha);
        ivHomeCarAdd1.getDrawable().setAlpha(alpha);
        ivHomeCustomer1.getDrawable().setAlpha(alpha);
        ivHomeSub1.getDrawable().setAlpha(alpha);
        llSearch.setAlpha(alpha);
    }

    private void setToolbar2Alpha(int alpha) {
        ivHomeStore2.getDrawable().setAlpha(alpha);
        ivHomeCarAdd2.getDrawable().setAlpha(alpha);
        ivHomeCustomer2.getDrawable().setAlpha(alpha);
        ivHomeSub2.getDrawable().setAlpha(alpha);
        ivHomeSearch2.getDrawable().setAlpha(alpha);
    }

}
