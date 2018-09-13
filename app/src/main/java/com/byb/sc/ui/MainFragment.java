package com.byb.sc.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.ui.home.HomeMainFragment;
import com.byb.sc.ui.view.bar.BottomBar;
import com.byb.sc.ui.view.bar.BottomBarTab;

import me.yokeyword.eventbusactivityscope.EventBusActivityScope;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午2:44
 */

public class MainFragment extends SupportFragment {

    public static final int HOME = 0;       //首页
    public static final int SORCE = 1;      //车源
    public static final int FIND = 2;       //发现
    public static final int MY = 3;         //我的
    private SupportFragment[] fragments = new SupportFragment[4];
    private BottomBar mBottomBar;
    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_main, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(HomeMainFragment.class);
        if (firstFragment == null) {
            fragments[HOME] = HomeMainFragment.newInstance();
            fragments[SORCE] = HomeMainFragment.newInstance();
            fragments[FIND] = HomeMainFragment.newInstance();
            fragments[MY] = HomeMainFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, HOME,
                    fragments[SORCE],
                    fragments[FIND],
                    fragments[MY]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            fragments[HOME] = firstFragment;
            fragments[SORCE] = findChildFragment(HomeMainFragment.class);
            fragments[FIND] = findChildFragment(HomeMainFragment.class);
            fragments[MY] = findChildFragment(HomeMainFragment.class);
        }
    }


    private void initView(View view) {
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mBottomBar
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_home, getString(R.string.tab_home)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_union, getString(R.string.tab_union)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_find, getString(R.string.tab_find)))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.tab_my, getString(R.string.tab_my)));

        // 模拟未读消息
        mBottomBar.getItem(MY).setUnreadCount(9);

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(fragments[position], fragments[prePosition]);

//                BottomBarTab tab = mBottomBar.getItem(HOME);
//                if (position == HOME) {
//                    tab.setUnreadCount(0);
//                } else {
//                    tab.setUnreadCount(tab.getUnreadCount() + 1);
//                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                EventBusActivityScope.getDefault(_mActivity).post(new TabSelectedEvent(position));
            }
        });
    }


    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
    }

    /**
     * start other BrotherFragment
     */
    public void startBrotherFragment(SupportFragment targetFragment) {
        start(targetFragment);
    }

}
