package com.example.dulieu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.dulieu.R;
import com.example.dulieu.adapter.BaoAdapter;
import com.example.dulieu.adapter.SachAdapter;
import com.example.dulieu.adapter.TapchiAdapter;
import com.example.dulieu.model.Bao;
import com.example.dulieu.model.TapChi;

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
        listBao.add(new Bao("15/3/1222",listBao.size()+1));
        listBao.add(new Bao("15/3/1222",listBao.size()+1));
        listBao.add(new Bao("15/3/1222",listBao.size()+1));


         Intent intent = getIntent();
         String ngayphathanh = intent.getStringExtra("NGAY_PHAT_HANH");
        int index = intent.getIntExtra("POSITION",0);
        Log.d("INTENT","onCreate: "+listBao.get(index));

        if ((ngayphathanh !=null)){
           listBao.get(index).setNgayphathanh(ngayphathanh);
        }

        list_Bao = findViewById(R.id.list_Bao);
        Log.d("dsdf", "data: " + listBao.toString());
        baoAdapter = new BaoAdapter(listBao, getApplicationContext());
        list_Bao.setAdapter(baoAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubao,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.btnAdd:
                listBao.add(new Bao("11",01));
                baoAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
