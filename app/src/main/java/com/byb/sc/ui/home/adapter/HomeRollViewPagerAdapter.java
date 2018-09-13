package com.byb.sc.ui.home.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.byb.sc.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/13 上午11:27
 */

public class HomeRollViewPagerAdapter extends LoopPagerAdapter {

    private int[] imgs = {
            R.mipmap.banner_1,
            R.mipmap.banner_2,
            R.mipmap.banner_1,
            R.mipmap.banner_2,
    };

    public HomeRollViewPagerAdapter(RollPagerView viewPager) {
        super(viewPager);
    }


    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return imgs.length;
    }
}
