package com.zyf.mvputil.widget;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zyf.mvputil.R;

/**
 *
 *@author zyf
 *@date 2017/12/12
 */
public class CustomProgressDialog extends Dialog {
    private TextView tv_text;

    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressdialog);
        tv_text = (TextView) this.findViewById(R.id.mytext);
    }


    public void setText(String text) {
        if (tv_text != null) {
            tv_text.setText(text);
        }
        checkEmpty();
    }

    private void checkEmpty() {
        if (tv_text != null) {
            if (tv_text.getText().equals("")) {
                tv_text.setVisibility(View.GONE);
            } else {
                tv_text.setVisibility(View.VISIBLE);
            }
        }
    }
}  
