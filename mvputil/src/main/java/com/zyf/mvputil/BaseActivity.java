package com.zyf.mvputil;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author zyf
 * @date 2017/12/12
 * @time 15:22
 */
public abstract class BaseActivity<P extends BasePresenter & LifeCyclePresenter> extends AppCompatActivity {

    public P mPresent;

    /**
     * 布局文件id
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化present
     */
    public abstract void initPresent();

    public void beforeContentView() {
    }

    public void afterContentView() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeContentView();
        setContentView(getLayoutId());
        afterContentView();
        initPresent();
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
        mPresent.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
        mPresent.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
        mPresent.onPause();
    }

    @Override
    protected void onDestroy() {
        if (mPresent == null) {
            throw new RuntimeException("Varible mPresent might not have been initialized");
        }
        mPresent.stop();
        super.onDestroy();
    }

    /**
     * 重写方法应用的字体不会随系统设置的字体的大小改变而改变
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

}
