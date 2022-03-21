package com.example.cartflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartflow.model.Product;

import java.util.ArrayList;

public class ItemSellAdapter extends RecyclerView.Adapter<ItemSellAdapter.ItemsSellHOlder> {

    Context context;
    ArrayList<Product> product_type_list;

    public ItemSellAdapter(Context context, ArrayList<Product> pproduct_type_list) {
        this.context = context;
        this.product_type_list = pproduct_type_list;


    }



    @Override
    public ItemsSellHOlder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.product_item_layout,parent,false);
        return new ItemsSellHOlder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemSellAdapter.ItemsSellHOlder holder, int position) {

        Product product=product_type_list.get(position);
        holder.image_product_type.setImageResource(product.getProduct_url());
       // holder.product_name.setText(product.getProduct_Tname());
        holder.product_name.setText(product.getProduct_Tname());


    }

    @Override
    public int getItemCount() {
        return product_type_list.size()      ;
    }

    public class ItemsSellHOlder extends RecyclerView.ViewHolder {
        ImageView image_product_type;
        TextView product_name;
        public ItemsSellHOlder( View itemView) {
            super(itemView);

            image_product_type=itemView.findViewById(R.id.grid_product_image);
            product_name=itemView.findViewById(R.id.product_name);
        }
    }
}
