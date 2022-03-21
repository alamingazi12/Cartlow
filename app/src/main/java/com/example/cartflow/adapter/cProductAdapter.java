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

public class cProductAdapter extends RecyclerView.Adapter<cProductAdapter.ProdcuctViewHolder> {
    public cProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    Context context;
    ArrayList<Product> products;
    @Override
    public cProductAdapter.ProdcuctViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.circular_item,parent,false);
        return new cProductAdapter.ProdcuctViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cProductAdapter.ProdcuctViewHolder holder, int position) {

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
