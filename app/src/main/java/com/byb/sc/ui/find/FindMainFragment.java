package com.byb.sc.ui.find;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.base.BaseMainFragment;
import com.byb.sc.model.FindTypeModel;
import com.byb.sc.ui.find.adapter.FindViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 下午1:32
 */

public class FindMainFragment extends BaseMainFragment {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tabs) TabLayout tabs;
    @BindView(R.id.viewPager) ViewPager viewPager;

    private List<FindTypeModel> types;
    private FindViewPagerAdapter viewPagerAdapter;
    public static FindMainFragment newInstance() {

        Bundle args = new Bundle();
        FindMainFragment fragment = new FindMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_find_main, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        initTpyes();
        for (int i = 0; i < types.size(); i++) {
            tabs.addTab(tabs.newTab().setText(types.get(i).getName()));
        }

        viewPagerAdapter = new FindViewPagerAdapter(getChildFragmentManager(), types);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setOffscreenPageLimit(0);

        //将TabLayout和ViewPager关联起来
        tabs.setupWithViewPager(viewPager);
        //给Tabs设置适配器
        tabs.setTabsFromPagerAdapter(viewPagerAdapter);
        //设置tablayout 滑动
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        toolbar.setTitle("Gank");
    }


    /**
     * 初始化tabs 数据
     */
    private void initTpyes() {
        FindTypeModel model = new FindTypeModel("全部", "all", 1);
        FindTypeModel model0 = new FindTypeModel("推荐", "瞎推荐", 1);
        FindTypeModel model1 = new FindTypeModel("福利", "福利",2);
        FindTypeModel model2 = new FindTypeModel("Android", "Android", 1);
        FindTypeModel model3 = new FindTypeModel("IOS", "iOS", 1);
        FindTypeModel model4 = new FindTypeModel("休息视频", "休息视频",1);
        FindTypeModel model5 = new FindTypeModel("前端", "前端",1);
        FindTypeModel model6 = new FindTypeModel("拓展视频", "拓展视频",1);
        FindTypeModel model7 = new FindTypeModel("App", "App",1);

        types = new ArrayList<>();
        types.add(model);
        types.add(model0);
        types.add(model1);
        types.add(model2);
        types.add(model3);
        types.add(model4);
        types.add(model5);
        types.add(model6);
        types.add(model7);
    }
}
