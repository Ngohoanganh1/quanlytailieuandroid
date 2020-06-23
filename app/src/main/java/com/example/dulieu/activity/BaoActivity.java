package com.example.dulieu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.dulieu.R;
import com.example.dulieu.adapter.BaoAdapter;
import com.example.dulieu.model.Bao;

import java.util.ArrayList;
import java.util.List;

public class BaoActivity extends AppCompatActivity {
    ListView list_Bao;
    ArrayList<Bao> listBao = new ArrayList<>();
    BaoAdapter baoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao);
        list_Bao = findViewById(R.id.list_Bao);

        listBao.add(new Bao("15/3/1222",listBao.size()+1));
        listBao.add(new Bao("15/3/1222",listBao.size()+1));
        listBao.add(new Bao("15/3/1222",listBao.size()+1));
        Log.d("dsdf", "data: "+listBao.toString());
        baoAdapter = new BaoAdapter(listBao,getApplicationContext());
        list_Bao.setAdapter(baoAdapter);
    }
}
