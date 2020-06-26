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
import android.view.View;
import android.widget.AdapterView;
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

public class ThemSachActivity extends AppCompatActivity {
    ListView list_Sach;
    ArrayList<Sach> listSach = new ArrayList<>();
    SachAdapter sachAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        list_Sach = findViewById(R.id.list_Sach);

        listSach.add(new Sach("NGÔ HOÀNG ANH", "01", 1));
        listSach.add(new Sach("NGÔ HOÀNG ANH", "02", 1));
        listSach.add(new Sach("NGÔ HOÀNG ANH", "03", 1));
        listSach.add(new Sach("NGÔ HOÀNG ANH", "04", 1));
        listSach.add(new Sach("NGÔ HOÀNG ANH", "05", 1));

        Intent intent = getIntent();
        String tentacgia = intent.getStringExtra("TEN TAC GIA");
        String masach = intent.getStringExtra("MA SACH");
        int index = intent.getIntExtra("POSITION", 0);
        Log.d("INTENT", "onCreate: " + listSach.get(index));

        if ((tentacgia != null && masach != null)) {
            listSach.get(index).setMasach(masach);
            listSach.get(index).setTentacgia(tentacgia);
        }

        list_Sach = findViewById(R.id.list_Sach);
        Log.d("dsdf", "data: " + listSach.toString());
        sachAdapter = new SachAdapter(listSach, getApplicationContext());
        list_Sach.setAdapter(sachAdapter);

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
                listSach.add(new Sach("NGÔ HOÀNG ANH", "01", 6));
                sachAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
