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
import com.example.dulieu.activity.SuaBaoActivity;
import com.example.dulieu.activity.SuaSachActivity;
import com.example.dulieu.activity.SuaTapChiActivity;
import com.example.dulieu.activity.ThemSachActivity;
import com.example.dulieu.model.Bao;
import com.example.dulieu.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class BaoAdapter extends BaseAdapter {
    ArrayList<Bao> listBao = new ArrayList();
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
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_bao, null);
        }
        //Bind sữ liệu phần tử vào View

        final TextView txtTensanpham = convertView.findViewById(R.id.tv_ngay_phat_hanh);
        final TextView tv_MaSp = convertView.findViewById(R.id.tv_MaSp);
        final TextView tv_soluong = convertView.findViewById(R.id.tv_soluong);
        final TextView tv_dongia = convertView.findViewById(R.id.tv_dongia);
        final TextView edt_loaisanpham = convertView.findViewById(R.id.edt_loaisanpham);


        Button btnXoa = convertView.findViewById(R.id.bt_xoa_bao);
        Button btnSua = convertView.findViewById(R.id.bt_sua_bao);

        txtTensanpham.setText("Tên sản phẩm :" + listBao.get(position).getTensanpham());
        tv_MaSp.setText("mã sản phẩm :" + listBao.get(position).getMasanpham());
        tv_soluong.setText("so luong :" + listBao.get(position).getSoluong());
        tv_dongia.setText("don gia :" + listBao.get(position).getDongia());
//        edt_loaisanpham.setText("loai san pham :" + listBao.get(position).getLoaisanpham());
//        txtAmountUserReadMost.setText( listBao.get(position).getSosanpham()+"/"+"Số lượng");

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listBao.remove(position);
                notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SuaBaoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("SO_PHAT_HANH", "" + listBao.get(position).getTensanpham());
                intent.putExtra("loaisanpham", "" + listBao.get(position).getLoaisanpham());
                intent.putExtra("Masp", "" + listBao.get(position).getMasanpham());
                intent.putExtra("soluong", "" + listBao.get(position).getSoluong());
                intent.putExtra("dongia", "" + listBao.get(position).getDongia());
                intent.putExtra("INDEX", position);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}

