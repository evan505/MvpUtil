package com.zyf.mvputil;

import android.os.Handler;
import android.os.Message;

/**
 * 防止handler导致的内存泄露
 *
 * @author zyf
 * @date 2017/12/18
 */
public abstract class UIHandler extends Handler {
    private static final String TAG = UIHandler.class.getSimpleName();

    /**
     * 用于网络请求 本地发送消息 请用 sendMessage
     *
     * @param msg
     */
    public void sendUIMessage(Message msg) {
        if (!isCancel()) {
            sendMessage(msg);
        }
    }

    @Override
    public void handleMessage(Message msg) {
        if (isCancel) {
            /**
             * 移除所有消息和 runnable
             */
            removeCallbacksAndMessages(null);
            return;
        } else {
            handleUIMessage(msg);
        }
    }

    public void setCancelState(boolean is) {
        isCancel = is;
    }

    public boolean isCancel() {
        return isCancel;
    }

    /**
     * 取消所有请求，一般用于activity 生命周期结束
     */
    public void cancelAllRequest() {
        isCancel = true;
    }

    private boolean isCancel = false;

    /**
     * to receive messages.
     *
     * @param msg
     */
    protected abstract void handleUIMessage(Message msg);
}
