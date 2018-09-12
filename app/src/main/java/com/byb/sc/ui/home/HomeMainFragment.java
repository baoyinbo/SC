package com.byb.sc.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseMainFragment;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午3:12
 */

public class HomeMainFragment extends BaseMainFragment {

    public static HomeMainFragment newInstance() {

        Bundle args = new Bundle();
        HomeMainFragment fragment = new HomeMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_home_main, container, false);
//        initView(view);
        return view;
    }
}
