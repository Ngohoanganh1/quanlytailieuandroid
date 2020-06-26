package com.example.dulieu.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dulieu.R;
///// thêm sửa xóa báo
public class SuaBaoActivity extends AppCompatActivity {
    TextView txt_ngay_phat_hanh;
    Button btn_sua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_bao);
        findViewById();

        Intent intent = getIntent();
        final String ngayphathanh = intent.getStringExtra("SO_PHAT_HANH");
        final int index = intent.getIntExtra("INDEX", 0);

        txt_ngay_phat_hanh.setText(ngayphathanh);
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txt_ngay_phat_hanh.getText().toString().trim().isEmpty()) {

                    Toast.makeText(SuaBaoActivity.this, "Sửa thông tin thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), BaoActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("NGAY PHAT HANH", "" + txt_ngay_phat_hanh.getText().toString());
                    intent.putExtra("POSITION", index);
                    getApplicationContext().startActivity(intent);
                }

            }
        });

    }


    private void findViewById() {
        txt_ngay_phat_hanh = findViewById(R.id.txt_ngayphathanh);
        btn_sua = findViewById(R.id.btn_sua_bao);
// ok
    }
}