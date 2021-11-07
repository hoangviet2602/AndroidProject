package com.example.test;

import static com.example.test.MainActivity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import pk_thongbao.thongbao;
import pk_thongbao.thongbaoAdapter;

public class NotificationActivity extends AppCompatActivity {
    ListView lvThongBao;
    ArrayList<thongbao> arraythongbao;
    thongbaoAdapter adapter;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.action_notification);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:
                        if(user!=null){
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                            overridePendingTransition(0,0);
                        }else{
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            overridePendingTransition(0,0);
                        }
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.item:
                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_notification:
                        return true;
                }

                return false;
            }
        });

        AnhXa();
        adapter = new thongbaoAdapter(this, R.layout.dong_thongbao, arraythongbao);
        lvThongBao.setAdapter(adapter);
    }
    private void AnhXa() {
        lvThongBao = (ListView) findViewById(R.id.listviewThongBao);
        arraythongbao = new ArrayList<>();
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 32145 đã hoàn thành.", R.drawable.iphone1));
        arraythongbao.add(new thongbao("Đánh giá sản phẩm", "Đơn hàng đã được giao thành công, vui lòng đánh giá sản phẩm trước ngày 20-11-2021", R.drawable.oppo1));
        arraythongbao.add(new thongbao("Săn Deal Đỉnh – Rinh iPhone 13 Pro", "Mua ngay iphone 13 Pro Max để có cơ hội nhận nhiều phần quà hấp dẫn", R.drawable.iphone3));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 27452 đã hoàn thành.", R.drawable.iphone4));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 52138 đã hoàn thành.", R.drawable.iphone5));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 41735 đã hoàn thành.", R.drawable.samsung));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 32573 đã hoàn thành.", R.drawable.iphone2));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 52545 đã hoàn thành.", R.drawable.samsung2));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 14232 đã hoàn thành.", R.drawable.iphone4));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 34253 đã hoàn thành.", R.drawable.oppo2));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 34253 đã hoàn thành.", R.drawable.iphone2));
        arraythongbao.add(new thongbao("Bạn đã mua hàng thành công", "Đơn hàng 34253 đã hoàn thành.", R.drawable.oppo3));

    }
}