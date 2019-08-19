package com.ekwing.myanimalsetdemo.base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.ekwing.myanimalsetdemo.R;
import com.facebook.drawee.backends.pipeline.Fresco;

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mContext=this;
        Fresco.initialize(mContext);
        initToolbar();

    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//标题左侧添加返回按钮
        getSupportActionBar().setHomeButtonEnabled(true);//是否可以点击
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:

                finish();
                break;
        }
        return true;
    }
}
