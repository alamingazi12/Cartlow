package com.example.cartflow.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cartflow.ItemSellAdapter;
import com.example.cartflow.R;
import com.example.cartflow.SellActivity;
import com.example.cartflow.model.Product;

import java.util.ArrayList;


public class SellFragment extends Fragment {
    ArrayList<Product> product_list;
    RecyclerView recyclerView_product_container;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public SellFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sell, container, false);
        initProductList();
        initList(view);
        return view;
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

    private void initList(View view) {
        recyclerView_product_container=view.findViewById(R.id.product_container);
        recyclerView_product_container.setHasFixedSize(true);
        recyclerView_product_container.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemSellAdapter sel_adapter=new ItemSellAdapter(getContext(),product_list);
        recyclerView_product_container.setAdapter(sel_adapter);
        recyclerView_product_container.setRecycledViewPool(viewPool);


    }
}