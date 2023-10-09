package com.matrixcampus.product.infrastructure.adapter;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.domain.port.spi.PricesPersistence;
import com.matrixcampus.product.infrastructure.entity.Prices;
import com.matrixcampus.product.infrastructure.mappers.PricesMapper;
import com.matrixcampus.product.infrastructure.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricesJpaAdapter implements PricesPersistence {

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public PricesDto getPrices(LocalDateTime date, int productId, int brandId) {

        List<Prices> pricesList = pricesRepository.getRicePrices(brandId, productId, date);

        Prices prices = pricesList.stream().findFirst().isPresent() ? pricesList.stream().findFirst().get() : null;

        return PricesMapper.INSTANCE.pricesToPricesDto(prices);
    }
}
