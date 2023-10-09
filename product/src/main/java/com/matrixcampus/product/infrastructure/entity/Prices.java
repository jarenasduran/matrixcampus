package com.matrixcampus.product.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prices {

    @Id
    private int id;

    private int productId;

    private int brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int priceList;

    private int priority;

    private double price;

    private String curr;
}
