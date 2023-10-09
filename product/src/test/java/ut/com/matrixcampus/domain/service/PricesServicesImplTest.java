package ut.com.matrixcampus.domain.service;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.domain.port.spi.PricesPersistence;
import com.matrixcampus.product.domain.service.PricesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class PricesServicesImplTest {

    @Mock
    private PricesPersistence pricesPersistence;

    @InjectMocks
    private PricesServiceImpl pricesServicePort;

    final String date1 = "2020-06-14 10:00:00";
    final String date2 = "2020-06-16 16:00:00";
    final String date3 = "2020-06-17 21:00:00";

    @Test
    public void getPricesTest() {
        PricesDto priceDtoExpected = PricesDto.builder().brandId(1).productId(35455).price(35.5).endDate("2020-06-14T10:00").startDate("2020-06-14T10:00").build();

        Mockito.when(pricesPersistence.getPrices(any(), anyInt(), anyInt())).thenReturn(priceDtoExpected);

        PricesDto pricesDtoActual = pricesServicePort.getPrices(date1, 35455, 1);

        assertEquals(priceDtoExpected, pricesDtoActual);
    }

    @Test
    public void testFormatDate() {
        String dateExpected1 = "2020-06-14T10:00";
        String dateExpected2 = "2020-06-16T16:00";
        String dateExpected3 = "2020-06-17T21:00";

        LocalDateTime dateActual1 = pricesServicePort.formatDate(date1);
        LocalDateTime dateActual2 = pricesServicePort.formatDate(date2);
        LocalDateTime dateActual3 = pricesServicePort.formatDate(date3);

        assertEquals(dateExpected1, dateActual1.toString());
        assertEquals(dateExpected2, dateActual2.toString());
        assertEquals(dateExpected3, dateActual3.toString());
    }
}
