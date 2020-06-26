package com.example.dulieu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dulieu.R;
import com.example.dulieu.adapter.BaoAdapter;
import com.example.dulieu.adapter.SachAdapter;
import com.example.dulieu.adapter.TapchiAdapter;
import com.example.dulieu.model.Bao;
import com.example.dulieu.model.Sach;
import com.example.dulieu.model.TapChi;

import java.util.ArrayList;
import java.util.List;

public class TapChiActivity extends AppCompatActivity {
    ListView lv_tap_chi;
    ArrayList<TapChi> listTapchi = new ArrayList<>();
    TapchiAdapter tapchiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_chi);
        listTapchi.add(new TapChi("12", "02", 1));
        listTapchi.add(new TapChi("13", "03", 2));
        listTapchi.add(new TapChi("14", "04", 3));
        listTapchi.add(new TapChi("15", "05", 4));
        listTapchi.add(new TapChi("16", "06", 5));
        listTapchi.add(new TapChi("17", "07", 6));

        Intent intent = getIntent();
        String sophathanh = intent.getStringExtra("SO_PHAT_HANH");
        String thangphathanh = intent.getStringExtra("THANG_PHAT_HANH");
        int index = intent.getIntExtra("POSITION",0);
        Log.d("INTENT", "onCreate: "+listTapchi.get(index));

            if ((sophathanh !=null && thangphathanh !=null)){
                listTapchi.get(index).setSophathanh(sophathanh);
                listTapchi.get(index).setThangphathanh(thangphathanh);
            }

        lv_tap_chi = findViewById(R.id.lv_tap_chi);
        Log.d("dsdf", "data: " + listTapchi.toString());
        tapchiAdapter = new TapchiAdapter(listTapchi, getApplicationContext());
        lv_tap_chi.setAdapter(tapchiAdapter);


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
                listTapchi.add(new TapChi("17", "07", 6));
                tapchiAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


