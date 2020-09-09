package com.example.mygadsapp.Fragments;

import android.database.Observable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mygadsapp.R;
import com.example.mygadsapp.adapters.MyRecAdapter;
import com.example.mygadsapp.models.BaseModel;
import com.example.mygadsapp.models.LearnerLeadersModel;
import com.example.mygadsapp.retrofit.MyAPI;
import com.example.mygadsapp.retrofit.MyClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LearningLeadersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewHolder = new ViewHolder(view);
        init();
    }

    private void init() {
        viewHolder.recyclerView.setItemAnimator(new DefaultItemAnimator());
        viewHolder.recyclerView.addItemDecoration(new MarginDecoration());
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        viewHolder.recyclerView.setHasFixedSize(true);

        LoadData();
    }

    void LoadData() {
        Toast.makeText(getContext(), "loading data", Toast.LENGTH_SHORT).show();
        viewHolder.pG.setVisibility(View.VISIBLE);
        Retrofit retrofit = MyClient.getRetrofitClient("https://gadsapi.herokuapp.com/");
        MyAPI myAPI = retrofit.create(MyAPI.class);
        Call<List<LearnerLeadersModel>> observable = myAPI.getHours();
        observable.enqueue(new Callback<List<LearnerLeadersModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<LearnerLeadersModel>> call, @NonNull Response<List<LearnerLeadersModel>> response) {
                viewHolder.pG.setVisibility(View.GONE);
                Log.e("MITAG",response.message());
                if (response.body() != null) {
                    viewHolder.recyclerView.setAdapter(new MyRecAdapter(getContext(), new ArrayList<>(response.body())));
                    return;
                }
                Toast.makeText(getContext(), "Error, please try again", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<List<LearnerLeadersModel>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Error encountered", Toast.LENGTH_SHORT).show();
            }
        });

    }

    ViewHolder viewHolder;

    static class ViewHolder {
        RecyclerView recyclerView;
        ProgressBar pG;

        public ViewHolder(View convertView) {
            recyclerView = (RecyclerView) convertView.findViewById(R.id.recyclerView);
            pG = (ProgressBar) convertView.findViewById(R.id.pG);
        }
    }

}