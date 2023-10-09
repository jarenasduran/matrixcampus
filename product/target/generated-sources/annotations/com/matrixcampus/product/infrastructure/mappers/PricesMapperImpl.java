package com.matrixcampus.product.infrastructure.mappers;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.infrastructure.entity.Prices;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-09T14:14:05+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class PricesMapperImpl implements PricesMapper {

    @Override
    public PricesDto pricesToPricesDto(Prices price) {
        if ( price == null ) {
            return null;
        }

        PricesDto.PricesDtoBuilder pricesDto = PricesDto.builder();

        pricesDto.productId( price.getProductId() );
        pricesDto.brandId( price.getBrandId() );
        if ( price.getStartDate() != null ) {
            pricesDto.startDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( price.getStartDate() ) );
        }
        if ( price.getEndDate() != null ) {
            pricesDto.endDate( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( price.getEndDate() ) );
        }
        pricesDto.price( price.getPrice() );

        return pricesDto.build();
    }
}
