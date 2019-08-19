package com.ekwing.myanimalsetdemo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ekwing.myanimalsetdemo.R;

public class FrameActivity extends AppCompatActivity {
    private ImageView ivShow;
    private Button btStart;
    private Button btEnd;
    private AnimationDrawable mAnimationDrawable; //逐帧动画
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        initView();
        onClickStart();
        onClickEnd();


    }

    private void onClickEnd() {
        btEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnimationDrawable.stop();
            }
        });
    }

    private void onClickStart() {
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnimationDrawable.start();

            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//标题左侧添加返回按钮
        getSupportActionBar().setHomeButtonEnabled(true);//是否可以点击


        ivShow = findViewById(R.id.iv_center_pic);
        btStart = findViewById(R.id.bt_start);
        btEnd = findViewById(R.id.bt_end);
        mAnimationDrawable = (AnimationDrawable) ivShow.getBackground();
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
