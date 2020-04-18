package com.Bootcamp2020Project.Project.Entities.Order;

import com.Bootcamp2020Project.Project.Entities.Order.OrderProduct;

import javax.persistence.*;

enum FROM_STATUS
{
    ORDER_PLACED,
    CANCELLED,
    ORDER_REJECTED,
    ORDER_CONFIRMED,
    ORDER_SHIPPED,
    DELIVERED,
    RETURN_REQUESTED,
    RETURN_REJECTED,
    RETURN_APPROVED,
    PICK_UP_INITIATED,
    PICK_UP_COMPLETED,
    REFUND_INITIATED,
    REFUND_COMPLETED
}
enum TO_STATUS
{
    CANCELLED,
    ORDER_CONFIRMED,
    ORDER_REJECTED,
    REFUND_INITIATED,
    CLOSED,
    ORDER_SHIPPED,
    DELIVERED,
    RETURN_REQUESTED,
    RETURN_REJECTED,
    RETURN_APPROVE,
    PICK_UP_INITIATED,
    PICK_UP_COMPLETED,

    REFUND_COMPLETED,

}@Entity
@Table(name = "OrderStatus")
public class OrderStatus  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String TransitionNotesComments;
    @OneToOne
    @JoinColumn(name = "OrderedProductId")
    private OrderProduct orderProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public String getTransitionNotesComments() {
        return TransitionNotesComments;
    }

    public void setTransitionNotesComments(String transitionNotesComments) {
        TransitionNotesComments = transitionNotesComments;
    }
}