package com.Bootcamp2020Project.Project.Entities.Order;

import com.Bootcamp2020Project.Project.Entities.Product.ProductVariation;
import com.Bootcamp2020Project.Project.Entities.User.Customer;
import com.Bootcamp2020Project.Project.Entities.User.Users;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CustomerUserId")
    private Customer customer;

    private Integer quantity;

    private Boolean isWishlistItem;

    public Boolean getWishlistItem() {
        return isWishlistItem;
    }

    public void setWishlistItem(Boolean wishlistItem) {
        isWishlistItem = wishlistItem;
    }

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<ProductVariation> productVariation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<ProductVariation> getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(Set<ProductVariation> productVariation) {
        this.productVariation = productVariation;
    }
}