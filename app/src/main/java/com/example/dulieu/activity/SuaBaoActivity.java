package com.example.dulieu.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dulieu.R;
///// thêm sửa xóa báo
public class SuaBaoActivity extends AppCompatActivity {
    TextView txt_ngay_phat_hanh;
    EditText edt_masanpham;
    EditText edt_soluong;
    EditText edt_dongia;
    EditText edt_loaisanpham;
    Button btn_sua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_bao);
        findViewById();

        Intent intent = getIntent();
        final String ngayphathanh = intent.getStringExtra("SO_PHAT_HANH");
        final int index = intent.getIntExtra("INDEX", 0);
        final String sosanpham = intent.getStringExtra("sosanpham");
        final String masanpham = intent.getStringExtra("Masp");
        final String soluong = intent.getStringExtra("soluong");
        final String dongia = intent.getStringExtra("dongia");
        final String loaisanpham = intent.getStringExtra("loaisanpham");


        txt_ngay_phat_hanh.setText(ngayphathanh);
        edt_masanpham.setText(masanpham);
//       edt_soluong.setText(soluong);
//        edt_dongia.setText(dongia);
//        edt_loaisanpham.setText(loaisanpham);

        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txt_ngay_phat_hanh.getText().toString().trim().isEmpty()&& !edt_masanpham.getText().toString().trim().isEmpty() ) {
                    Toast.makeText(SuaBaoActivity.this, "Sửa thông tin thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), BaoActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("SO_PHAT_HANH", "" + txt_ngay_phat_hanh.getText().toString());
                    intent.putExtra("Masp", edt_masanpham.getText().toString());
//                   intent.putExtra("soluong", edt_soluong.getText().toString());
//                    intent.putExtra("dongia", edt_dongia.getText().toString());
//                    intent.putExtra("loaisanpham", edt_loaisanpham.getText().toString());
                    intent.putExtra("POSITION", index);
                    getApplicationContext().startActivity(intent);
                }

            }
        });

    }


    private void findViewById() {
        txt_ngay_phat_hanh = findViewById(R.id.txt_ngayphathanh);
        edt_masanpham = findViewById(R.id.edt_masanpham);
        btn_sua = findViewById(R.id.btn_sua_bao);
// ok
    }
}