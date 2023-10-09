package ut.com.matrixcampus.infrastructure.adapter;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.infrastructure.adapter.PricesJpaAdapter;
import com.matrixcampus.product.infrastructure.entity.Prices;
import com.matrixcampus.product.infrastructure.repository.PricesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class PricesJpaAdapterTest {

    @Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private PricesJpaAdapter pricesJpaAdapter;

    @Test
    public void getPrices() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2020-06-14 16:00:00", formatter);

        List<Prices> priceList = Arrays.asList(
                Prices.builder().id(1).price(50).priceList(1).brandId(1).curr("EUR").startDate(dateTime).endDate(dateTime).priority(0).productId(35455).build(),
                Prices.builder().id(4).price(78.9).priceList(6).brandId(1).curr("EUR").startDate(dateTime).endDate(dateTime).priority(1).productId(35495).build()
        );

        PricesDto pricesDtoExpected = PricesDto.builder().price(50).brandId(1).startDate("2020-06-14T16:00:00").endDate("2020-06-14T16:00:00").productId(35455).build();

        Mockito.when(pricesRepository.getRicePrices(anyInt(), anyInt(), any())).thenReturn(priceList);

        PricesDto pricesDtoActual = pricesJpaAdapter.getPrices(dateTime, 1, 35455);

        assertEquals(pricesDtoExpected, pricesDtoActual);
    }
}