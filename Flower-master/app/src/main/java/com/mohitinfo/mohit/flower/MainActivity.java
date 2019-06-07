package com.mohitinfo.mohit.flower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FlowerAdapter flowerAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public static final String BASE_URL = "http://services.hanselandpetal.com/";
    private FlowerService service;
    private List<Flower> flowers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(FlowerService.class);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getAllFlowers();



    }

    private void getAllFlowers() {
        Call<List<Flower>> serviceAllFlowers = service.getAllFlowers();

        serviceAllFlowers.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if (response.code() == 200) {

                    flowers = response.body();
                    flowerAdapter = new FlowerAdapter(flowers);
                    recyclerView.setAdapter(flowerAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });
    }
}
