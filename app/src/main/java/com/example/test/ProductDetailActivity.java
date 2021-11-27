package com.example.test;



import static com.example.test.MainActivity.pendingSMSCount;
import static com.example.test.MainActivity.user;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.test.pk_HelperClasses.adapterphone;
import com.example.test.pk_HelperClasses.phonehelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity implements adapterphone.ListItemClickListener{
    Toolbar toolbar;
    TextView smsCountTxt;
    RecyclerView phoneRecycler;
    RecyclerView.Adapter adapter;
    TextView tvTen,tvGia,tvsize,tvloai,tvram,tvrom,tvpin;
    ImageView imageView;
    ArrayList<phonehelper> Phones = new ArrayList<phonehelper>();
    private static  final String BASE_URL_SP = "http://192.168.1.62/androidwebservice/sanpham.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        anhxa();
        setSupportActionBar(toolbar);
        getInfomation();
        getSanPham();
    }
    private void getSanPham(){
        NumberFormat formatter = new DecimalFormat("###,###,###");
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, BASE_URL_SP, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0 ; i <=response.length();i++){
                            try{
                                JSONObject object = response.getJSONObject(i);
                                phonehelper phone = new phonehelper();
                                phone.setIdDM(object.getInt("idDM"));
                                phone.setIdSP(object.getInt("idSP"));
                                phone.setTitle(object.getString("Tittle"));
                                phone.setImage(object.getString("HinhAnh"));
                                phone.setNote(object.getString("UuDai"));
                                phone.setPrice(formatter.format(object.getInt("Gia"))+" VNĐ");
                                phone.setRate(object.getInt("SoDanhGia")+" đánh giá");
                                phone.setSizemanhinh(object.getString("size"));
                                phone.setLoaimanhinh(object.getString("loai"));
                                phone.setRam(object.getString("ram"));
                                phone.setRom(object.getString("rom"));
                                phone.setPin(object.getString("pin"));
                                phone.setStar(R.drawable.star);
                                phone.setStar2(R.drawable.star);
                                phone.setStar3(R.drawable.star);
                                phone.setStar4(R.drawable.star);
                                Phones.add(phone);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        phoneRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.HORIZONTAL,false));
                        //itemRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                        adapter = new adapterphone(getApplicationContext(),Phones,ProductDetailActivity.this);
                        phoneRecycler.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText( null, "lỗi", Toast.LENGTH_SHORT).show();
                Log.d("tag","onErrorRespone: " +error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }
    private void getInfomation(){
        int idSP=0;
        String Tittle = "";
        String price="";
        String Image = "";
        String size = "";
        String loai = "";
        String ram = "";
        String rom = "";
        String pin="";
        phonehelper phone = (phonehelper) getIntent().getSerializableExtra("object");
        idSP = phone.getIdSP();
        Tittle = phone.getTitle();
        Image = phone.getImage();
        price  = phone.getPrice();
        size = phone.getSizemanhinh();
        loai = phone.getLoaimanhinh();
        ram = phone.getRam();
        rom = phone.getRom();
        pin = phone.getPin();

        tvTen.setText(Tittle);
        DecimalFormat format = new DecimalFormat("###,###,###");
        tvGia.setText(price);
        Glide.with(getApplicationContext()).load(Image).into(imageView);
        tvsize.setText(size);
        tvloai.setText(loai);
        tvram.setText(ram);
        tvrom.setText(rom);
        tvpin.setText(pin);
    }
    private void anhxa(){
        tvTen = findViewById(R.id.tvtensp);
        tvGia = findViewById(R.id.tvgia);
        imageView = findViewById(R.id.imageView);
        toolbar = findViewById(R.id.toolbarDetail);
        phoneRecycler = findViewById(R.id.my_recycler5);
        tvsize = findViewById(R.id.sizemanhinh);
        tvloai = findViewById(R.id.loaimanhinh);
        tvram = findViewById(R.id.ram);
        tvrom = findViewById(R.id.rom);
        tvpin = findViewById(R.id.pin);

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



    @Override
    public void onphoneListClick(int clickedItemIndex) {

    }



}