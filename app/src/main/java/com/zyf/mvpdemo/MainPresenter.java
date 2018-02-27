package com.zyf.mvpdemo;

import com.zyf.mvputil.BaseView;
import com.zyf.mvputil.model.Model;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 16:34
 */

public class MainPresenter implements MainContract.Presenter<MainContract.View> {
    MainContract.View mView;
    Model mModel;

    public MainPresenter(Model model) {
        mModel = model;
    }

    @Override
    public void start() {
        mView.showLoadingDialog("loading");
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
    public void attachView(BaseView view) {
        mView = (MainContract.View) view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void interrupHttp() {
        mModel.interrupLoadData();
    }

}
