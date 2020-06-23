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
import com.example.dulieu.activity.TapChiActivity;
import com.example.dulieu.activity.ThemSachActivity;
import com.example.dulieu.model.Bao;
import com.example.dulieu.model.Sach;
import com.example.dulieu.model.TapChi;

import java.util.ArrayList;
import java.util.List;


public class TapchiAdapter extends BaseAdapter {
    ArrayList<TapChi> listTapchi = new  ArrayList();
    Context context;

    public TapchiAdapter (ArrayList<TapChi> listTapchi,Context context){
        this.listTapchi = listTapchi;
        this.context =context;
    }

    @Override
    public int getCount() {
        return listTapchi.size();
    }

    @Override
    public Object getItem(int position) {
        return listTapchi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listTapchi.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){

            view = View.inflate(parent.getContext(), R.layout.item_tapchi, null);
        } else view = convertView;

        //Bind sữ liệu phần tử vào View

        TextView thangphathanh =  view.findViewById(R.id.tv_thang_phat_hanh);
        TextView sophathanh =  view.findViewById(R.id.tv_so_phat_hanh);


        Button btnThem = view.findViewById(R.id.btn_them_tapchi);
        Button btnXoa = view.findViewById(R.id.btn_xoa_tapchi);

        thangphathanh.setText("tháng phát hành :"+listTapchi.get(position).getThangphathanh());
        sophathanh.setText("số phát hành :"+listTapchi.get(position).getSophathanh());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTapchi.remove(position);
                notifyDataSetChanged();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTapchi.add(new TapChi("12", "02", listTapchi.size()+1));
                notifyDataSetChanged();
            }
        });

        return view;
    }
}


