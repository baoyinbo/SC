package com.byb.sc.ui.find.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.byb.sc.base.BaseListFragment;
import com.byb.sc.model.FindTypeModel;
import com.byb.sc.ui.find.FindCommonTypeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/24 下午3:05
 */

public class FindViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseListFragment> fragments;
    private List<FindTypeModel> types;

    public FindViewPagerAdapter(FragmentManager fm, List<FindTypeModel> types) {
        super(fm);
        this.types = types;
        fragments = new ArrayList<>();

        for (int i = 0; i < types.size(); i ++) {
            FindCommonTypeFragment fragment = new FindCommonTypeFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("type", types.get(i));
            fragment.setArguments(bundle);

            fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return types.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return types.get(position).getName();//页卡标题
    }
}
