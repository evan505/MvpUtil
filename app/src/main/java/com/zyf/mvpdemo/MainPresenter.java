package com.zyf.mvpdemo;

import com.zyf.mvputil.model.Model;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 16:34
 */

public class MainPresenter implements MainContract.Presenter {
    MainContract.View mView;
    Model mModel;

    public MainPresenter(MainContract.View view, Model model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void start() {
        mView.showLoadingDialog();
        mModel.getData("参数", new Model.DataLoadCallback() {
            @Override
            public void onDataLoad(String data) {
                mView.dismissLoadingDialog();
                mView.setContent(data);
            }

            @Override
            public void onDataLoadFail(String reason) {
                mView.dismissLoadingDialog();
                mView.setContent(reason);
            }
        });
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
