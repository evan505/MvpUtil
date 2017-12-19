package com.zyf.mvputil;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.zyf.mvputil.widget.CustomProgressDialog;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 15:22
 */
public abstract class BaseActivity<P extends BasePresenter>
        extends AppCompatActivity
        implements BaseView {

    public P mPresent;

    CustomProgressDialog dialog;

    /**
     * 布局文件id
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化present
     */
    public abstract void initPresent();

    /**
     * 初始化View 监听listener
     */
    public abstract void initViewAndListener();

    /**
     *
     */
    public void beforeContentView() {
    }

    /**
     *
     */
    public void afterContentView() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeContentView();
        setContentView(getLayoutId());
        afterContentView();
        initViewAndListener();
        initPresent();
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
        mPresent.attachView(this);
        mPresent.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
//        mPresent.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
//        mPresent.onPause();
    }

    @Override
    protected void onDestroy() {
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
        mPresent.detachView();
        mPresent.stop();
        super.onDestroy();
    }

    /**
     * 重写方法应用的字体不会随系统设置的字体的大小改变而改变
     *
     * @return
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    /**
     * add a keylistener for progress dialog
     */
    private DialogInterface.OnKeyListener onKeyListener = new DialogInterface.OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                dismissLoadDialog();
            }
            return false;

        }
    };


    /**
     * show loading dialog
     */
    public void showLoadDialog() {
        showLoadDialog("", false);
    }


    /**
     * show loading dialog
     *
     * @param text 文本
     * @param b    点击文本外部 dialog是否消失
     */
    public void showLoadDialog(String text, boolean b) {
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        dialog = new CustomProgressDialog(this, R.style.custom_dialog_theme);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(b);

        if (!dialog.isShowing()) {
            dialog.show();
        }
        dialog.setText(text);
        dialog.setOnKeyListener(onKeyListener);
    }


    /**
     * dismiss loading dialog
     */
    public void dismissLoadDialog() {
        if (isFinishing()) {
            return;
        }
        if (null != dialog && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


}
