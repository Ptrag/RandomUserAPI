package com.example.pj.myapplication.model;

import com.example.pj.myapplication.model.result.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Pj on 24/02/2018.
 */

public class JsonFeed {

    @SerializedName("results")
    @Expose
    private ArrayList<Result> results;

    @Override
    public String toString() {
        return "JsonFeed{" +
                "result=" + results +
                '}';
    }

    public ArrayList<Result> getResult() {
        return results;
    }

    public void setResult(ArrayList<Result> result) {
        this.results = result;
    }
}
