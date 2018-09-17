package com.byb.sc.ui.stock;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.model.StockCarModel;
import com.byb.sc.ui.adapter.UnionCarAdapter;
import com.byb.sc.ui.view.decoration.SpacesItemDecoration;
import com.byb.sc.utils.ResourceUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/17 下午4:39
 */

public class CarOnSaleFragment extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.refreshLayout) SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recy) RecyclerView recy;
    private UnionCarAdapter adapter;

    public static CarOnSaleFragment newInstance() {
        Bundle args = new Bundle();
        CarOnSaleFragment fragment = new CarOnSaleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_car_on_sale, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        refreshLayout.setOnRefreshListener(this);
        recy.setLayoutManager(new LinearLayoutManager(_mActivity));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(_mActivity, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(_mActivity, R.drawable.divide_recyclerview));
        recy.addItemDecoration(new SpacesItemDecoration(0, ResourceUtils.dipToPx(getContext(), 5),
                ResourceUtils.getColor(getContext(), R.color.divide_gray)));
        adapter = new UnionCarAdapter(this.getContext(), new ArrayList<StockCarModel>());
        recy.setAdapter(adapter);
        test();
    }


    /**
     * 测试数据
     */
    private void test() {
        List<StockCarModel> cars = new ArrayList<>();
        for (int i = 0; i < 16; i ++) {
            cars.add(new StockCarModel());
        }
        adapter.setNewData(cars);
    }

    @Override
    public void onRefresh() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        }, 2500);
    }
}
