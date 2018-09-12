package com.byb.sc.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.byb.sc.base.BaseListFragment;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午3:12
 */

public class HomeMainFragment extends BaseListFragment {

    public static HomeMainFragment newInstance() {

        Bundle args = new Bundle();
        HomeMainFragment fragment = new HomeMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    }

    @Override
    protected void onPullDownRefreshListener() {

    }

    @Override
    protected void onLoadMoreListener() {

    }
}
