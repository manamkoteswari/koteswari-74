package com.koteswari.productsearchapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ProductDataModel> arrProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


        arrProducts = (ArrayList<ProductDataModel>) getIntent().getSerializableExtra("products");
        listView = (ListView)findViewById(R.id.lstSearchResults) ;
        listView.setAdapter(new ProductsAadapter(SearchResultsActivity.this, arrProducts));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(SearchResultsActivity.this, ProductDetailsActivity.class);
                intent.putExtra("productName", arrProducts.get(i).getProductName());
                intent.putExtra("productPrice", arrProducts.get(i).getProductPrice());
                intent.putExtra("productDescription", arrProducts.get(i).getProductDescription());

                startActivity(intent);
            }
        });

    }


    public class ProductsAadapter extends BaseAdapter {
        ArrayList<ProductDataModel> listData = null;
        Context context;

        public ProductsAadapter(Context context, ArrayList<ProductDataModel> listData) {
            this.listData = listData;
            this.context = context;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.products_list_item, null);
            }

            ((TextView)convertView.findViewById(R.id.productname)).setText(listData.get(position).getProductName());

            return convertView;
        }
    }
}
