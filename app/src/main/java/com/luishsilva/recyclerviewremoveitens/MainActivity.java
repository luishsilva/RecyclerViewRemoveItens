package com.luishsilva.recyclerviewremoveitens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this){
            public boolean supportsPredictiveItemAnimations() {
                return true;
            }
        };

        RecyclerView recyclerId = findViewById(R.id.recyclerId);
        recyclerId.setHasFixedSize(true);
        recyclerId.setLayoutManager(linearLayoutManager);
        recyclerId.setItemAnimator(new DefaultItemAnimator());

        arrayList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            arrayList.add(String.valueOf(i));
        }

        MyAdapter adapter = new MyAdapter(getBaseContext(),arrayList);
        recyclerId.setAdapter(adapter);
        adapter.setHolderAdapter(adapter);


    }
}
