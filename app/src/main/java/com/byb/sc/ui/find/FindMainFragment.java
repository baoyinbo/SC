package com.byb.sc.ui.find;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseMainFragment;

import butterknife.ButterKnife;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午1:32
 */

public class FindMainFragment extends BaseMainFragment {

    public static FindMainFragment newInstance() {

        Bundle args = new Bundle();
        FindMainFragment fragment = new FindMainFragment();
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
}
