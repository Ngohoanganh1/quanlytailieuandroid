package com.example.dulieu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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

        lv_tap_chi = findViewById(R.id.lv_tap_chi);
        listTapchi.add(new TapChi("12", "02", 1));
        listTapchi.add(new TapChi("13", "03", 2));
        listTapchi.add(new TapChi("14", "04", 3));
        listTapchi.add(new TapChi("15", "05", 4));
        listTapchi.add(new TapChi("16", "06", 5));
        listTapchi.add(new TapChi("17", "07", 6));


        Log.d("dsdf", "data: " + listTapchi.toString());
        tapchiAdapter = new TapchiAdapter(listTapchi, getApplicationContext());
        lv_tap_chi.setAdapter(tapchiAdapter);


    }
}
