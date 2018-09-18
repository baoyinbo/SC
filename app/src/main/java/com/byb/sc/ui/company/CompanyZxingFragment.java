package com.byb.sc.ui.company;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.byb.sc.R;
import com.byb.sc.base.BaseBackFragment;
import com.byb.sc.utils.QRCodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：企业二维码
 *
 * @auther: baoyinbo
 * @date: 2018/9/18 下午1:50
 */

public class CompanyZxingFragment extends BaseBackFragment {
    private static final String ARG_ID = "id";

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.ivZxing) ImageView ivZxing;

    public static CompanyZxingFragment newInstance(Long id) {
        Bundle args = new Bundle();
        args.putLong(ARG_ID, id);
        CompanyZxingFragment fragment = new CompanyZxingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_company_zxing, container, false);
        ButterKnife.bind(this, view);
        setView(view);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        Bitmap qrCodeBitmap = QRCodeUtils.createQRCodeBitmap("www.baidu.com", 480, 480);
        ivZxing.setImageBitmap(qrCodeBitmap);
    }

    private void setView(View view) {
        initToolbarClose(toolbar);
    }
}
