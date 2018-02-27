package com.example.pj.myapplication.model.result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pj on 25/02/2018.
 */

public class Name {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("first")
    @Expose
    private String first;

    @SerializedName("last")
    @Expose
    private String last;

    @Override
    public String toString() {
        return "Name{" +
                "title='" + title + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
