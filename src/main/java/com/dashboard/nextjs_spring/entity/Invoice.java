package com.dashboard.nextjs_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String customer_id;
    private String amount;
    private String status;
    private String date;
}