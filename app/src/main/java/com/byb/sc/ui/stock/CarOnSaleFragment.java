package com.byb.sc.ui.stock;

import android.app.Activity;
import android.content.Intent;
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
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.model.FilterFlowLayoutModel;
import com.byb.sc.model.StockCarModel;
import com.byb.sc.ui.adapter.UnionCarAdapter;
import com.byb.sc.ui.filter.FilterMoreFragment;
import com.byb.sc.ui.filter.FilterPriceFragment;
import com.byb.sc.ui.stock.adapter.CarFlowLayoutFilterAdapter;
import com.byb.sc.ui.view.decoration.SpacesItemDecoration;
import com.byb.sc.utils.ResourceUtils;
import com.byb.sc.utils.ToastShowUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ExtraTransaction;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/17 下午4:39
 */

public class CarOnSaleFragment extends BaseBackFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int FILTER_PRICE = 1000;
    private static final int FILTER_MORE = 1002;

    @BindView(R.id.refreshLayout) SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recy) RecyclerView recy;
    /**
     * 筛选条件流式布局
     */
    @BindView(R.id.flFilter) TagFlowLayout flFilter;
    private CarFlowLayoutFilterAdapter filterAdapter;
    private List<FilterFlowLayoutModel> flowLayoutModels;

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
        initView();
        return view;
    }

    private void initView() {
        refreshLayout.setOnRefreshListener(this);
        recy.setLayoutManager(new LinearLayoutManager(_mActivity));
        //添加自定义分割线
        recy.addItemDecoration(new SpacesItemDecoration(0, ResourceUtils.dipToPx(getContext(), 5),
                ResourceUtils.getColor(getContext(), R.color.bg_app)));
        adapter = new UnionCarAdapter(this.getContext(), new ArrayList<StockCarModel>());
        recy.setAdapter(adapter);
        test();


        if (flowLayoutModels != null && flowLayoutModels.size() >0) {
            flFilter.setVisibility(View.VISIBLE);
        } else {
            flFilter.setVisibility(View.GONE);
        }
        filterAdapter = new CarFlowLayoutFilterAdapter(getContext(), flowLayoutModels);
        flFilter.setAdapter(filterAdapter);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
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

        flowLayoutModels = new ArrayList<>();
        for (int i = 0; i < 6; i ++) {
            FilterFlowLayoutModel model = new FilterFlowLayoutModel();
            model.setName("10-20万元");
            flowLayoutModels.add(model);
        }
    }


    @OnClick({R.id.llFilterBrand, R.id.llFilterPrice,
            R.id.llFilterSort, R.id.llFilterMore})
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.llFilterBrand:

                break;
            case R.id.llFilterPrice:
                ((CarStockFragment)getParentFragment())
                        .startForResult(FilterPriceFragment.newInstance(getString(R.string.filter_price)), FILTER_PRICE);
                break;
            case R.id.llFilterSort:

                break;
            case R.id.llFilterMore:
                ((CarStockFragment)getParentFragment())
                        .startForResult(FilterMoreFragment.newInstance(), FILTER_MORE);
                break;
        }
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


    public static void fragmentResult(int requestCode, int resultCode, Bundle data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case FILTER_PRICE:
                    //价格筛选
                    ToastShowUtils.showTextToast(data.getString("a"));
                    break;
            }
        }
    }
}
