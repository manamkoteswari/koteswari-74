package com.koteswari.productsearchapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertDataActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPrice;
    EditText editTextDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        editTextName = (EditText)findViewById(R.id.txtProductName);
        editTextPrice = (EditText)findViewById(R.id.txtPrice);
        editTextDescription = (EditText)findViewById(R.id.txtDescription) ;

        ((Button)findViewById(R.id.btnInsert)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductDataStore productDataStore = new ProductDataStore(InsertDataActivity.this);
                long l = productDataStore.insertValue(editTextName.getText().toString().trim(),editTextPrice.getText().toString().trim(),editTextDescription.getText().toString().trim() );

                if(l > 0){

                    Toast.makeText(InsertDataActivity.this, "product inserted successfully, insert another product", Toast.LENGTH_LONG).show();
                    editTextName.setText("");
                    editTextPrice.setText("");
                    editTextDescription.setText("");

                }

            }
        });

    }
}
