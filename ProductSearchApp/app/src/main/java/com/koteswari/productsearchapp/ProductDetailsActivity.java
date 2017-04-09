package com.koteswari.productsearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        String name = intent.getStringExtra("productName");
        String price = intent.getStringExtra("productPrice");
        String description = intent.getStringExtra("productDescription");

        ((TextView)findViewById(R.id.txtName)).setText(name);
        ((TextView)findViewById(R.id.txtPrice)).setText(price);
        ((TextView)findViewById(R.id.txtDescription)).setText(description);


    }
}
