package com.ekwing.myanimalsetdemo.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;

import com.ekwing.myanimalsetdemo.R;
import com.gyf.immersionbar.ImmersionBar;

public class FromActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);
        ImmersionBar.with(this).statusBarColor(R.color.colorAction).init();
        enterActivityAnimal();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void enterActivityAnimal() {
        Fade mFade = new Fade();
        mFade.setDuration(1500);
        getWindow().setEnterTransition(mFade);
    }
}
