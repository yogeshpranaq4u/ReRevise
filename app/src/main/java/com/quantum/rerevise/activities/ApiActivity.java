package com.quantum.rerevise.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quantum.rerevise.R;

import java.util.List;

import adapters.ApiAdapter;
import interfaces.ApiClient;
import interfaces.ApiInterface;
import model.ApiModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {

    public static final String TAG="MainApiActivity";
    RecyclerView recyclerView;
    ApiAdapter apiAdapter=new ApiAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_activity);

        recyclerView=findViewById(R.id.api_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(apiAdapter);

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<List<ApiModel>> models=apiInterface.getList();

        models.enqueue(new Callback<List<ApiModel>>() {
            @Override
            public void onResponse(Call<List<ApiModel>> call, Response<List<ApiModel>> response) {
                apiAdapter.setList(response.body());
                apiAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ApiModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });
    }
}
