package com.example.cartflow.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.cartflow.R;
import com.example.cartflow.adapter.ProductAdapter;
import com.example.cartflow.adapter.SliderAdapter;
import com.example.cartflow.adapter.cProductAdapter;
import com.example.cartflow.model.Product;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
   SliderAdapter sliderAdapter;
   androidx.appcompat.widget.Toolbar toolbar;
   SliderView sliderView;
    int[] images = {R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four
    };
    ArrayList<Product> product_list;

RecyclerView product_sel_item_container;
RecyclerView cir_product_container;



    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        initSlider(view);
        initProductList();
        initCircleContainer(view);
        initContainer(view);


        return view;
    }

    private void initSlider(View view) {
        sliderView = view.findViewById(R.id.image_slider);
        sliderAdapter=new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }

    private void initCircleContainer(View view) {
        cir_product_container=view.findViewById(R.id.circle_item_container);
        cir_product_container.setHasFixedSize(true);
        cir_product_container.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        cProductAdapter productAdapter=new cProductAdapter(getContext(),product_list);
        cir_product_container.setAdapter(productAdapter);
    }

    private void initContainer(View view) {
        product_sel_item_container=view.findViewById(R.id.product_container_sel1);
        product_sel_item_container.setHasFixedSize(true);
        product_sel_item_container.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ProductAdapter productAdapter=new ProductAdapter(getContext(),product_list);
        product_sel_item_container.setAdapter(productAdapter);
    }



    private void initProductList() {
        product_list=new ArrayList<>();
        product_list.add(new Product(R.drawable.camera,"Camera"));
        product_list.add(new Product(R.drawable.smartphone,"smart Phone"));
        product_list.add(new Product(R.drawable.smartwatch,"Smartwatch"));
        product_list.add(new Product(R.drawable.headphones,"HeadPhone"));
        product_list.add(new Product(R.drawable.laptop,"Laptop"));
        product_list.add(new Product(R.drawable.smartwatch,"Smartwatch"));
        product_list.add(new Product(R.drawable.headphones,"HeadPhone"));
        product_list.add(new Product(R.drawable.laptop,"Laptop"));
    }
}