package com.byb.sc.ui.filter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 类描述：价格筛选
 *
 * @auther: baoyinbo
 * @date: 2018/9/17 下午8:02
 */

public class FilterPriceFragment extends BaseBackFragment {

    public static FilterPriceFragment newInstance() {
        Bundle args = new Bundle();
        FilterPriceFragment fragment = new FilterPriceFragment();
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
        View view = inflater.inflate(R.layout.fra_filter, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
