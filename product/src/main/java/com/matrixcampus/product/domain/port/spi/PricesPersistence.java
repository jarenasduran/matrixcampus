package com.matrixcampus.product.domain.port.spi;

import com.matrixcampus.product.domain.data.PricesDto;

import java.time.LocalDateTime;

public interface PricesPersistence {

    PricesDto getPrices(LocalDateTime date, int productId, int brandId);
}
