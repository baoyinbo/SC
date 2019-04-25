package com.byb.sc.ui.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.base.BaseWebViewFragment;
import com.byb.sc.base.MultipleStatusView;
import com.byb.sc.model.FindResultResponse;
import com.byb.sc.utils.X5WebView;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.utils.TbsLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/12/4 下午2:37
 */

public class TestWebViewFragment extends BaseBackFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.webview)
    X5WebView webView;
    @BindView(R.id.multipleStatusView)
    MultipleStatusView multipleStatusView;


    public static TestWebViewFragment newInstance() {
        TestWebViewFragment fragment = new TestWebViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_webview, container, false);
        ButterKnife.bind(this, view);
        initView();

        return attachToSwipeBack(view);
    }

    private void initView() {
        initToolbarNav(toolbar);

        WebSettings webSetting = webView.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
//        webSetting.setAppCachePath(this.getDir("appcache", 0).getPath());
//        webSetting.setDatabasePath(this.getDir("databases", 0).getPath());
//        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0)
//                .getPath());
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // webSetting.setPreFectch(true);
        long time = System.currentTimeMillis();
//        if (mIntentUrl == null) {
//            mWebView.loadUrl(mHomeUrl);
//        } else {
//            mWebView.loadUrl(mIntentUrl.toString());
//        }


        webView.loadUrl("http://www.163.com");
        TbsLog.d("time-cost", "cost time: "
                + (System.currentTimeMillis() - time));
        CookieSyncManager.createInstance(this.getContext());
        CookieSyncManager.getInstance().sync();
    }


}
