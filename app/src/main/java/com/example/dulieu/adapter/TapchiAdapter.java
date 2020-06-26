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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dulieu.R;
import com.example.dulieu.activity.SuaTapChiActivity;
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
        if (convertView == null) {

            convertView = View.inflate(parent.getContext(), R.layout.item_tapchi, null);
        }

        final TextView thangphathanh = convertView.findViewById(R.id.tv_thang_phat_hanh);
        final TextView sophathanh = convertView.findViewById(R.id.tv_so_phat_hanh);


        Button btnSua = convertView.findViewById(R.id.btn_sua_tapchi);
        Button btnXoa = convertView.findViewById(R.id.btn_xoa_tapchi);
        //them xóa item
        thangphathanh.setText("tháng phát hành :" + listTapchi.get(position).getThangphathanh());
        sophathanh.setText("số phát hành :" + listTapchi.get(position).getSophathanh());

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTapchi.remove(position);
                notifyDataSetChanged();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SuaTapChiActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("SO_PHAT_HANH", ""+listTapchi.get(position).getSophathanh());
                intent.putExtra("THANG_PHAT_HANH", ""+listTapchi.get(position).getThangphathanh());
                intent.putExtra("INDEX", position);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

 }


