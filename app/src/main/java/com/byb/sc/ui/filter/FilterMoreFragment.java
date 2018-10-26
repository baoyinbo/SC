package com.byb.sc.ui.filter;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.config.FilterMenuEnum;
import com.byb.sc.config.FilterPriceEnum;
import com.byb.sc.model.FilterMenuModel;
import com.byb.sc.model.FilterSingleModel;
import com.byb.sc.ui.filter.adapter.FilterMoreMenuAdapter;
import com.byb.sc.utils.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/26 下午3:00
 */

public class FilterMoreFragment extends BaseBackFragment {

    @BindView(R.id.toolbar) Toolbar toolbar;

    /**
     * 当前菜单位置
     */
    private int MENU_POSITON = 0;
    /**
     * 每个内容项的位置
     */
    private static final int POSITION_BRAND = 0;
    private static final int POSITION_PRICE = 1;
    private static final int POSITION_MODEL = 2;
    private static final int POSITION_GEARBOX = 3;
    private static final int POSITION_AGE = 4;
    private static final int POSITION_MILEAGE = 5;
    private static final int POSITION_DISPLACEMENT = 6;


    /**
     * 左侧菜单
     */
    @BindView(R.id.rvMenu) RecyclerView rvMenu;
    private FilterMoreMenuAdapter menuAdapter;
    private List<FilterMenuModel> menuModels;

    /**
     * 右侧内容
     */
    @BindView(R.id.scrollView) ScrollView scrollView;
    @BindView(R.id.llBrand) LinearLayout llBrand;                   //品牌
    @BindView(R.id.llPrice) LinearLayout llPrice;                   //价格
    @BindView(R.id.llModel) LinearLayout llModel;                   //车型
    @BindView(R.id.llGearbox) LinearLayout llGearbox;               //变速箱
    @BindView(R.id.llAge) LinearLayout llAge;                       //车龄
    @BindView(R.id.llMileage) LinearLayout llMileage;               //里程
    @BindView(R.id.llDisplacement) LinearLayout llDisplacement;     //排放量

    public static FilterMoreFragment newInstance() {
        Bundle args = new Bundle();
        FilterMoreFragment fragment = new FilterMoreFragment();
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
        View view = inflater.inflate(R.layout.fra_filter_more, container, false);
        ButterKnife.bind(this, view);
        test();
        initView();
        return view;
    }

    private void test() {
        //获取价格
        menuModels = new ArrayList<>();
        for (FilterMenuEnum menu : FilterMenuEnum.values()) {
            FilterMenuModel model = new FilterMenuModel();
            model.setName(menu.getName());
            model.setId(menu.getId());
            menuModels.add(model);
        }
        menuModels.get(MENU_POSITON).setSelect(true);
    }

    @SuppressLint("NewApi")
    private void initView() {
        initToolbarClose(toolbar);
        toolbar.setTitle(R.string.filter_more);

        rvMenu.setLayoutManager(new LinearLayoutManager(_mActivity));
        menuAdapter = new FilterMoreMenuAdapter(getContext(), new ArrayList<FilterMenuModel>());
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(_mActivity, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(_mActivity, R.drawable.divide_recyclerview));
        rvMenu.addItemDecoration(divider);
        rvMenu.setAdapter(menuAdapter);
        menuAdapter.setNewData(menuModels);

        menuAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                notifyMenuRecyclerView(i);
                notifyContentScrollView(i);
            }
        });

        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int l, int t, int oldl, int oldt) {
                if (checkIsVisible(llBrand)) {
                    MENU_POSITON = POSITION_BRAND;
                } else if (checkIsVisible(llPrice)) {
                    MENU_POSITON = POSITION_PRICE;
                } else if (checkIsVisible(llModel)) {
                    MENU_POSITON = POSITION_MODEL;
                } else if (checkIsVisible(llGearbox)) {
                    MENU_POSITON = POSITION_GEARBOX;
                } else if (checkIsVisible(llAge)) {
                    MENU_POSITON = POSITION_AGE;
                } else if (checkIsVisible(llMileage)) {
                    MENU_POSITON = POSITION_MILEAGE;
                } else if (checkIsVisible(llDisplacement)) {
                    MENU_POSITON = POSITION_DISPLACEMENT;
                }

                notifyMenuRecyclerView(MENU_POSITON);
                rvMenu.smoothScrollToPosition(MENU_POSITON);
            }
        });
    }


    /**
     * 判断视图可见
     * @param view
     * @return
     */
    public Boolean checkIsVisible(View view) {
        int screenWidth = ScreenUtils.getScreenMetrics(getContext()).x;
        int screenHeight = ScreenUtils.getScreenMetrics(getContext()).y;
        Rect rect = new Rect(0, 0, screenWidth, screenHeight);
        int[] location = new int[2];
        view.getLocationInWindow(location);
        if (view.getLocalVisibleRect(rect)) {
            return true;
        } else {
            //view已不在屏幕可见区域;
            return false;
        }
    }

    /**
     * 更新左侧菜单
     *
     * @param position
     */
    private void notifyMenuRecyclerView(int position) {
        for (int j = 0; j < menuModels.size(); j ++) {
            menuModels.get(j).setSelect(false);
        }
        menuModels.get(position).setSelect(true);

        menuAdapter.notifyDataSetChanged();
    }

    /**
     * 更新右侧内容视图
     * @param position
     */
    private void notifyContentScrollView(int position) {
        scrollView.smoothScrollTo(0, getContentView(position).getTop());
    }

    private LinearLayout getContentView(int position) {
        switch (position) {
            case POSITION_BRAND:
                return llBrand;
            case POSITION_PRICE:
                return llPrice;

            case POSITION_MODEL:
                return llModel;

            case POSITION_GEARBOX:
                return llGearbox;

            case POSITION_AGE:
                return llAge;

            case POSITION_MILEAGE:
                return llMileage;

            case POSITION_DISPLACEMENT:
                return llDisplacement;

            default:
                return llBrand;
        }
    }

}
