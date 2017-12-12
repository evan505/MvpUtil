package com.zyf.mvpdemo;

import com.zyf.mvputil.BaseActivity;

/**
 * agent
 *
 * @author zyf
 * @date 2017/12/12
 */
public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    @Override
    public void setEmptyView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresent() {
        mPresent = new MainPresenter(this, this);
    }
}
