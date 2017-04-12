package com.koteswari.productsearchapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    EditText txtCardNumber;
    EditText txtExpMonth;
    EditText txtExpYear;
    EditText txtCVV;
    EditText txtPhneNum;
    EditText txtPinCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        txtCardNumber = (EditText)findViewById(R.id.txtCardNum);
        txtExpMonth = (EditText)findViewById(R.id.txtMonth);
        txtExpYear = (EditText)findViewById(R.id.txtYear);
        txtCVV = (EditText)findViewById(R.id.txtcvv);
        txtPhneNum = (EditText)findViewById(R.id.txtPhneNo);
        txtPinCode = (EditText)findViewById(R.id.txtPinCode);

        ((Button)findViewById(R.id.btnBuy)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate();
            }
        });


    }


    private void validate(){

        if(txtCardNumber.getText().toString().length() < 0 || txtCardNumber.getText().toString().length() < 16){

            showDialog("please enter valid card number");
            return;

        }
        else if(txtExpMonth.getText().toString().length() <2){

            showDialog("please enter valid expiry month");
            return;
        }
        else if(txtExpYear.getText().toString().length() <4){

            showDialog("please enter valid expiry year");
            return;
        }
        else if(txtCVV.getText().toString().length() <3){

            showDialog("please enter valid CVV");
            return;
        }
        else if(txtPinCode.getText().toString().length() < 6){

            showDialog("please enter valid pin code");
            return;
        }
        else if(txtPhneNum.getText().toString().length() < 10){

            showDialog("please enter valid phone num");
        }
        else {

            AlertDialog alertDialog = new AlertDialog.Builder(PaymentActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Payment Successful");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                            startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                        }
                    });
            alertDialog.show();

        }
    }


    private void showDialog(String msg){

        AlertDialog alertDialog = new AlertDialog.Builder(PaymentActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}
