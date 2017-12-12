package com.zyf.mvputil.demo;


import com.zyf.mvputil.BasePresenter;
import com.zyf.mvputil.BaseView;
import com.zyf.mvputil.LifeCyclePresenter;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 15:15
 */

public interface DemoContract {

    interface AgentView extends BaseView {

    }

    interface AgentPresenter extends BasePresenter,LifeCyclePresenter {

    }

}
