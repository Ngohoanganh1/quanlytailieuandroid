package com.example.dulieu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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

public class BaoAdapter extends BaseAdapter {
    ArrayList<Bao> listBao = new  ArrayList();
    Context context;

    public BaoAdapter(ArrayList<Bao> listBao, Context context) {
        this.listBao = listBao;
        this.context = context;
    }
    @Override
    public int getCount() {
        return listBao.size();
    }

    @Override
    public Object getItem(int position) {
        return listBao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listBao.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
            View view;
        if (convertView == null) {
            view = View.inflate(parent.getContext(), R.layout.item_bao, null);
        } else view = convertView;

        //Bind sữ liệu phần tử vào View

        TextView txtNgaythang =  view.findViewById(R.id.tv_ngay_phat_hanh);

        Button btnXoa = view.findViewById(R.id.bt_xoa_bao);
        Button btnThem = view.findViewById(R.id.bt_them);

        txtNgaythang.setText("Ngày phát hành :"+listBao.get(position).getNgayphathanh());
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBao.remove(position);
                notifyDataSetChanged();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBao.add(new Bao("15/3/1222",listBao.size()+1));
                notifyDataSetChanged();
            }
        });

        return view;
    }
}

