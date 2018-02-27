package com.zyf.mvputil.model;

import android.os.Message;

import com.zyf.mvputil.UIHandler;

/**
 * 模拟数据
 * @author zyf
 * @date 2017/12/12
 * @time 17:46
 */

public class AnalogSourceModel implements Model {

    DataLoadCallback mLoadCallback;

    private UIHandler mUIHandler = new UIHandler() {
        @Override
        protected void handleUIMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mLoadCallback.onDataLoad(msg.obj.toString());
                    break;
                case 1:
                    break;
            }
        }
    };

    @Override
    public void getData(String params, DataLoadCallback callback) {
        mLoadCallback = callback;
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                Message msg = Message.obtain();
                msg.what = 0;
                msg.obj = params;
                mUIHandler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Override
    public boolean removeData(Object object) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public void interrupLoadData() {
        mUIHandler.cancelAllRequest();
    }

    public void stop() {

    }
}
