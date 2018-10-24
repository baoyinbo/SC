package com.byb.sc.api;

import com.byb.sc.rxhttp.EasyHttp;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/24 下午5:09
 */

public class ApiManager {
    private static final long maxCacheAge = 60 * 24 * 7L;
    private static ApiManager apiManager = new ApiManager();



    public void test() {
        EasyHttp.getInstance().setBaseUrl("");
    }
}
