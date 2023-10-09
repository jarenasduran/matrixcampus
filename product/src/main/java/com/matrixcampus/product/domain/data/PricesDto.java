package com.matrixcampus.product.domain.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PricesDto {

    private int productId;

    private int brandId;

    private String startDate;

    private String endDate;

    private double price;
}
