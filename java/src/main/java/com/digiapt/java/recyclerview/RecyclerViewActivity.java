package com.digiapt.java.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digiapt.java.R;

import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity);
        initRecyclerView();
    }

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private void initRecyclerView(){

        mRecyclerView = findViewById(R.id.id_recycler_view);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerViewAdapter = new RecyclerViewAdapter(this, getRecyclerViewModels());
        mRecyclerViewAdapter.notifyDataSetChanged();

        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(false);

        mRecyclerViewAdapter.setOnItemClickListener((view, pos) -> {
        });
    }

    private List<RecyclerViewModel> getRecyclerViewModels() {
        return Arrays.asList(new RecyclerViewModel("1"),new RecyclerViewModel("2"));
    }
}