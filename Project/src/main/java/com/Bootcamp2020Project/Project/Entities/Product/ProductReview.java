package com.Bootcamp2020Project.Project.Entities.Product;


import com.Bootcamp2020Project.Project.Entities.User.Customer;

import javax.persistence.*;

@Entity
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String review;
    private Double rating;


    @ManyToOne
    @JoinColumn(name = "CustomerUserId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;


    public ProductReview() {
    }

    public ProductReview(String review, Double rating) {
        this.review = review;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Customer getAuthor() {
        return customer;
    }

    public void setAuthor(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "review='" + review + '\'' +
                ", rating=" + rating +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
