package com.example.dulieu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dulieu.activity.BaoActivity;
import com.example.dulieu.activity.TapChiActivity;
import com.example.dulieu.activity.ThemSachActivity;


public class MainActivity extends AppCompatActivity {
    private Button tvBAO;
    private Button tvtapchi;
    private Button tvSach;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Khoi tao ListProduct, tự sinh một số dữ liệu
        tvBAO = (Button) findViewById(R.id.tvBAO);
        tvtapchi = (Button) findViewById(R.id.tvtapchi);
        tvSach = (Button) findViewById(R.id.tvSach);
        initListener();
    }

    private void initListener() {
        tvBAO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, BaoActivity.class);
                startActivity(intent);

            }

        });
        tvtapchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TapChiActivity.class);
                startActivity(intent);


            }
        });
        tvSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, ThemSachActivity.class);
                startActivity(intent);


            }
        });

    }


    }
