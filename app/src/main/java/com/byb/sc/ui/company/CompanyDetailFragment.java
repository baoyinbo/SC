package com.byb.sc.ui.company;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.base.BaseMainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/15 上午9:19
 */

public class CompanyDetailFragment extends BaseBackFragment {
    private static final String ARG_ID = "company_id";
    private Long companyId;

    @BindView(R.id.toolbar) Toolbar toolbar;


    public static CompanyDetailFragment newInstance(Long id) {
        Bundle args = new Bundle();
        args.putLong(ARG_ID, id);
        CompanyDetailFragment fragment = new CompanyDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        companyId = getArguments().getLong(ARG_ID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_company_detail, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return attachToSwipeBack(view);
    }

    private void initView(View view) {
        toolbar.setTitle(R.string.com_detail);
        initToolbarNav(toolbar);
    }

    @OnClick({R.id.llZcode})
    protected void onClick(View view){
        switch (view.getId()) {
            case R.id.llZcode:
                extraTransaction()
                        .setCustomAnimations(R.anim.v_fragment_enter, R.anim.v_fragment_pop_exit,
                                R.anim.v_fragment_pop_enter, R.anim.v_fragment_exit)
                        .start(CompanyZxingFragment.newInstance(0l));
                break;
        }
    }
}
