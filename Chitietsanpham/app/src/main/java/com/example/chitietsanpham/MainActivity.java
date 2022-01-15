package com.example.chitietsanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ViewFlipper;

import com.example.chitietsanpham.HelperClasses.adapterphone;
import com.example.chitietsanpham.HelperClasses.phonehelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class MainActivity extends AppCompatActivity implements adapterphone.ListItemClickListener{
    BottomNavigationView bottomNavigationView;
    RecyclerView phoneRecycler;
    private ViewPager viewPager;
    RecyclerView.Adapter adapter;
    int images[] = {R.drawable.ip13_pink, R.drawable.iphon13,R.drawable.ip13_pink,R.drawable.iphon13, R.drawable.ip13_pink, R.drawable.iphon13, R.drawable.ip13_pink, R.drawable.iphon13,R.drawable.ip13_pink, R.drawable.iphon13,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneRecycler = findViewById(R.id.my_recycler);
        phoneRecycler();
    }

    private void phoneRecycler() {

        phoneRecycler.setHasFixedSize(true);
        phoneRecycler.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));
        ArrayList<phonehelper> phonelocations = new ArrayList<>();

        phonelocations.add(new phonehelper(R.drawable.ip13_pink, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.ip13_pink, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.ip13_pink, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.ip13_pink, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.ip13_pink, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));

        Log.i("Debuger","This is running");

        adapter = new adapterphone(phonelocations,this);
        phoneRecycler.setAdapter(adapter);

    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }
}