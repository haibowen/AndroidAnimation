package com.ekwing.myanimalsetdemo.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.ekwing.myanimalsetdemo.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ExposeActivity extends AppCompatActivity {
    private Toolbar toolbar;//标题栏
    private FloatingActionButton fabExpose;//悬浮按钮
    private ImageView ivHead;//头部展示图片
    private CollapsingToolbarLayout cltTitle;//折叠栏
    private Boolean flag = true;
    private int mCenterx;//
    private int mCentery;
    private int mRaduis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expose);

        initToolbar();
        toStartAnimal();
    }

    private void toStartAnimal() {
        fabExpose = findViewById(R.id.fab_expose);
        ivHead = findViewById(R.id.iv_head);
        fabExpose.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (flag) {

                    Animation mAnimation = ivHead.getAnimation();
                    if (mAnimation != null) {
                        mAnimation.cancel();
                    }
                    mCenterx = fabExpose.getWidth() / 2;
                    mCentery = fabExpose.getHeight() / 2;
                    mRaduis = (int) Math.hypot(ivHead.getWidth(), ivHead.getHeight());
                    //*************************************************8
                    Animator mAnimator = (Animator) ViewAnimationUtils.createCircularReveal(ivHead, mCenterx, mCentery, mRaduis, 0);
                    mAnimator.setDuration(1000);
                    mAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            ivHead.setVisibility(View.INVISIBLE);

                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });

                    mAnimator.start();
                    flag = false;

                } else {
                    Animator mAnimator = ViewAnimationUtils.createCircularReveal(ivHead, mCenterx, mCentery, 0, mRaduis);
                    mAnimator.setDuration(1000);
                    ivHead.setVisibility(View.VISIBLE);
                    mAnimator.start();
                    flag = true;

                }

            }
        });
    }

    private void initToolbar() {
        cltTitle = findViewById(R.id.collBar);
        cltTitle.setCollapsedTitleTextColor(Color.WHITE);
        cltTitle.setExpandedTitleColor(Color.WHITE);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("揭露动画");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//标题左侧添加返回按钮
        getSupportActionBar().setHomeButtonEnabled(true);//是否可以点击
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
