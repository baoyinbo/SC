package com.byb.sc.base;

import com.byb.sc.R;
import com.byb.sc.utils.ToastShowUtils;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/9/12 下午2:25
 */
public abstract class BaseMainFragment extends SupportFragment {
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            ToastShowUtils.showTextToast(R.string.press_again_exit);
        }
        return true;
    }
}
