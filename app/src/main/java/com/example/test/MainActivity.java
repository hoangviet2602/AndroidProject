package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.test.pk_HelperClasses.adapterphone;
import com.example.test.pk_HelperClasses.phonehelper;
import com.example.test.pk_Item.Item;
import com.example.test.pk_Item.adapterItem;
import com.example.test.pk_img_viewflper.Photo;
import com.example.test.pk_img_viewflper.PhotoAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements adapterphone.ListItemClickListener, adapterItem.ListItemClickListener {
    BottomNavigationView bottomNavigationView;
    RecyclerView itemRecycler;
    RecyclerView phoneRecycler2;
    RecyclerView phoneRecycler3;
    RecyclerView phoneRecycler4;
    CircleIndicator circleIndicator;
    private ViewPager viewPager;
    private PhotoAdapter photoAdapter;
    private List<Photo> mlistphoto;
    private Timer mTimer;
    RecyclerView.Adapter adapter;
    Toolbar toolbar;
    public static String user = null;
    public static String pass = null;

    TextView smsCountTxt;
    public static int pendingSMSCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
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
                        return true;
                    case R.id.item:
                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_notification:
                        if(user!=null){
                            startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                            overridePendingTransition(0,0);
                        }else{
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            overridePendingTransition(0,0);
                        }
                        return true;
                }
                return false;
            }
        });


        //Hooks
        itemRecycler = findViewById(R.id.my_recycler);
        itemRecycler();
        phoneRecycler2 = findViewById(R.id.my_recycler1);
        phoneRecycler2();
        phoneRecycler3 = findViewById(R.id.my_recycler2);
        phoneRecycler3();
        phoneRecycler4 = findViewById(R.id.my_recycler3);
        phoneRecycler4();

        mlistphoto = getListPhoto();
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        photoAdapter = new PhotoAdapter(this,mlistphoto );
        viewPager.setAdapter(photoAdapter);
        autoSlideImages();
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        toolbar = findViewById(R.id.toolbarmain);
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


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case  R.id.actioncart:
                if(user != null ){
                    Intent intent = new Intent(MainActivity.this, CartActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
        return true;
    }

    private List<Photo> getListPhoto(){
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.view1));
        list.add(new Photo(R.drawable.view2));
        list.add(new Photo(R.drawable.view3));
        list.add(new Photo(R.drawable.view1));
        list.add(new Photo(R.drawable.view2));
        list.add(new Photo(R.drawable.view3));
        return list;
    }
    private void autoSlideImages(){
        if(mlistphoto==null || mlistphoto.isEmpty() || viewPager == null){
            return;
        }
        if(mTimer == null){
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem =  mlistphoto.size() -1 ;
                        if(currentItem < totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        },300,3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }

    private void itemRecycler() {
        //All Gradients
        itemRecycler.setHasFixedSize(true);
        //phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        itemRecycler.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false));

        ArrayList<Item> itemlocations = new ArrayList<>();
        itemlocations.add(new Item( R.drawable.apple, ""));
        itemlocations.add(new Item( R.drawable.samsung_logo, ""));
        itemlocations.add(new Item( R.drawable.asus_logo, ""));
        itemlocations.add(new Item( R.drawable.xiaomi_logo, ""));
        itemlocations.add(new Item( R.drawable.vsmart_ogo, ""));
        itemlocations.add(new Item( R.drawable.vivo_logo, ""));
        itemlocations.add(new Item( R.drawable.realme_logo, ""));
        itemlocations.add(new Item( R.drawable.oneplus_logo, ""));
        itemlocations.add(new Item( R.drawable.apple, ""));
        itemlocations.add(new Item( R.drawable.samsung_logo, ""));

        adapter = new adapterItem(this,itemlocations,  this);
        itemRecycler.setAdapter(adapter);
    }
    private void phoneRecycler2() {

        phoneRecycler2.setHasFixedSize(true);
        //phoneRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        phoneRecycler2.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false));
        ArrayList<phonehelper> phonelocations = new ArrayList<>();

        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));

        adapter = new adapterphone(this,phonelocations,this);
        phoneRecycler2.setAdapter(adapter);

    }
    private void phoneRecycler3() {

        phoneRecycler3.setHasFixedSize(true);
        phoneRecycler3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //phoneRecycler3.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false));
        ArrayList<phonehelper> phonelocations = new ArrayList<>();

        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));

        adapter = new adapterphone(this,phonelocations,this);
        phoneRecycler3.setAdapter(adapter);

    }
    private void phoneRecycler4() {
        phoneRecycler4.setHasFixedSize(true);
        phoneRecycler4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //phoneRecycler3.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false));
        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Ưu đãi tối tác 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelper(R.drawable.samsung1, "Samsung Galaxy Z Fold3 5G","19.990.000","13 đánh giá","Tặng bảo hành vàng",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));

        adapter = new adapterphone(this,phonelocations,this);
        phoneRecycler4.setAdapter(adapter);
    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }
    @Override
    public void onitemListClick(int clickedItemIndex) {

    }
}