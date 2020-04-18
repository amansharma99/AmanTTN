package com.Bootcamp2020Project.Project.Entities.User;

import com.Bootcamp2020Project.Project.Entities.Product.ProductReview;
import com.Bootcamp2020Project.Project.Entities.User.Role;
import com.Bootcamp2020Project.Project.Entities.User.Users;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
public class Customer extends Users {

    private String contact;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ProductReview> reviews;


    public Customer() {
        this.addRole(new Role(3l, "ROLE_CUSTOMER"));
    }


    public Customer(String email, String firstName, String middleName, String lastName, String contact) {
        super(email, firstName, middleName, lastName);
        this.addRole(new Role(3l, "ROLE_CUSTOMER"));
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
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