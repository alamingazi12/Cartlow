package com.example.cartflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cartflow.model.Product;

import java.util.ArrayList;

public class SellActivity extends AppCompatActivity {
    ArrayList<Product> product_list;
   RecyclerView recyclerView_product_container;

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        initProductList();
        initList();
    }

    private void initProductList() {
        product_list=new ArrayList<>();
        product_list.add(new Product(R.drawable.camera,"Camera"));
        product_list.add(new Product(R.drawable.smartphone,"smart Phone"));
        product_list.add(new Product(R.drawable.smartwatch,"Smartwatch"));
        product_list.add(new Product(R.drawable.headphones,"HeadPhone"));
        product_list.add(new Product(R.drawable.laptop,"Laptop"));

        product_list.add(new Product(R.drawable.camera,"Camera"));
        product_list.add(new Product(R.drawable.smartphone,"smart Phone"));
        product_list.add(new Product(R.drawable.smartwatch,"Smartwatch"));
        product_list.add(new Product(R.drawable.headphones,"HeadPhone"));
        product_list.add(new Product(R.drawable.laptop,"Laptop"));
    }

    private void initList() {
        recyclerView_product_container=findViewById(R.id.product_container);
        recyclerView_product_container.setHasFixedSize(true);
        recyclerView_product_container.setLayoutManager(new LinearLayoutManager(SellActivity.this));

        ItemSellAdapter sel_adapter=new ItemSellAdapter(SellActivity.this,product_list);
        recyclerView_product_container.setAdapter(sel_adapter);
        recyclerView_product_container.setRecycledViewPool(viewPool);


    }
}