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
        View view;
        if (convertView == null) {
            view = View.inflate(parent.getContext(), R.layout.sach_item, null);
        } else view = convertView;

        //Bind sữ liệu phần tử vào View

        TextView txtTentacgia =  view.findViewById(R.id.tv_tentac_gia);
        TextView txtMasach = view.findViewById(R.id.tv_masach);

        Button btnXoa = view.findViewById(R.id.btn_xoasach);
        Button btnThem = view.findViewById(R.id.btn_themsach);

        txtTentacgia.setText("Tên tác giả :"+listSach.get(position).getTentacgia());
        txtMasach.setText("Mã sách :"+listSach.get(position).getMasach());

        
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listSach.remove(position);
                notifyDataSetChanged();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listSach.add(new Sach("Ngô hoàng anh","05",listSach.size()+1));
                notifyDataSetChanged();
            }
        });

        return null;
    }
}