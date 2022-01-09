package com.example.lichsudonhang.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lichsudonhang.DaGiao;
import com.example.lichsudonhang.R;
import com.example.lichsudonhang.danggiao;

import java.util.List;

public class DangGiao_adapter extends RecyclerView.Adapter<DangGiao_adapter.MyViewHolder> {

    List<danggiao> list;

    public DangGiao_adapter(List<danggiao> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_danggiao, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final danggiao dg = list.get(position);
        holder.name.setText("" + dg.getTitle());
        holder.img.setImageResource(dg.getImage());
        holder.slg.setText("Số lượng: " + dg.getSoluong());
        holder.tongt.setText("Tổng tiền: " + dg.getTongTien());
    }

    @Override
    public int getItemCount() {
        Log.i("DebugY", "Running");

        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView name, slg, tongt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ten);
            img = itemView.findViewById(R.id.img);
            slg = itemView.findViewById(R.id.slg);
            tongt = itemView.findViewById(R.id.tongtien);
        }
    }
}
