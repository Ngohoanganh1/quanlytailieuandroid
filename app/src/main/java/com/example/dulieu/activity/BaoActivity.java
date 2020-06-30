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
        list_Bao = findViewById(R.id.list_Bao);

        listBao.add(new Bao("10", "10", "10", "10", "10", "SP1", "LOAI1", 1));
        listBao.add(new Bao("11", "10", "10", "10", "10", "SP1", "LOAI2", 2));
        listBao.add(new Bao("10", "10", "10", "10", "10", "SP1", "LOAI3", 3));
        listBao.add(new Bao("10", "10", "10", "10", "10", "SP1", "LOAI4", 4));
        listBao.add(new Bao("10", "10", "10", "10", "10", "SP1", "LOAI5", 5));
        listBao.add(new Bao("10", "10", "10", "10", "10", "SP1", "LOAI6", 6));


        Log.d("dsdf", "data: " + listBao.toString());

        Intent intent = getIntent();
        String masanpham = intent.getStringExtra("M01");
        String tesanpham = intent.getStringExtra("sanpham");
        String dongia = intent.getStringExtra("100.000");
        String loaisanpham = intent.getStringExtra("sp1");
        String sosanpham = intent.getStringExtra("20");
        int index = intent.getIntExtra("POSITION", 0);
        String soluong = intent.getStringExtra("10");
        Log.d("INTENT", "onCreate: " + listBao.get(index));


        if ((masanpham != null && sosanpham != null && dongia != null && loaisanpham != null && soluong != null)) {
            listBao.get(index).setSosanpham(sosanpham);
            listBao.get(index).setDongia(dongia);
            listBao.get(index).setLoaisanpham(loaisanpham);
            listBao.get(index).setMasanpham(masanpham);
            listBao.get(index).setSoluong(soluong);

//            baoAdapter.notifyDataSetChanged();
        }


        baoAdapter = new BaoAdapter(listBao, getApplicationContext());
        list_Bao.setAdapter(baoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnAdd:
                      listBao.add(new Bao("10", "10", "10", "10", "10", "SP1", "LOAI1", 1));
                break;

            case R.id.btn_sanphambanchay:
                listBao.clear();
                listBao.add(new Bao("10", "10", "10", "10", "10", "SP1", "LOAI6", 6));
               baoAdapter = new BaoAdapter(listBao, getApplicationContext());
//                list_Bao.setAdapter(baoAdapter);
                baoAdapter.notifyDataSetChanged();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
