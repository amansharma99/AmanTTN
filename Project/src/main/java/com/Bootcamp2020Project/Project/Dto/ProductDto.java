package com.Bootcamp2020Project.Project.Dto;

public class ProductDto {

    private String productName;
    private String description;
    private String brand;
    private boolean isCancellable;
    private boolean isReturnable;

    public ProductDto(String productName, String description, String brand, boolean isCancellable, boolean isReturnable) {
        this.productName = productName;
        this.description = description;
        this.brand = brand;
        this.isCancellable = isCancellable;
        this.isReturnable = isReturnable;
    }

    public ProductDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isCancellable() {
        return isCancellable;
    }

    public void setCancellable(boolean cancellable) {
        this.isCancellable = cancellable;
    }

    public boolean isReturnable() {
        return isReturnable;
    }

    public void setReturnable(boolean returnable) {
        this.isReturnable = returnable;
    }
}
