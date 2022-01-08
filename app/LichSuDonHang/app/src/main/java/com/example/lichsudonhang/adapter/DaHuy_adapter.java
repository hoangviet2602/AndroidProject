package com.example.lichsudonhang.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lichsudonhang.DaHuy;
import com.example.lichsudonhang.R;
import com.example.lichsudonhang.danggiao;

import java.util.List;

public class DaHuy_adapter extends RecyclerView.Adapter<DaHuy_adapter.MyViewHolder>{

    List<DaHuy> list;

    public DaHuy_adapter(List<DaHuy> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dahuy, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final DaHuy dahuy = list.get(position);
        holder.name.setText("" + dahuy.getTitle());
        holder.img.setImageResource(dahuy.getImage());
        holder.slg.setText("Số lượng: " + dahuy.getSoluong());
        holder.tongt.setText("Tổng tiền: " + dahuy.getTongTien());
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
