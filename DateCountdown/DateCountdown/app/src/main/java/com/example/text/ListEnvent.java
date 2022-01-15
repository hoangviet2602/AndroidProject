package com.example.phamxuantoan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListEnvent extends AppCompatActivity {
    private ListView lvEnvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_envent);

        lvEnvent = (ListView) findViewById(R.id.lisEnvent);
        ArrayList<Envent> arr = new ArrayList<>();

        Envent contact1 = new Contact("Bùi Viết Hùng Anh","161250533502", Color.RED);

        arrContact.add(contact1);
        arrContact.add(contact2);
        arrContact.add(contact3);
        arrContact.add(contact4);
        arrContact.add(contact5);
        arrContact.add(contact6);
        arrContact.add(contact7);

        CustomAdapter customAdaper = new CustomAdapter(this,R.layout.row_listview,arrContact);
        lvContact.setAdapter(customAdaper);
    }
}
}