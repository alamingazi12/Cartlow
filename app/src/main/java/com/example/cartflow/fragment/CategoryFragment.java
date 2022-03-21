package com.example.cartflow.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartflow.R;
import com.example.cartflow.adapter.CategoryGridAdapter;
import com.example.cartflow.model.Category;
import com.example.cartflow.model.Product;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
  ArrayList<Product> product_list;
  RecyclerView item_type_container;
  RecyclerView product_grid_item_container;
  ArrayList<Category> categories;

  SharedPreferences preferences_position;
 public  static SharedPreferences.Editor editor;
    View view;

    public CategoryFragment() {
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
        view= inflater.inflate(R.layout.fragment_category, container, false);
          initAll();
          initItem();
          initProductList();
          initProductCategory(view);

        return view;
    }

    private void initAll() {
        preferences_position=getActivity().getSharedPreferences("item_preference", Context.MODE_PRIVATE);
        editor=preferences_position.edit();
    }

    private void initItem() {
        categories=new ArrayList<>();
        categories.add(new Category("Books"));
        categories.add(new Category("Lawn & garden"));
        categories.add(new Category("Sports"));
        categories.add(new Category("Showes Accessories"));
        categories.add(new Category("Baby Shoes baby boys"));
        categories.add(new Category("Fashion Shoes girls"));
        categories.add(new Category("Elcetronics"));
        categories.add(new Category("Books"));
        categories.add(new Category("Lawn & garden"));
        categories.add(new Category("Sports"));
        categories.add(new Category("Showes Accessories"));
        categories.add(new Category("Baby Shoes baby boys"));
        categories.add(new Category("Fashion Shoes girls"));
        categories.add(new Category("Elcetronics"));
    }

    public void initProductList() {
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

    private void initProductCategory(View view) {
        item_type_container=view.findViewById(R.id.item_container);
        item_type_container.setHasFixedSize(true);
        item_type_container.setLayoutManager(new LinearLayoutManager(getContext()));
        CategoryAdapter categoryAdapter=new CategoryAdapter(categories,getContext());
        item_type_container.setAdapter(categoryAdapter);

      // init grid adapter
        product_grid_item_container=view.findViewById(R.id.grid_item_container);
        product_grid_item_container.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        product_grid_item_container.setLayoutManager(gridLayoutManager);
    }

    public  void showProduct(){

            Toast.makeText(getContext(),"view not null",Toast.LENGTH_LONG).show();

            CategoryGridAdapter categoryGridAdapter=new CategoryGridAdapter(product_list,getContext());
            product_grid_item_container.setAdapter(categoryGridAdapter);
        }

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ItemViewHolder> {
        int index=-1;
        boolean item_clicked=false;

        public CategoryAdapter(@NonNull ArrayList<Category> product_type_list, Context context) {
            this.product_type_list = product_type_list;
            this.context = context;
        }

        @NonNull
        ArrayList<Category> product_type_list;
        Context context;
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(context).inflate(R.layout.side_item_container_layout,parent,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull  ItemViewHolder holder, int position) {
            Category category=product_type_list.get(position);
            holder.category_name.setText(category.getCategory_name());


            holder.layout_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index=position;
                    Category category1=product_type_list.get(position);
                    Toast.makeText(getContext(),"position clicked"+position,Toast.LENGTH_LONG).show();
                    showProduct();
                    notifyDataSetChanged();
                    item_clicked=true;
                }
            });

            if(index==position && item_clicked==true){
                holder.category_name.setTextColor(Color.parseColor("#04B10B"));
                holder.view_select.setBackgroundColor(Color.parseColor("#04B10B"));
                holder.layout_item.setBackgroundColor(Color.parseColor("#ffffff"));
                // Toast.makeText(context,"Name"+AddExpenseActivity.categoryname,Toast.LENGTH_SHORT).show();
                CategoryFragment.editor.putInt("select_position",position);
                CategoryFragment.editor.putBoolean("ischecked",true);

                CategoryFragment.editor.apply();
            }
            else if(item_clicked==false && position==0){
                holder.category_name.setTextColor(Color.parseColor("#04B10B"));
                holder.view_select.setBackgroundColor(Color.parseColor("#04B10B"));
                holder.layout_item.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            else {
                holder.view_select.setBackgroundColor(Color.parseColor("#A6F2F4F0"));
                holder.category_name.setTextColor(Color.parseColor("#000000"));
                holder.layout_item.setBackgroundColor(Color.parseColor("#A6F2F4F0"));

            }


        }

        @Override
        public int getItemCount() {
            return product_type_list.size();
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder {
          public   TextView category_name;
          public   ConstraintLayout layout_item;
          View view_select;
            public ItemViewHolder(@NonNull  View itemView) {
                super(itemView);
                category_name=itemView.findViewById(R.id.category_name);
                layout_item=itemView.findViewById(R.id.item_layout_c);
                view_select=itemView.findViewById(R.id.view_select);
            }
        }
    }

    }
