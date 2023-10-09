package com.matrixcampus.product.domain.service;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.domain.port.api.PricesServicePort;
import com.matrixcampus.product.domain.port.spi.PricesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PricesServiceImpl implements PricesServicePort {

    @Autowired
    private PricesPersistence pricesPersistence;

    @Override
    public PricesDto getPrices(String date, int productId, int brandId) {
        LocalDateTime dateTime = formatDate(date);

        return pricesPersistence.getPrices(dateTime, productId, brandId);
    }

    public LocalDateTime formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }
}
