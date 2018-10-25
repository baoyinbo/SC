package com.byb.sc.ui.stock.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.byb.sc.ui.stock.CarOnSaleFragment;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/17 下午4:38
 */

public class CarStockViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles;

    public CarStockViewPagerAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return CarOnSaleFragment.newInstance();
        } else {
            return CarOnSaleFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        CarOnSaleFragment.fragmentResult(requestCode, resultCode, data);
    }
}
