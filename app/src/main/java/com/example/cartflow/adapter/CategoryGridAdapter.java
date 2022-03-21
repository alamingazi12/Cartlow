package com.example.cartflow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartflow.R;
import com.example.cartflow.model.Product;

import java.util.ArrayList;

public class CategoryGridAdapter extends RecyclerView.Adapter<CategoryGridAdapter.GridViewHolder> {
     ArrayList<Product> productsList;
     Context context;

    public CategoryGridAdapter(ArrayList<Product> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }

    @NonNull

    @Override
    public GridViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.grid_item_layout,parent,false);
        return new CategoryGridAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryGridAdapter.GridViewHolder holder, int position) {
         Product product= productsList.get(position);

         holder.product_name.setText(product.getProduct_Tname());
         holder.product_image.setImageResource(product.getProduct_url());
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        TextView product_name;
        public GridViewHolder(@NonNull  View itemView) {
            super(itemView);
            product_image=itemView.findViewById(R.id.grid_product_image);
            product_name=itemView.findViewById(R.id.product_name_grid);
        }
    }
}
