package com.zyf.mvputil.model;

import android.os.Handler;
import android.os.Message;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 17:46
 */

public class SourceModel implements Model {

    DataLoadCallback mLoadCallback;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mLoadCallback.onDataLoad(msg.obj.toString());
                    break;
                case 1:
                    break;
            }
            return false;
        }
    });

    @Override
    public void getData(String params, DataLoadCallback callback) {
        mLoadCallback = callback;
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                Message msg = Message.obtain();
                msg.what = 0;
                msg.obj = params;
                mHandler.sendMessage(msg);
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

    public void stop() {

    }
}
