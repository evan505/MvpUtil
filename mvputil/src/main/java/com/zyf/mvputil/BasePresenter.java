package com.zyf.mvputil;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 15:09
 */

public interface BasePresenter {
    /**
     * 开启
     */
    void start();

    /**
     * 关闭
     */
    void stop();

    /**
     * 中断请求
     */
    void interrupHttp();
}
