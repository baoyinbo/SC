package com.byb.sc.ui.find;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.byb.sc.base.BaseListFragment;
import com.byb.sc.model.FindTypeModel;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/24 下午3:36
 */

public class FindCommonTypeFragment extends BaseListFragment {

    private FindTypeModel typeModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    private void getData() {
        if (getArguments()!= null) {
            typeModel = (FindTypeModel) getArguments().getSerializable("type");
        }
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
