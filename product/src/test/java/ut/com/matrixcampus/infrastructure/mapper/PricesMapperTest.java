package ut.com.matrixcampus.infrastructure.mapper;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.infrastructure.entity.Prices;
import com.matrixcampus.product.infrastructure.mappers.PricesMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricesMapperTest {

    @Test
    public void mapperTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2020-06-14 10:00:00", formatter);

        Prices price1 = Prices.builder().id(1).price(50).priceList(1).brandId(1).curr("EUR").startDate(dateTime).endDate(dateTime).priority(1).productId(35455).build();
        Prices price2 = Prices.builder().id(4).price(78.9).priceList(6).brandId(1).curr("EUR").startDate(dateTime).endDate(dateTime).priority(2).productId(35495).build();
        Prices price3 = Prices.builder().id(7).price(15).priceList(1).brandId(1).curr("EUR").startDate(dateTime).endDate(dateTime).priority(3).productId(37803).build();

        PricesDto pricesDtoExpected1 = PricesDto.builder().price(50).brandId(1).startDate("2020-06-14T10:00:00").endDate("2020-06-14T10:00:00").productId(35455).build();
        PricesDto pricesDtoExpected2 = PricesDto.builder().price(78.9).brandId(1).startDate("2020-06-14T10:00:00").endDate("2020-06-14T10:00:00").productId(35495).build();
        PricesDto pricesDtoExpected3 = PricesDto.builder().price(15).brandId(1).startDate("2020-06-14T10:00:00").endDate("2020-06-14T10:00:00").productId(37803).build();

        PricesDto pricesDtoActual1 = PricesMapper.INSTANCE.pricesToPricesDto(price1);
        PricesDto pricesDtoActual2 = PricesMapper.INSTANCE.pricesToPricesDto(price2);
        PricesDto pricesDtoActual3 = PricesMapper.INSTANCE.pricesToPricesDto(price3);

        assertEquals(pricesDtoExpected1, pricesDtoActual1);
        assertEquals(pricesDtoExpected2, pricesDtoActual2);
        assertEquals(pricesDtoExpected3, pricesDtoActual3);
    }

}
