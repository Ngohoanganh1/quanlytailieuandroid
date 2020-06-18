package com.example.dulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;
    ArrayList<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Khoi tao ListProduct, tự sinh một số dữ liệu
        listProduct = new ArrayList<>();
        listProduct.add(new Product(01, "Hoàng Thu Thảo", 500));
        listProduct.add(new Product(02, " Hoàng Thu Thảo", 700));
        listProduct.add(new Product(04, "Nam Cao", 800));
        listProduct.add(new Product(05, "Hoàng Thu Thảo", 800));
        listProduct.add(new Product(06, "Ngô Hoàng Anh", 800));
        listProduct.add(new Product(07, "Hồ Xuân Hương", 900));
        listProduct.add(new Product(0, " Hoàng Thu Thảo", 500));
        listProduct.add(new Product(0, " Hoàng Thu Thảo", 700));
        listProduct.add(new Product(10, "Hoàng Thu Thảo", 800));
        listProduct.add(new Product(11, "Hoàng Thu Thảo", 900));


     listViewProduct = findViewById(R.id.listproduct);
        productListViewAdapter = new ProductListViewAdapter(listProduct);
        listViewProduct.setAdapter(productListViewAdapter);

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                Toast.makeText(MainActivity.this, product.name, Toast.LENGTH_LONG).show();
            }
        });


        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listProduct.size() > 0) {
                    //Xoá phần tử đầu tiên của danh sách
                    int productpost = 0;
                    listProduct.remove(productpost);
                    //Thông báo cho ListView biết dữ liệu đã thay đổi (cập nhật, xoá ...)
                    productListViewAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    //Model phần tử dữ liệu hiện
    class Product {
        String name;
        int price;
        int productID;

        public Product(int productID, String name, int price) {
            this.name = name;
            this.price = price;
            this.productID = productID;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    class ProductListViewAdapter extends BaseAdapter {

        //Dữ liệu liên kết bởi Adapter là một mảng các sản phẩm
        final ArrayList<Product> listProduct;

        ProductListViewAdapter(ArrayList<Product> listProduct) {
            this.listProduct = listProduct;
        }

        @Override
        public int getCount() {
            //Trả về tổng số phần tử, nó được gọi bởi ListView
            return listProduct.size();
        }

        @Override
        public Object getItem(int position) {
            //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
            //có chỉ số position trong listProduct
            return listProduct.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Trả về một ID của phần
            return listProduct.get(position).productID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            View viewProduct;
            if (convertView == null) {
                viewProduct = View.inflate(parent.getContext(), R.layout.sach_item, null);
            } else viewProduct = convertView;

            //Bind sữ liệu phần tử vào View
            Product product = (Product) getItem(position);
            ((TextView) viewProduct.findViewById(R.id.idproduct)).setText(String.format("MÃ = %d", product.productID));
            ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Tên TÁC GIẢ : %s", product.name));


            return viewProduct;
        }
    }
}
