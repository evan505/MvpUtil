package com.zyf.mvpdemo;

import com.zyf.mvputil.BasePresenter;
import com.zyf.mvputil.BaseView;
import com.zyf.mvputil.LifeCyclePresenter;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 16:28
 */

public interface MainContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter, LifeCyclePresenter {

    }
}
