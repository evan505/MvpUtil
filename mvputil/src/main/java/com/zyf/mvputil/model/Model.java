package com.zyf.mvputil.model;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 17:39
 */

public interface Model {
    interface DataLoadCallback {

        /**
         * 数据加载成功
         * @param data
         */
        void onDataLoad(String data);

        /**
         * 数据加载失败
         * @param reson
         */
        void onDataLoadFail(String reson);
    }

    /**
     * 获取数据
     *
     * @param params
     * @param callback
     */
    void getData(String params, DataLoadCallback callback);

    /**
     * 移除指定数据
     *
     * @param object
     * @return
     */
    boolean removeData(Object object);

    /**
     * 移除所有数据
     *
     * @return
     */
    boolean removeAll();

    /**
     * 中断加载数据
     */
    void interrupLoadData();
}
