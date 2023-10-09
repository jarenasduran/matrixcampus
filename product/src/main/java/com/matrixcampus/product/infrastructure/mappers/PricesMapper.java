package com.matrixcampus.product.infrastructure.mappers;

import com.matrixcampus.product.domain.data.PricesDto;
import com.matrixcampus.product.infrastructure.entity.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricesMapper {

    PricesMapper INSTANCE = Mappers.getMapper( PricesMapper.class );

    PricesDto pricesToPricesDto(Prices price);
}
