package com.Bootcamp2020Project.Project.Entities.Order;

import com.Bootcamp2020Project.Project.Entities.User.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amountPaid;

    @Temporal(TemporalType.DATE)
    @Column(name = "DateCreated")
    private Date dateCreated;

    private String paymentMethod;

    private String customerCity;

    private String customerState;

    private String customerCountry;

    private String customerAddressLine;

    private Integer customerZipCode;

    private String customerLabel;


    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderProduct> orderProductsList;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CustomerId",nullable = false)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerAddressLine() {
        return customerAddressLine;
    }

    public void setCustomerAddressLine(String customerAddressLine) {
        this.customerAddressLine = customerAddressLine;
    }

    public Integer getCustomerZipCode() {
        return customerZipCode;
    }

    public void setCustomerZipCode(Integer customerZipCode) {
        this.customerZipCode = customerZipCode;
    }

    public String getCustomerLabel() {
        return customerLabel;
    }

    public void setCustomerLabel(String customerLabel) {
        this.customerLabel = customerLabel;
    }

    public List<OrderProduct> getOrderProductsList() {
        return orderProductsList;
    }

    public void setOrderProductsList(List<OrderProduct> orderProductsList) {
        this.orderProductsList = orderProductsList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}