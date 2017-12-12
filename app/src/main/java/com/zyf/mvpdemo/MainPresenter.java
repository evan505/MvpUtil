package com.zyf.mvpdemo;

import com.zyf.mvputil.BaseActivity;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 16:34
 */

public class MainPresenter implements MainContract.Presenter {
    BaseActivity mBaseActivity;
    MainContract.View mView;

    public MainPresenter(BaseActivity baseActivity, MainContract.View view) {
        mBaseActivity = baseActivity;
        mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}
