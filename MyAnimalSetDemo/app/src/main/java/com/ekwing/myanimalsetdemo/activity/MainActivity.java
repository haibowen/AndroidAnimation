package com.ekwing.myanimalsetdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.ekwing.myanimalsetdemo.R;
import com.ekwing.myanimalsetdemo.adapter.MyRecyclerviewAdapter;
import com.ekwing.myanimalsetdemo.bean.ImageBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;//上下文
    private RecyclerView rvList;//列表展示
    private MyRecyclerviewAdapter mRecyclerviewAdapter;//适配器
    private List<ImageBean> mDataList = new ArrayList<>();//数据源


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        Fresco.initialize(mContext);
        ImmersionBar.with(this).statusBarColor(R.color.colorDark).init();
        initData();//数据源
        initRecyclerview();//初始化列表

    }

    private void initRecyclerview() {
        rvList = findViewById(R.id.rv_list);
        rvList.setNestedScrollingEnabled(false);
        mRecyclerviewAdapter = new MyRecyclerviewAdapter(mContext, mDataList);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(mContext, 2);
        rvList.setLayoutManager(mGridLayoutManager);
        rvList.setAdapter(mRecyclerviewAdapter);
    }

    private void initData() {
        ImageBean mImageBean = new ImageBean("逐帧动画", R.drawable.frame);
        mDataList.add(mImageBean);
        ImageBean mImageBeanSecond = new ImageBean("View动画", R.drawable.property_gif);
        mDataList.add(mImageBeanSecond);
        ImageBean mImageBeanthird = new ImageBean("属性动画", R.drawable.md_toolbar_icon);
        mDataList.add(mImageBeanthird);
        ImageBean mImageBeanFourth = new ImageBean("揭露动画", R.drawable.reveal_effect_gif);
        mDataList.add(mImageBeanFourth);
        ImageBean mImageBeanFive=new ImageBean("转场动画",R.drawable.reveal_effect_gif);
        mDataList.add(mImageBeanFive);
        ImageBean mImageBeanSix=new ImageBean("触摸反馈动画",R.drawable.ripple_gif);
        mDataList.add(mImageBeanSix);
    }
}
