package com.ekwing.myanimalsetdemo.view;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {
    private float mCenterX;
    private float mCenterY;

    private int mDuration;//持续的事件
    private Camera mCammera = new Camera();

    public MyAnimation(float mCenterX, float mCenterY, int mDuration) {
        this.mCenterX = mCenterX;
        this.mCenterY = mCenterY;
        this.mDuration = mDuration;
    }


    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        setDuration(mDuration);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        // super.applyTransformation(interpolatedTime, t);
        mCammera.save();
        mCammera.translate(100.0f - 100.f * interpolatedTime, 150.0f * interpolatedTime - 150, 80.0f - 80.0f * interpolatedTime);
        mCammera.rotateX(360 * interpolatedTime);
        mCammera.rotateY(360 * interpolatedTime);
        Matrix matrix=t.getMatrix();
        mCammera.getMatrix(matrix);
        matrix.preTranslate(-mCenterX,-mCenterY);
        matrix.postTranslate(mCenterX,mCenterY);
        mCammera.restore();
    }
}
