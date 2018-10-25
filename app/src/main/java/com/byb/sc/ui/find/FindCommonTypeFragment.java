package com.byb.sc.ui.find;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byb.sc.R;
import com.byb.sc.api.ganhuo.GanHuoListResult;
import com.byb.sc.base.BaseListFragment;
import com.byb.sc.base.BaseWebViewFragment;
import com.byb.sc.base.MultipleStatusView;
import com.byb.sc.config.AppConstant;
import com.byb.sc.model.FindResultResponse;
import com.byb.sc.model.FindTypeModel;
import com.byb.sc.rxhttp.EasyHttp;
import com.byb.sc.rxhttp.callback.CallBackProxy;
import com.byb.sc.rxhttp.callback.SimpleCallBack;
import com.byb.sc.rxhttp.exception.ApiException;
import com.byb.sc.ui.MainFragment;
import com.byb.sc.ui.company.CompanyDetailFragment;
import com.byb.sc.ui.company.CompanyZxingFragment;
import com.byb.sc.ui.find.adapter.FindCommonTypeAdapter;
import com.byb.sc.ui.find.adapter.FindFuliTypeAdapter;
import com.byb.sc.utils.ToastShowUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/24 下午3:36
 */

public class FindCommonTypeFragment extends BaseListFragment {
    /**
     * 记录页面是否已经加载
     */
    private boolean isLoadingFinish = false;

    private int page = 1;

    private FindTypeModel typeModel;
    private FindCommonTypeAdapter typeAdapter;
    private SwipeRefreshLayout refreshLayout;
    private MultipleStatusView multipleStatusView;
    private RecyclerView recyclerView;

    private FindFuliTypeAdapter fuliTypeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    @Override
    protected void onInitView() {
        isLoadingFinish = true;
        multipleStatusView = getMultipleStatusView();
        multipleStatusView.showLoading();
        refreshLayout = getRefreshLayout();

        if (typeModel.getType() == 1) {
            //链接文章
            typeAdapter = new FindCommonTypeAdapter(getContext(), new ArrayList<FindResultResponse>());
            typeAdapter.openLoadMore(AppConstant.PAGE_SIZE, true);
            setAdapter(typeAdapter);

            typeAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, int i) {
                    ((MainFragment)getParentFragment().getParentFragment()).
                            startBrotherFragment(BaseWebViewFragment.newInstance((FindResultResponse)typeAdapter.getItem(i)));
              }
            });

        } else {
            //图片  瀑布流显示
//            recyclerView = getRecyclerView();
//            //使用瀑布流布局,第一个参数 spanCount 列数,第二个参数 orentation 排列方向
//            StaggeredGridLayoutManager recyclerViewLayoutManager =
//                    new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//            //给recyclerView设置LayoutManager
//            recyclerView.setLayoutManager(recyclerViewLayoutManager);

            fuliTypeAdapter = new FindFuliTypeAdapter(getContext(), new ArrayList<FindResultResponse>());
            fuliTypeAdapter.openLoadMore(AppConstant.PAGE_SIZE, true);
            //设置adapter
            setAdapter(fuliTypeAdapter);
        }



        multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multipleStatusView.showLoading();
                getApi();
            }
        });

    }

    private void getData() {
        if (getArguments()!= null) {
            typeModel = (FindTypeModel) getArguments().getSerializable("type");
        }
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        getApi();
    }



    @Override
    protected void onPullDownRefreshListener() {
        page = 1;
        getApi();
    }

    @Override
    protected void onLoadMoreListener() {
        page ++;
        getApi();
    }

    /**
     * 获取网络数据
     */
    private void getApi() {
        EasyHttp.get("http://gank.io/api/data/" + typeModel.getTypeName() + "/" + AppConstant.PAGE_SIZE + "/" + page)
                .execute(new CallBackProxy<GanHuoListResult<List<FindResultResponse>>,
                        List<FindResultResponse>>(new SimpleCallBack<List<FindResultResponse>>() {
                    @Override
                    public void onError(ApiException e) {
                        multipleStatusView.showError();
                    }

                    @Override
                    public void onSuccess(List<FindResultResponse> sectionItems) {
                        refreshLayout.setRefreshing(false);

                        if (page == 1) {
                            if (sectionItems != null && sectionItems.size() > 0) {
                                multipleStatusView.showContent();

                                if (typeModel.getType() == 1) {
                                    typeAdapter.setNewData(sectionItems);
                                    typeAdapter.notifyDataChangedAfterLoadMore(true);
                                } else {
                                    fuliTypeAdapter.setNewData(sectionItems);
                                    fuliTypeAdapter.notifyDataChangedAfterLoadMore(true);
                                }
                            } else {
                                multipleStatusView.showEmpty();
                            }

                        } else {
                            multipleStatusView.showContent();
                            if (typeModel.getType() == 1) {
                                typeAdapter.notifyDataChangedAfterLoadMore(sectionItems, true);
                            } else {
                                fuliTypeAdapter.notifyDataChangedAfterLoadMore(sectionItems, true);
                            }
                        }
                    }
                }) {

                });
    }
}
