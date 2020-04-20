package com.Bootcamp2020Project.Project.Entities.Product;

import com.Bootcamp2020Project.Project.Entities.Order.Cart;
import com.Bootcamp2020Project.Project.Entities.Product.Product;

import javax.persistence.*;

@Entity
public class ProductVariation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantityAvailable;
    private Double price;
    private String primaryImageName;



    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    @ManyToOne
    @JoinColumn
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ProductVariation() {
    }

    public ProductVariation(Integer quantityAvailable, Double price) {
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPrimaryImageName() {
        return primaryImageName;
    }

    public void setPrimaryImageName(String primaryImageName) {
        this.primaryImageName = primaryImageName;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductVariation{" +
                "quantityAvailable=" + quantityAvailable +
                ", price=" + price +
                ", primaryImageName='" + primaryImageName + '\'' +
                ", product=" + product +
                '}';
    }
}