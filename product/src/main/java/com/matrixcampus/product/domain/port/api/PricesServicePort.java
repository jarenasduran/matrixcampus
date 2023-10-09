package com.matrixcampus.product.domain.port.api;

import com.matrixcampus.product.domain.data.PricesDto;
import org.springframework.stereotype.Service;

public interface PricesServicePort {

    PricesDto getPrices(String date, int productId, int brandId);
}
