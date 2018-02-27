package com.example.pj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.pj.myapplication.model.JsonFeed;
import com.example.pj.myapplication.model.result.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "https://randomuser.me/";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        RandomPersonAPI randomPersonAPI = retrofit.create(RandomPersonAPI.class);
        Call<JsonFeed> call= randomPersonAPI.getData();

        call.enqueue(new Callback<JsonFeed>() {
            @Override
            public void onResponse(Call<JsonFeed> call, Response<JsonFeed> response) {
                Log.d(TAG, "onResposne: " + response.toString());
                Log.d(TAG, "onResponse: recived infomation: " + response.body().toString());

                ArrayList<Result> results = response.body().getResult();
                ArrayList<PersonData> personData = new ArrayList<>();
                for(int i = 0; i < results.size(); i++){
                    Log.d(TAG, "onRwsponse: " + "\n full name: " +
                            results.get(i).getName().getTitle() + " " +
                            results.get(i).getName().getFirst() + " " +
                            results.get(i).getName().getLast() + "\nemail: " +
                            results.get(i).getEmail() + "\nphone: " +
                            results.get(i).getCell() + "\nlocation: " +
                            results.get(i).getLocation().getCity() + " " +
                            results.get(i).getLocation().getStreet() + "\ndob: " +
                            results.get(i).getDob() + "\nimg url: " +
                            results.get(i).getPicture().getThumbnail() +
                            "\n______________________________________\n");

                    personData.add(new PersonData(
                            results.get(i).getName().getFirst(),
                            results.get(i).getName().getLast(),
                            results.get(i).getName().getTitle(),
                            results.get(i).getEmail(),
                            results.get(i).getLogin().getUsername(),
                            results.get(i).getCell(),
                            results.get(i).getLocation().getCity(),
                            results.get(i).getLocation().getStreet(),
                            results.get(i).getDob(),
                            results.get(i).getPicture().getThumbnail(),
                            results.get(i).getPicture().getMedium()

                    ));
                }
                for(int i = 0; i < personData.size();i++){
                    Log.d(TAG, "onResponse: \nName:  "+ personData.get(i).getFirstName() +
                    "\nPicture url: " + personData.get(i).getPictureMediumSizeUrl() +
                    "\nPhone: " + personData.get(i).getPhone());
                }

                ListView listView = findViewById(R.id.listView);
                PersonListAdapter personListAdapter = new PersonListAdapter(MainActivity.this,R.layout.card_view,personData);
                listView.setAdapter(personListAdapter);

            }

            @Override
            public void onFailure(Call<JsonFeed> call, Throwable t) {
                Log.e(TAG,"somethignn wrong!" + t.getMessage());
            }
        });

    }
}
