package com.example.chitietsanpham.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.chitietsanpham.R;

import java.util.ArrayList;

public class adapterphone extends RecyclerView.Adapter<adapterphone.PhoneViewHold>  {

    ArrayList<phonehelper> phoneLaocations;
    final private ListItemClickListener mOnClickListener;

    public adapterphone(ArrayList<phonehelper> phoneLaocations, ListItemClickListener listener) {
        this.phoneLaocations = phoneLaocations;
        mOnClickListener = listener;
    }

    @NonNull

    @Override
    public PhoneViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phonerecyclercard, parent, false);
        return new PhoneViewHold(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHold holder, int position) {


        phonehelper phonehelper = phoneLaocations.get(position);
        holder.image.setImageResource(phonehelper.getImage());
        holder.star.setImageResource(phonehelper.getStar());
        holder.star2.setImageResource(phonehelper.getStar2());
        holder.star3.setImageResource(phonehelper.getStar3());
        holder.star4.setImageResource(phonehelper.getStar4());
        holder.title.setText(phonehelper.getTitle());
        holder.price.setText(phonehelper.getPrice());
        holder.note.setText(phonehelper.getNote());
        holder.rate.setText(phonehelper.getRate());


    }

    @Override
    public int getItemCount() {
        return phoneLaocations.size();

    }

    public interface ListItemClickListener {
        void onphoneListClick(int clickedItemIndex);
    }

    public class PhoneViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView image,star,star2,star3,star4;
        TextView title,note,rate,price;



        public PhoneViewHold(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks

            image = itemView.findViewById(R.id.phone_image);
            title = itemView.findViewById(R.id.phone_title);
            star = itemView.findViewById(R.id.phone_start);
            star2 = itemView.findViewById(R.id.phone_start2);
            star3 = itemView.findViewById(R.id.phone_start3);
            star4 = itemView.findViewById(R.id.phone_start4);
            rate  = itemView.findViewById(R.id.phone_rate);
            note = itemView.findViewById(R.id.phone_note);
            price = itemView.findViewById(R.id.phone_price);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onphoneListClick(clickedPosition);
        }
    }

}
