package com.byb.sc.ui.car;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：编辑 & 添加车辆
 *
 * @auther: baoyinbo
 * @date: 2018/9/19 下午1:45
 */

public class CarEditFragment extends BaseBackFragment {
    @BindView(R.id.toolbar) Toolbar toolbar;

    public static CarEditFragment newInstance() {
        Bundle args = new Bundle();
        CarEditFragment fragment = new CarEditFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_car_edit, container, false);
        ButterKnife.bind(this, view);
        setView();
        return attachToSwipeBack(view);
    }

    private void setView() {
        toolbar.setTitle(R.string.car_add);
        initToolbarNav(toolbar);

    }
}
