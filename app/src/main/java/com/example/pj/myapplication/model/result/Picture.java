package com.example.pj.myapplication.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pj on 25/02/2018.
 */

public class Picture {

    @SerializedName("large")
    @Expose
    private String large;

    @SerializedName("medium")
    @Expose
    private String medium;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
