package com.example.lichsudonhang.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lichsudonhang.adapter.Dagiao_adapter;

import com.example.lichsudonhang.R;

import java.util.ArrayList;

public class DaGiao_Fragment{

    ArrayList<Dagiao_adapter> DagiaoLaocations;
    Dagiao_adapter adapter;

    public DaGiao_Fragment(ArrayList<Dagiao_adapter> DagiaoLaocations, ListItemClickListener listener) {
        this.DagiaoLaocations = DagiaoLaocations;
//        mOnClickListener = listener;
    }
}
