package com.example.lichsudonhang.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lichsudonhang.DaGiao;
import com.example.lichsudonhang.MyDividerItemDecoration;
import com.example.lichsudonhang.R;
import com.example.lichsudonhang.adapter.Dagiao_adapter;
import com.example.lichsudonhang.adapter.DangGiao_adapter;
import com.example.lichsudonhang.danggiao;

import java.util.ArrayList;
import java.util.List;

public class DangGiao_Fragment extends Fragment {

    RecyclerView rcv;
    DangGiao_adapter adapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DangGiao_Fragment() {
        // Required empty public constructor
    }

    public static DangGiao_Fragment newInstance(String param1, String param2) {
        DangGiao_Fragment fragment = new DangGiao_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danggiao, container, false);
        List<danggiao> list = new ArrayList<>();

        list.add(new danggiao(R.drawable.ip13_pink,"Iphone 13Promax","1", "25.000.000đ"));
        list.add(new danggiao(R.drawable.ip13_pink,"Iphone 13 Pink","2", "44.000.000đ"));
        list.add(new danggiao(R.drawable.ip13_pink,"Iphone 13Promax","2", "25.000.000đ"));
        list.add(new danggiao(R.drawable.iphon13,"Iphone 13 Pink","3", "44.000.000đ"));
        list.add(new danggiao(R.drawable.iphon13,"Iphone 13Promax","1", "25.000.000đ"));
        list.add(new danggiao(R.drawable.iphon13,"Iphone 13 Pink","1", "44.000.000đ"));
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcv = view.findViewById(R.id.chiTiet_danggiao);
        adapter = new DangGiao_adapter(list);
        rcv.addItemDecoration(new MyDividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL, 36));
        rcv.setItemAnimator(new DefaultItemAnimator());
        rcv.setLayoutManager(llm);
        rcv.setAdapter(adapter);
        return view;

    }

}
