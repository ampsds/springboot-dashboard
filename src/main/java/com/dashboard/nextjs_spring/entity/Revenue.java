package com.dashboard.nextjs_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "revenue")
public class Revenue {
    @Id
    private String month;
    private String revenue;
}