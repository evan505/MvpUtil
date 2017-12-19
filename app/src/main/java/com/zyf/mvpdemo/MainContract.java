package com.zyf.mvpdemo;

import com.zyf.mvputil.BasePresenter;
import com.zyf.mvputil.BaseView;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 16:28
 */

public interface MainContract {
    interface View extends BaseView {
        /**
         * 显示加载弹框
         *
         * @param strings
         */
        void showLoadingDialog(String... strings);

        /**
         * 隐藏加载弹框
         */
        void dismissLoadingDialog();

        void setContent(String content);
    }

    interface Presenter extends BasePresenter {

    }
}
