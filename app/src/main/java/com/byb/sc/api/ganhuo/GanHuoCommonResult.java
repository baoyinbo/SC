package com.byb.sc.api.ganhuo;

import com.byb.sc.rxhttp.model.ApiResult;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/25 上午9:50
 */

public class GanHuoCommonResult<T> extends ApiResult<T>{
    private boolean error;
    private T results;


    public boolean isOk() {
        return !error;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
