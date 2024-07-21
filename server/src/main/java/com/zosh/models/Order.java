package com.zosh.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private User customer;

    @ManyToOne()
    @JsonIgnore
    private Restaurant restaurant;

    private Long totalAmount;
    private String orderStatus;
    private Date createdAt;

    @ManyToOne
    private Address deliveryAddress;
}
