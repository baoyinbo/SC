package com.byb.sc.ui.filter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.config.FilterPriceEnum;
import com.byb.sc.model.FilterSingleModel;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：价格筛选
 *
 * @auther: baoyinbo
 * @date: 2018/9/17 下午8:02
 */

public class FilterPriceFragment extends BaseBackFragment {
    private static final String TITLE = "title";
    private String title;

    /**
     * 筛选数据
     */
    private List<FilterSingleModel> filters;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recy) RecyclerView recy;
    private FilterSingleAdapter adapter;

    public static FilterPriceFragment newInstance(String title) {
        Bundle args = new Bundle();
        FilterPriceFragment fragment = new FilterPriceFragment();
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_filter, container, false);
        ButterKnife.bind(this, view);
        setView(view);
        return view;
    }

    private void setView(View view) {
        initToolbarClose(toolbar);
        toolbar.setTitle(title);
        adapter = new FilterSingleAdapter(this.getContext(), new ArrayList<FilterSingleModel>());
        recy.setLayoutManager(new LinearLayoutManager(_mActivity));
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(_mActivity, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(_mActivity, R.drawable.divide_recyclerview));
        recy.addItemDecoration(divider);
        recy.setAdapter(adapter);

        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                for (int j = 0; j < adapter.getData().size(); j ++) {
                    adapter.getItem(j).setSelect(false);
                }
                adapter.getItem(i).setSelect(true);
                adapter.notifyDataSetChanged();

            }
        });
    }

    private void getData() {
        if (getArguments() != null) {
            title = getArguments().getString(TITLE,"");
        }

        //获取价格
        filters = new ArrayList<>();
        for (FilterPriceEnum price: FilterPriceEnum.values()) {
            FilterSingleModel model = new FilterSingleModel();
            model.setName(price.getName());
            model.setId(price.getId());
            model.setLowest(price.getLowest());
            model.setHighest(price.getHighest());
            filters.add(model);
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        adapter.setNewData(filters);
    }
}
