package com.example.newapiactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String URL = "https://randomuser.me/";
    Adapter adapter;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        Call<List<Modelforapi>> call = RetrofitInstance.getinstance().api().getdata();
        call.enqueue(new Callback<List<Modelforapi>>() {
            @Override
            public void onResponse(Call<List<Modelforapi>> call, Response<List<Modelforapi>> response) {
                Log.d("data","onResponse"+response);
                List<Modelforapi> modelforapis = response.body();
                adapter = new Adapter(modelforapis, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Modelforapi>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}