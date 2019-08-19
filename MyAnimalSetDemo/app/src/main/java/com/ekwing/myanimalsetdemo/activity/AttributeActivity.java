package com.ekwing.myanimalsetdemo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.ekwing.myanimalsetdemo.R;

public class AttributeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btShow;//展示的按钮
    private ImageView ivShowLeft;
    private ImageView ivShowRight;
    private static final String TAG = "Main3Activity";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute);

        initView();
        btShow.setOnClickListener(this);
        Canvas canvas = new Canvas();
        boolean a = canvas.isHardwareAccelerated();
    }

    private void initView() {
        ivShowLeft = findViewById(R.id.iv_left);
        ivShowRight = findViewById(R.id.iv_right);
        btShow = findViewById(R.id.bt_show);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//标题左侧添加返回按钮
        getSupportActionBar().setHomeButtonEnabled(true);//是否可以点击
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bt_show:
                startAnimal();
                break;
        }

    }

    public void startAnimal() {

        ObjectAnimator mObjectAnimator = ObjectAnimator.ofFloat(ivShowLeft, "alpha", 1, 0.5F);
        ObjectAnimator mObjectAnimatorSecond = ObjectAnimator.ofFloat(ivShowRight, "translationY", 200F, 0);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        mAnimatorSet.setDuration(500);
        mAnimatorSet.setInterpolator(new BounceInterpolator());
//        mAnimatorSet.setInterpolator(new CycleInterpolator(4));
//        mAnimatorSet.setInterpolator(new DecelerateInterpolator());
        mAnimatorSet.playTogether(mObjectAnimator, mObjectAnimatorSecond);
        mAnimatorSet.start();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
