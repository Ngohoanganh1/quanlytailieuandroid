package com.example.dulieu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dulieu.R;
//// thêm sửa xóa sách
public class SuaSachActivity extends AppCompatActivity {
    TextView txt_tentac_gia;
    TextView txt_masach;
    Button btn_sua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_sach);
        findViewById();

        Intent intent = getIntent();
        final String tentacgia = intent.getStringExtra("TEN TAC GIA");
        final String masach = intent.getStringExtra("MA SACH");
        final int index = intent.getIntExtra("INDEX", 0);

        txt_tentac_gia.setText(tentacgia);
        txt_masach.setText(masach);
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tentacgia.isEmpty() && !masach.isEmpty()) {
                    Toast.makeText(SuaSachActivity.this, "Sửa thông tin thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ThemSachActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("TEN TAC GIA", "" + txt_tentac_gia.getText().toString());
                    intent.putExtra("MA SACH", "" + txt_masach.getText().toString());
                    intent.putExtra("POSITION", index);
                    getApplicationContext().startActivity(intent);
                }
            }
        });
    }

    private void findViewById() {
        txt_tentac_gia = findViewById(R.id.txt_Tentacgia);
        txt_masach = findViewById(R.id.txt_Masach);
        btn_sua = findViewById(R.id.btn_sua_S);
        //
    }
}
