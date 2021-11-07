package pk_HelperClassesS;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.ProductDetailActivity;
import com.example.test.R;
import com.example.test.pk_HelperClasses.phonehelper;

import java.util.ArrayList;

public class adapterphoneS extends RecyclerView.Adapter<adapterphoneS.PhoneViewHold>  {

    ArrayList<phonehelperS> phoneLaocations;
    final private ListItemClickListener mOnClickListener;
    private Context mContext;
    public adapterphoneS(Context context, ArrayList<phonehelperS> phoneLaocations, ListItemClickListener listener) {
        this.phoneLaocations = phoneLaocations;
        mOnClickListener = listener;
        this.mContext=context;
    }

    @NonNull

    @Override
    public PhoneViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.smallphonerecyclercard, parent, false);
        return new PhoneViewHold(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHold holder, int position) {


        final phonehelperS phonehelper = phoneLaocations.get(position);
        holder.image.setImageResource(phonehelper.getImageS());
        holder.star.setImageResource(phonehelper.getStarS());
        holder.star2.setImageResource(phonehelper.getStar2S());
        holder.star3.setImageResource(phonehelper.getStar3S());
        holder.star4.setImageResource(phonehelper.getStar4S());
        holder.title.setText(phonehelper.getTitleS());
        holder.price.setText(phonehelper.getPriceS());
        holder.note.setText(phonehelper.getNoteS());
        holder.rate.setText(phonehelper.getRateS());
        //xu li su kien click
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
    // xu li su kien click vao product
    private void onClickGoToDetail(phonehelper phonehelper){
        Intent intent = new Intent(mContext, ProductDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object",phonehelper);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return phoneLaocations.size();

    }

    public interface ListItemClickListener {
        void onphoneListClick(int clickedItemIndex);
    }

    public class PhoneViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CardView layoutItem;
        ImageView image,star,star2,star3,star4;
        TextView title,note,rate,price;

        public PhoneViewHold(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks
            layoutItem = itemView.findViewById(R.id.phone_CardviewS);
            image = itemView.findViewById(R.id.phone_imageS);
            title = itemView.findViewById(R.id.phone_titleS);
            star = itemView.findViewById(R.id.phone_startS);
            star2 = itemView.findViewById(R.id.phone_start2S);
            star3 = itemView.findViewById(R.id.phone_start3S);
            star4 = itemView.findViewById(R.id.phone_start4S);
            rate  = itemView.findViewById(R.id.phone_rateS);
            note = itemView.findViewById(R.id.phone_noteS);
            price = itemView.findViewById(R.id.phone_priceS);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onphoneListClick(clickedPosition);
        }
    }   

}
