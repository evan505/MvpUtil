package com.zyf.mvputil;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 15:09
 */

public interface BasePresenter<V extends BaseView> {
    /**
     * 开启
     */
    void start();

    /**
     * 关闭
     */
    void stop();

    /**
     * 绑定View
     * @param view
     */
    void attachView(V view);

    /**
     * 移除MVP View
     */
    void detachView();

    /**
     * 中断请求
     */
    void interrupHttp();
}
