package com.ekwing.myanimalsetdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ekwing.myanimalsetdemo.R;
import com.ekwing.myanimalsetdemo.activity.AttributeActivity;
import com.ekwing.myanimalsetdemo.activity.ExposeActivity;
import com.ekwing.myanimalsetdemo.activity.FrameActivity;
import com.ekwing.myanimalsetdemo.activity.ToolActivity;
import com.ekwing.myanimalsetdemo.activity.TranslateActivity;
import com.ekwing.myanimalsetdemo.activity.ViewActivity;
import com.ekwing.myanimalsetdemo.bean.ImageBean;
import com.ekwing.myanimalsetdemo.utils.ConString;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyRecyclerviewAdapter extends RecyclerView.Adapter<MyRecyclerviewAdapter.ViewHolder> {

    private Context mContext;
    private List<ImageBean> mDataList;

    public MyRecyclerviewAdapter(Context mContext, List<ImageBean> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDetial;
        SimpleDraweeView sdIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sdIcon = itemView.findViewById(R.id.iv_show);
            tvDetial = itemView.findViewById(R.id.tv_detial);
        }
    }

    @NonNull
    @Override
    public MyRecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_list_item, parent, false);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerviewAdapter.ViewHolder holder, final int position) {
        ImageBean mImageBean = mDataList.get(position);
        holder.tvDetial.setText(mImageBean.getmTextString());
        Uri uri = Uri.parse("res://" + mContext.getPackageName() + "/" + mImageBean.getImageId());
        Log.e("3333", "onBindViewHolder: " + uri);
        DraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        holder.sdIcon.setController(build);

        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case ConString.FRAME_ACTIVTY:
                        mContext.startActivity(new Intent(mContext, FrameActivity.class));
                        break;
                    case ConString.VIEW_ACTIVITY:
                        mContext.startActivity(new Intent(mContext, ViewActivity.class));
                        break;
                    case ConString.ATTRIBUTE_ACTIVITY:
                        mContext.startActivity(new Intent(mContext, AttributeActivity.class));
                        break;
                    case ConString.EXPOSE_ACTIVITY:
                        mContext.startActivity(new Intent(mContext, ExposeActivity.class));
                        break;
                    case ConString.TRANSLATE_ACTIVITY:
                        mContext.startActivity(new Intent(mContext, TranslateActivity.class));
                        break;
                    case ConString.TYPE_VETOR:
                        mContext.startActivity(new Intent(mContext, ToolActivity.class));
                        break;
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
