package com.example.cartflow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cartflow.R;
import com.example.cartflow.model.Product;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProdcuctViewHolder> {
    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    Context context;
     ArrayList<Product> products;
    @Override
    public ProdcuctViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_product,parent,false);
        return new ProdcuctViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProdcuctViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProdcuctViewHolder extends RecyclerView.ViewHolder {
        public ProdcuctViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
