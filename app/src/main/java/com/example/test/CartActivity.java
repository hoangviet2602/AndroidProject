package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import pk_cart.Cart;
import pk_cart.CartAdapter;

public class CartActivity extends AppCompatActivity implements CartAdapter.ListItemClickListener {
    RecyclerView recycler_cart;
    CartAdapter cartAdapter;
    TextView overAllAmount;
    ArrayList<Cart> cartList= new ArrayList<>();
    int overAllTotalAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        overAllAmount = findViewById(R.id.txtTongTien);
        recycler_cart = findViewById(R.id.my_recycler_cart);
        recycler_cart();

        //get data from my cart adaper
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mMessageReceiver,new IntentFilter("MyTotalAmount"));


    }



    private void recycler_cart() {
        recycler_cart.setHasFixedSize(true);
        //phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recycler_cart.setLayoutManager(new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false));

        cartList.add(new Cart(R.drawable.iphon13,R.drawable.plus,R.drawable.minus,"1","Xóa khỏi giỏ ","Iphone 13 Pro Max VN/A",13990000,"Ưu đãi"));
        cartList.add(new Cart(R.drawable.iphon13,R.drawable.plus,R.drawable.minus,"1","Xóa khỏi giỏ ","Iphone 13 Pro Max VN/A",13990000,"Ưu đãi"));

        cartAdapter = new CartAdapter(cartList,this,this);
        recycler_cart.setAdapter(cartAdapter);


    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int totalBill = intent.getIntExtra("totalAmount",0);
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

            overAllAmount.setText(decimalFormat.format(totalBill)+ " đ");
        }
    };

    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }
}