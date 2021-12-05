package com.example.test;

import static com.example.test.MainActivity.islogin;
import static com.example.test.MainActivity.pendingSMSCount;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.test.pk_HelperClasses.adapterphone;
import com.example.test.pk_img_viewflper.Photo;
import com.example.test.pk_img_viewflper.PhotoAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import pk_HelperClassesS.adapterphoneS;
import pk_HelperClassesS.phonehelperS;
import pk_Item2.Item2;
import pk_Item2.adapterItem2;
import pk_price.AdapterPrice;
import pk_price.Price;

public class CategoryActivity extends AppCompatActivity implements adapterItem2.ListItemClickListener, AdapterPrice.ListItemClickListener, adapterphoneS.ListItemClickListener, adapterphone.ListItemClickListener {
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    RecyclerView itemRecycler5;
    RecyclerView itemRecycler6;
    private List<Photo> mlistphoto;
    private ViewPager viewPager;
    CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    RecyclerView.Adapter adapter;
    RecyclerView phoneRecyclerS;
    TextView txtgoHome;
    TextView smsCountTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Anhxa();


        bottomNavigationView.setSelectedItemId(R.id.item);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        if(islogin!=false){
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                            overridePendingTransition(0,0);
                        }else{
                            //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            //overridePendingTransition(0,0);
                            DialogSubmit();
                        }
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.item:
                        return true;
                    case R.id.action_notification:
                        if(islogin!=false){
                            startActivity(new Intent(getApplicationContext(), NotificationActivity.class));
                            overridePendingTransition(0,0);
                        }else{
                            //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            //overridePendingTransition(0,0);
                            DialogSubmit();
                        }
                        return true;
                }
                return false;
            }
        });


        setSupportActionBar(toolbar);


        mlistphoto = getListPhoto();


        photoAdapter = new PhotoAdapter(this,mlistphoto );
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());


        itemRecycler5();
        itemRecycler6 = findViewById(R.id.recyclerPrice);
        itemRecycler6();

        phoneRecyclerS();

        GoGome();


    }
    private void DialogSubmit(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        //alert.setIcon(R.);
        alert.setMessage("Bạn cần đăng nhập để xem thông báo");

        alert.setPositiveButton("Đăng nhập", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
        alert.setNegativeButton("Huy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }
    private void GoGome() {
        txtgoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        if(MainActivity.cartArrayList != null)
        {
            pendingSMSCount = MainActivity.cartArrayList.size();
        }
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        toolbar = findViewById(R.id.toolbarCategory);
        viewPager = findViewById(R.id.viewpagerC);
        itemRecycler5 = findViewById(R.id.my_recyclerItem);
        phoneRecyclerS = findViewById(R.id.recyclerSmallPhone);
        circleIndicator = findViewById(R.id.circle_indicatorC);
        txtgoHome = findViewById(R.id.gotoHome);

    }


    private void phoneRecyclerS() {

        phoneRecyclerS.setHasFixedSize(true);
        //phoneRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        phoneRecyclerS.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
        ArrayList<phonehelperS> phonelocations = new ArrayList<>();

        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu  ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu  ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu  ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));
        phonelocations.add(new phonehelperS(R.drawable.iphon13, "iPhone 13 Pro Max 256GB I Chính hãng VN/A","19.990.000","13 đánh giá","Giảm 1 triệu ",R.drawable.star,R.drawable.star,R.drawable.star,R.drawable.star));

        adapter = new adapterphoneS(this,phonelocations,this);
        phoneRecyclerS.setAdapter(adapter);

    }
    private void itemRecycler6() {
        //All Gradients
        itemRecycler6.setHasFixedSize(true);
        //phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        itemRecycler6.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));

        ArrayList<Price> itemlocationsC = new ArrayList<>();
        itemlocationsC.add(new Price( "Từ 2 - 4 triệu"));
        itemlocationsC.add(new Price( "Từ 4 - 7 triệu"));
        itemlocationsC.add(new Price( "Từ 7 - 13 triệu"));
        itemlocationsC.add(new Price( "Từ 13 - 15 triệu"));
        itemlocationsC.add(new Price( "Trên 15 triệu"));




        adapter = new AdapterPrice(this,itemlocationsC,this);
        itemRecycler6.setAdapter(adapter);

    }


    private void itemRecycler5() {
        //All Gradients
        itemRecycler5.setHasFixedSize(true);
        //phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        itemRecycler5.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.HORIZONTAL,false));

        ArrayList<Item2> itemlocationsC = new ArrayList<>();
        itemlocationsC.add(new Item2( R.drawable.iphonelogo2));
        itemlocationsC.add(new Item2( R.drawable.oppo_logo));
        itemlocationsC.add(new Item2( R.drawable.onepluslogo2));
        itemlocationsC.add(new Item2( R.drawable.sslogo2));
        itemlocationsC.add(new Item2( R.drawable.vivologo2));
        itemlocationsC.add(new Item2( R.drawable.realme_logo));
        itemlocationsC.add(new Item2( R.drawable.apple));
        itemlocationsC.add(new Item2( R.drawable.apple));
        itemlocationsC.add(new Item2( R.drawable.apple));
        itemlocationsC.add(new Item2( R.drawable.apple));



        adapter = new adapterItem2(this,itemlocationsC,this);
        itemRecycler5.setAdapter(adapter);


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

                    Intent intent = new Intent(CategoryActivity.this, CartActivity.class);
                    startActivity(intent);

                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onitemListClick(int clickedItemIndex) {

    }

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}