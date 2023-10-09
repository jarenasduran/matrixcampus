package com.matrixcampus.product.application;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.domain.port.api.PricesServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
public class PricesController {

    @Autowired
    private PricesServicePort pricesServicePort;

    @GetMapping("/get")
    public PricesDto getPriceDto(@RequestParam(value = "brand_id") int brandId, @RequestParam(value = "product_id") int productId, @RequestParam(value = "date_time") String dateTime) {
        return pricesServicePort.getPrices(dateTime,productId,brandId);
    }
}
