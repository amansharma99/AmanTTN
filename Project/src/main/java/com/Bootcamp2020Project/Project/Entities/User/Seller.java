package com.Bootcamp2020Project.Project.Entities.User;

import com.Bootcamp2020Project.Project.Entities.Product.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "UserId")
public class Seller extends Users {

    private String GST;
    private String companyName;
    private Long companyContact;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Product> products;


    public Seller() {
        this.addRole(new Role(2l, "ROLE_SELLER"));
    }

    public Seller(String email, String firstName, String middleName, String lastName, String GST, String companyName, Long companyContact) {
        super(email, firstName, middleName, lastName);
        this.GST = GST.toUpperCase();
        this.companyName = companyName;
        this.companyContact = companyContact;
        this.addRole(new Role(2l, "ROLE_SELLER"));
    }

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "seller",fetch = FetchType.EAGER)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGST() {
        return GST;
    }

    public void setGST(String GST) {
        this.GST = GST;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(Long companyContact) {
        this.companyContact = companyContact;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Seller{" +
                super.toString() +
                "GST='" + GST + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyContact='" + companyContact + '\'' +
                '}';
    }

    public void addProduct(Product product){
        if(product != null){
            if(products == null)
                products = new HashSet<Product>();

            products.add(product);

            product.setSeller(this);
        }
    }
}