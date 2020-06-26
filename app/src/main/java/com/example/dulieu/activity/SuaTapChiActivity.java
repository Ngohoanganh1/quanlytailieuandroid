package com.example.dulieu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dulieu.R;
//// thêm sửa xóa tạp chí
public class SuaTapChiActivity extends AppCompatActivity {
        TextView txt_so_phat_hanh;
        TextView txt_thang_phat_hanh;
        Button btn_sua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_tap_chi);
        findViewbyID();

        Intent intent = getIntent();
        final String soPhatHanh = intent.getStringExtra("SO_PHAT_HANH");
        final String thangPhatHanh = intent.getStringExtra("THANG_PHAT_HANH");;
        final int index = intent.getIntExtra("INDEX",0);


            txt_thang_phat_hanh.setText(thangPhatHanh);
            txt_so_phat_hanh.setText(soPhatHanh);
            btn_sua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!txt_thang_phat_hanh.getText().toString().trim().isEmpty() && !txt_so_phat_hanh.getText().toString().trim().isEmpty()) {
                        Toast.makeText(SuaTapChiActivity.this, "Sửa thông tin thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TapChiActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("SO_PHAT_HANH", "" + txt_so_phat_hanh.getText().toString());
                        intent.putExtra("THANG_PHAT_HANH", "" + txt_thang_phat_hanh.getText().toString());
                        intent.putExtra("POSITION", index);
                        getApplicationContext().startActivity(intent);
                    }
                }
            });
        }


            private void findViewbyID () {
                txt_so_phat_hanh = findViewById(R.id.txt_sophathanh);
                txt_thang_phat_hanh = findViewById(R.id.txt_thangphathanh);
                btn_sua = findViewById(R.id.btn_sua_tc);
            }
        }
