package com.zyf.mvpdemo;

import android.widget.TextView;

import com.zyf.mvputil.BaseActivity;
import com.zyf.mvputil.model.SourceModel;

/**
 * @author zyf
 * @date 2017/12/12
 */
public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {
    TextView mTvContent;

    @Override
    public void setEmptyView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresent() {
        mPresent = new MainPresenter(this, new SourceModel());
    }

    @Override
    public void initViewAndListener() {
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }



    @Override
    public void showLoadingDialog(String... strings) {
        if (strings.length == 0) {
            showLoadDialog();
        } else if (strings.length == 1) {
            showLoadDialog(strings[0], false);
        }
    }

    @Override
    public void dismissLoadingDialog() {
        dismissLoadDialog();
    }

    @Override
    public void setContent(String content) {
        mTvContent.setText(content);
    }
}
