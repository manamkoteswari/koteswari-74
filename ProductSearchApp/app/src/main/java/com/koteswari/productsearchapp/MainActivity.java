package com.koteswari.productsearchapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.txtSearchWord);

        ((Button)findViewById(R.id.btnSearch)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductDataStore productDataStore = new ProductDataStore(MainActivity.this);
                ArrayList<ProductDataModel> arrProducts = productDataStore.getProducts(editText.getText().toString().trim());

                if(arrProducts.size() <= 0){

                    Toast.makeText(MainActivity.this, "no data found ", Toast.LENGTH_LONG).show();
                    return;

                }
                else if(arrProducts.size() == 1){

                    Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
                    intent.putExtra("productName", arrProducts.get(0).getProductName());
                    intent.putExtra("productPrice", arrProducts.get(0).getProductPrice());
                    intent.putExtra("productDescription", arrProducts.get(0).getProductDescription());

                    startActivity(intent);

                }
                else {

                    Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
                    intent.putExtra("products", arrProducts);
                    startActivity(intent);
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.menu_insert:

                startActivity(new Intent(MainActivity.this, InsertDataActivity.class));
                break;
        }
        return true;
    }
}
