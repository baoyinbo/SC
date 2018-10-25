package com.byb.sc.api.ganhuo;

import com.byb.sc.rxhttp.cache.model.CacheResult;
import com.byb.sc.rxhttp.callback.CallBack;
import com.byb.sc.rxhttp.callback.IType;
import com.byb.sc.rxhttp.utils.Utils;
import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;

/**
 * 类描述：
 *
 * @auther: baoyinbo
 * @date: 2018/10/25 上午10:18
 */

public abstract class GanHuoCallBackProxy<T extends GanHuoCommonResult<R>, R> implements IType<T> {
    CallBack<R> mCallBack;

    public GanHuoCallBackProxy(CallBack<R> callBack) {
        mCallBack = callBack;
    }

    public CallBack getCallBack() {
        return mCallBack;
    }

    @Override
    public Type getType() {//CallBack代理方式，获取需要解析的Type
        Type typeArguments = null;
        if (mCallBack != null) {
            Type rawType = mCallBack.getRawType();//如果用户的信息是返回List需单独处理
            if (List.class.isAssignableFrom(Utils.getClass(rawType, 0)) || Map.class.isAssignableFrom(Utils.getClass(rawType, 0))) {
                typeArguments = mCallBack.getType();
            } else if (CacheResult.class.isAssignableFrom(Utils.getClass(rawType, 0))) {
                Type type = mCallBack.getType();
                typeArguments = Utils.getParameterizedType(type, 0);
            } else {
                Type type = mCallBack.getType();
                typeArguments = Utils.getClass(type, 0);
            }
        }
        if (typeArguments == null) {
            typeArguments = ResponseBody.class;
        }
        Type rawType = Utils.findNeedType(getClass());
        if (rawType instanceof ParameterizedType) {
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        return $Gson$Types.newParameterizedTypeWithOwner(null, rawType, typeArguments);
    }
}
