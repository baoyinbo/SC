package com.byb.sc.ui.filter;

import android.graphics.Typeface;
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
import android.widget.TextView;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.config.FilterPriceEnum;
import com.byb.sc.model.FilterSingleModel;
import com.byb.sc.ui.view.rangeseekbar.OnRangeChangedListener;
import com.byb.sc.ui.view.rangeseekbar.RangeSeekBar;
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

    /**
     * 双向滑动seekbar
     */
    private RangeSeekBar seekBar;
    /**
     * 自定义选择
     */
    private TextView tvCustomer;

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
        adapter.addHeaderView(initHeader());
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

    private View initHeader() {
        View headerView = View.inflate(getContext(), R.layout.layout_comm_range_seekbar, null);

        seekBar = headerView.findViewById(R.id.seekBar);
        tvCustomer = headerView.findViewById(R.id.tvCustomer);

        seekBar.getLeftSeekBar().setTypeface(Typeface.DEFAULT_BOLD);
        /**
         * 设置选中的值类型
         * "0.00"
         * "0"
         */
        seekBar.setIndicatorTextDecimalFormat("0");
        /**
         * 设置范围
         * interval:最小间隔
         */
        seekBar.setRange(0, 60, 5);
        /**
         * 设置当前值
         */
        seekBar.setValue(0, 60);
        /**
         * 设置刻度类型
         */
        seekBar.setTickMarkMode(RangeSeekBar.TRICK_MARK_MODE_OTHER);
        /**
         * 设置刻度
         */
        CharSequence[] cs = new CharSequence[]{"0", "10", "20", "30", "40", "50", "不限" };
        seekBar.setTickMarkTextArray(cs);

        seekBar.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {

                if (leftValue == 0 && rightValue != 60) {
                    tvCustomer.setText((int) rightValue + "以下");
                } else if (leftValue == 0 && rightValue == 60) {
                    tvCustomer.setText("不限");
                } else if (leftValue != 0 && rightValue != 60) {
                    tvCustomer.setText((int)leftValue + "-" + (int)rightValue);
                } else {
                    tvCustomer.setText((int)leftValue + "以上");
                }
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });

        return headerView;
    }
}
