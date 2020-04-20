package com.Bootcamp2020Project.Project.Entities.User;

import com.Bootcamp2020Project.Project.Entities.Order.Orders;
import com.Bootcamp2020Project.Project.Entities.Product.ProductReview;
import com.Bootcamp2020Project.Project.Entities.User.Role;
import com.Bootcamp2020Project.Project.Entities.User.Users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
public class Customer extends Users {

    private long contact;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ProductReview> reviews;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> addresses;

    public void addAddress(Address address){
        if(address!=null){
            if(addresses == null)
                addresses = new HashSet<Address>();

            System.out.println("address added");
            address.setCustomer(this);
            addresses.add(address);
        }
    }

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Orders> orders;

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Customer() {
        this.addRole(new Role(3l, "ROLE_CUSTOMER"));
    }


    public Customer(String email, String firstName, String middleName, String lastName, long contact) {
        super(email, firstName, middleName, lastName);
        this.addRole(new Role(3l, "ROLE_CUSTOMER"));
        this.contact = contact;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public List<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReview> reviews) {
        this.reviews = reviews;
    }

    public void addReview(ProductReview review) {
        if (review != null) {
            if (reviews == null)
                reviews = new ArrayList<>();

            reviews.add(review);

            review.setAuthor(this);
        }
    }
}