package com.Bootcamp2020Project.Project.Entities.Order;

import com.Bootcamp2020Project.Project.Entities.Product.ProductVariation;
import com.Bootcamp2020Project.Project.Entities.User.Users;

import javax.persistence.*;


@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CustomerUserId")
    private Users users;

    private Integer quantity;

    private Boolean isWishlistItem;

    public Boolean getWishlistItem() {
        return isWishlistItem;
    }

    public void setWishlistItem(Boolean wishlistItem) {
        isWishlistItem = wishlistItem;
    }

    @OneToOne
    @JoinColumn(name = "ProductVariationId")
    private ProductVariation productVariation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users user) {
        this.users = users;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public ProductVariation getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariation productVariation) {
        this.productVariation = productVariation;
    }
}