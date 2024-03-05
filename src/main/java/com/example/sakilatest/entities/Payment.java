package com.example.sakilatest.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Short id;

    //todo referential customer_id, staff_id, rental_id

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="payment_date")
    private Date paymentDate;
}