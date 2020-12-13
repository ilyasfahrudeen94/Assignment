package com.iliyas.sample.models;

import java.io.Serializable;

public class FoodItemData implements Serializable {
    private String title;
    private String description;
    private String details;
    private String imgUrl;
    private int quantity;
    private String productCode;

    public FoodItemData(String title, String description, String details, String imgUrl, int quantity, String productCode) {
        this.title = title;
        this.description = description;
        this.details = details;
        this.imgUrl = imgUrl;
        this.quantity = quantity;
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
