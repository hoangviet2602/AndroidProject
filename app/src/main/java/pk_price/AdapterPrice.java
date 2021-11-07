
package pk_price;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.CategoryActivity;
import com.example.test.R;
import com.example.test.pk_Item.Item;

import java.util.ArrayList;

public class AdapterPrice extends RecyclerView.Adapter<AdapterPrice.ItemViewHold2>  {

    ArrayList<Price> itemLaocations;
    private Context mContext;
    final private ListItemClickListener mOnClickListener;

    public AdapterPrice(Context context, ArrayList<Price> itemLaocations, ListItemClickListener listener) {
        this.itemLaocations = itemLaocations;
        mOnClickListener = listener;
        this.mContext=context;
    }

    @NonNull

    @Override
    public ItemViewHold2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemprice, parent, false);
        return new ItemViewHold2(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHold2 holder, int position) {


        final Price itemhelper = itemLaocations.get(position);
        holder.Price.setText(itemhelper.getPrice());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void onClickGoToDetail(Item itemhelper){
        Intent intent = new Intent(mContext, CategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object",itemhelper);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return itemLaocations.size();

    }

    public interface ListItemClickListener {
        void onitemListClick(int clickedItemIndex);
    }

    public class ItemViewHold2 extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView layoutItem;
        TextView Price;



        public ItemViewHold2(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks
            layoutItem = itemView.findViewById(R.id.item_CardviewPrice);
            Price = itemView.findViewById(R.id.itemPrice);



        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onitemListClick(clickedPosition);
        }
    }

}
