package com.example.test;

import static com.example.test.MainActivity.pendingSMSCount;
import static com.example.test.MainActivity.user;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.pk_HelperClasses.adapterphone;
import com.example.test.pk_HelperClasses.phonehelper;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity implements adapterphone.ListItemClickListener{
    Toolbar toolbar;
    TextView smsCountTxt;
    RecyclerView phoneRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        phoneRecycler = findViewById(R.id.my_recycler5);
        phoneRecycler();

        toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        MenuItem menuItem = menu.findItem(R.id.actioncart);
        smsCountTxt = findViewById(R.id.cart_badge);
        if(pendingSMSCount==0){
            menuItem.setActionView(null);
        }else{
            menuItem.setActionView(R.layout.custom_cart_layout);
            View view = menuItem.getActionView();
            smsCountTxt = view.findViewById(R.id.cart_badge);
            smsCountTxt.setText(String.valueOf((pendingSMSCount)));
            setupBadge();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onOptionsItemSelected(menuItem);
                }
            });
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case  R.id.actioncart:
                if(user != null ){
                    Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(ProductDetailActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
        return true;
    }

    private void setupBadge() {
        if (smsCountTxt != null) {
            if (pendingSMSCount == 0) {
                if (smsCountTxt.getVisibility() != View.GONE) {
                    smsCountTxt.setVisibility(View.GONE);
                }
            } else {
                smsCountTxt.setText(String.valueOf(Math.min(pendingSMSCount, 99)));
                if (smsCountTxt.getVisibility() != View.VISIBLE) {
                    smsCountTxt.setVisibility(View.VISIBLE);
                }
            }
        }
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

        adapter = new adapterphone(this,phonelocations,this);
        phoneRecycler.setAdapter(adapter);



    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }



}