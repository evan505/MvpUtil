package com.zyf.mvputil;

import android.util.Log;

/**
 * @author zyf
 * @date 2017/12/18
 * @time 16:15
 */

public abstract class AbstractPresenter<V extends BaseView> implements BasePresenter{
    String TAG = "AbstractPresenter";
    private V mView;

//    public void attachView(V view) {
//        mView = view;
//        Log.i(TAG, "----attachView----");
//    }
//
//    public void detachView() {
//        mView = null;
//        Log.i(TAG, "----detachView----");
//    }

    public V getMvpView() {
        Log.i(TAG, "----getMvpView----");
        return mView;
    }

}
