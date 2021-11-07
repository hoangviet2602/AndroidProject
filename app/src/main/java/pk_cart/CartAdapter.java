package pk_cart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.R;

import java.text.DecimalFormat;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    public int money = 0;
    List<Cart> cartList;
    Context context;
    final private CartAdapter.ListItemClickListener mOnClickListener;

    public CartAdapter(List<Cart> cartList, Context context, CartAdapter.ListItemClickListener mOnClickListener) {
        this.cartList = cartList;
        this.context = context;
        this.mOnClickListener = mOnClickListener;
    }



    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcart,parent,false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        //holder.img_cart.setImageResource(cartList.get(position).getImage());

        Glide.with(context).load(cartList.get(position).getImage()).into(holder.img_cart);
        Glide.with(context).load(cartList.get(position).getImgplus()).into(holder.imgplus);
        Glide.with(context).load(cartList.get(position).getImgminus()).into(holder.imgminus);
        holder.tittle_cart.setText(cartList.get(position).getTittle());
        holder.price_cart.setText(decimalFormat.format(cartList.get(position).getPrice()));
        holder.note_card.setText(cartList.get(position).getNote());
        holder.quanlity.setText((cartList.get(position).getQuanlity()));
        holder.delete.setText(cartList.get(position).getDelete());

        money += cartList.get(position).getPrice();
        Intent intent = new Intent("MyTotalAmount");
        intent.putExtra("totalAmount",money);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);



    }
    public interface ListItemClickListener {
        void onphoneListClick(int clickedItemIndex);
    }

    @Override
    public int getItemCount() {

        return cartList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView img_cart,imgplus,imgminus;
        TextView   tittle_cart,price_cart,note_card,delete,quanlity;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            img_cart = itemView.findViewById(R.id.img_cart);
            tittle_cart = itemView.findViewById(R.id.cart_name);
            price_cart = itemView.findViewById(R.id.cart_price);
            note_card =  itemView.findViewById(R.id.cart_note);

            imgplus = itemView.findViewById(R.id.btnplus);
            imgminus = itemView.findViewById(R.id.btnminus);
            delete = itemView.findViewById(R.id.txtdelete);
            quanlity = itemView.findViewById(R.id.txtquanlity);

        }
    }


}
