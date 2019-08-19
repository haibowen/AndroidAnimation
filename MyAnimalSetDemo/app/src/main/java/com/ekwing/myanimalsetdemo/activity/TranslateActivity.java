package com.ekwing.myanimalsetdemo.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;

import com.ekwing.myanimalsetdemo.R;
import com.gyf.immersionbar.ImmersionBar;

public class TranslateActivity extends AppCompatActivity {
    private Context mContext;
    private Button btStart;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        mContext=this;
        ImmersionBar.with(this).statusBarColor(R.color.colorAccent).init();
        exitActivityAnimal();
        startIntent();
        newThread();
    }
    private void newThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }).start();
    }

    private void startIntent() {
        btStart=findViewById(R.id.bt_start);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TranslateActivity.this, FromActivity.class), ActivityOptionsCompat.makeSceneTransitionAnimation(TranslateActivity.this).toBundle());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void exitActivityAnimal() {
        Slide mSlide=new Slide();
        mSlide.setDuration(1500);
        getWindow().setExitTransition(mSlide);
    }


}
