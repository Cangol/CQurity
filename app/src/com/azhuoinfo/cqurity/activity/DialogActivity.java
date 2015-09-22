package com.azhuoinfo.cqurity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import com.azhuoinfo.cqurity.R;

/**
 * Created by Administrator on 2015/9/22.
 */
public class DialogActivity extends Activity {
    private Button mClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        findViews();
        initViews();
    }

    protected void findViews(){
        mClose = (Button) findViewById(R.id.btn_close);
    }

    protected  void initViews(){
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
