package com.koteswari.productsearchapp;

import java.io.Serializable;

/**
 * Created by ABC on 09/04/2017.
 */

public class ProductDataModel implements Serializable{

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    private String productName = "";
    private String productPrice = "";
    private String productDescription = "";


}
