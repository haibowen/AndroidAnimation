package com.ekwing.myanimalsetdemo.bean;

public class ImageBean {

    private String mTextString;
    private int ImageId;

    public ImageBean(String mTextString, int imageId) {
        this.mTextString = mTextString;
        ImageId = imageId;
    }

    public String getmTextString() {
        return mTextString;
    }

    public void setmTextString(String mTextString) {
        this.mTextString = mTextString;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}
