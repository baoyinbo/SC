package com.byb.sc.ui.union;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseMainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午1:32
 */

public class UnionMainFragment extends BaseMainFragment {
    @BindView(R.id.toolbar) Toolbar toolbar;
    /**
     * 推荐车辆recyclerview
     */
    @BindView(R.id.carRecommendRecyclerView) RecyclerView carRecommendRecyclerView;


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
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        toolbar.setTitle(R.string.tab_union);


    }


    @OnClick({R.id.rlCompany})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlCompany:

                break;
        }

    }
}
