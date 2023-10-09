package com.matrixcampus.product;

import com.matrixcampus.product.infrastructure.entity.Prices;
import com.matrixcampus.product.infrastructure.repository.PricesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest()
public class PricesRepositoryITTest {

    @Autowired
    private PricesRepository pricesRepository;

    @Test
    public void testRepositoryGetRicesPrices() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime dateTime = LocalDateTime.parse("2020-06-16 21:00:00", formatter);

        LocalDateTime startDate = LocalDateTime.parse("2020-06-15 16:00:00", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2020-12-31 23:59:59", formatter);

        LocalDateTime startDate2 = LocalDateTime.parse("2020-06-14 00:00:00", formatter);
        LocalDateTime endDate2 = LocalDateTime.parse("2020-12-31 23:59:59", formatter);



        List<Prices> pricesList = Arrays.asList(
                Prices.builder().id(4).productId(35455).brandId(1).startDate(startDate).endDate(endDate).price(38.95).curr("EUR").priority(1).priceList(4).build(),
            Prices.builder().id(1).productId(35455).brandId(1).startDate(startDate2).endDate(endDate2).price(35.5).curr("EUR").priority(0).priceList(1).build()
        );

        List<Prices> pricesListResponse = pricesRepository.getRicePrices(1, 35455, dateTime);

        assertThat(pricesListResponse).hasSize(2).containsAnyElementsOf(pricesList);
    }
}
