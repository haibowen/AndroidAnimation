package com.ekwing.myanimalsetdemo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.ekwing.myanimalsetdemo.R;
import com.ekwing.myanimalsetdemo.base.BaseActivity;
import com.ekwing.myanimalsetdemo.view.MyAnimation;

public class ViewActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivShow;//展示图片
    private Button btStart, btEnd;//按钮
    private Animation mAnimation;//View动画的对应辅助类
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initView();
        btStart.setOnClickListener(this);
        btEnd.setOnClickListener(this);
        //加载动画资源
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.all_animal);
        mAnimation.setFillAfter(true);//动画结束后保留结束状态

    }

    private void initView() {
        btEnd = findViewById(R.id.bt_stop);
        btStart = findViewById(R.id.bt_start);
        ivShow = findViewById(R.id.iv_show_center);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//标题左侧添加返回按钮
        getSupportActionBar().setHomeButtonEnabled(true);//是否可以点击
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_start:

                ivShow.startAnimation(mAnimation);

                break;

            case R.id.bt_stop:
                // testAnimal();
                btEnd.startAnimation(new MyAnimation(100,200,3500));

                break;

        }


    }

    public void testAnimal(){

        //移动
        Animation mTranslateAnimation=new TranslateAnimation(0,500,0,500);
        mTranslateAnimation.setDuration(2000);
        btEnd.startAnimation(mTranslateAnimation);

        //缩放
        Animation mScaleAnimation =new ScaleAnimation(0,2,0,2);
        mScaleAnimation.setDuration(2000);
        btEnd.startAnimation(mScaleAnimation);

        //旋转
        Animation mRotateAnimation =new RotateAnimation(0,270);
        mRotateAnimation.setDuration(200);
        btEnd.startAnimation(mRotateAnimation);

        //透明度
        Animation mAlphaAnimation =new AlphaAnimation(1,0);
        mAlphaAnimation.setDuration(2000);
        btEnd.startAnimation(mAlphaAnimation);


        //组合动画

        //比较animationset 跟 AnimatorSet 的区别
        AnimationSet animatorSet=new AnimationSet(true);
        animatorSet.addAnimation(mAlphaAnimation);
        animatorSet.addAnimation(mRotateAnimation);

        btEnd.startAnimation(animatorSet);

        //动画监听
        mAlphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

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
