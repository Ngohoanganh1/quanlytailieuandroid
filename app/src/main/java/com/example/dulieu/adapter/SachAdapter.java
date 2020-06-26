package com.example.dulieu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dulieu.R;
import com.example.dulieu.activity.SuaTapChiActivity;
import com.example.dulieu.activity.ThemSachActivity;
import com.example.dulieu.model.Bao;
import com.example.dulieu.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachAdapter extends BaseAdapter {
    ArrayList<Sach> listSach = new  ArrayList();
    Context context;

    public SachAdapter(ArrayList<Sach> listSach, Context context) {
       this.listSach = listSach;
       this.context = context;
    }


    @Override
    public int getCount() {
        return listSach.size();
    }

    @Override
    public Object getItem(int position) {
        return listSach.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  listSach.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.sach_item, null);
        }
        //Bind sữ liệu phần tử vào View

        final TextView tentacgia = convertView.findViewById(R.id.tv_tentac_gia);
        final TextView masach = convertView.findViewById(R.id.tv_masach);

        Button btnSua = convertView.findViewById(R.id.btn_sua_sach);
        Button btnXoa = convertView.findViewById(R.id.btn_xoasach);
//them xóa item
        tentacgia.setText("Tên tác giả :"+listSach.get(position).getTentacgia());
        masach.setText("Mã sách :"+listSach.get(position).getMasach());


        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listSach.remove(position);
                notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SuaTapChiActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("TEN TAC GIA", ""+listSach.get(position).getTentacgia());
                intent.putExtra("MA SACH", ""+listSach.get(position).getMasach());
                intent.putExtra("INDEX", position);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}