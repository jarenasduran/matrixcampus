package com.matrixcampus.product.infrastructure.repository;

import com.matrixcampus.product.infrastructure.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

    @Query("SELECT prices FROM Prices prices WHERE prices.brandId = :brandId AND prices.productId = :productId AND prices.startDate <= :dateTime AND prices.endDate >= :dateTime ORDER BY prices.priority DESC")
    List<Prices> getRicePrices(@Param("brandId") int brandId, @Param("productId") int productId, @Param("dateTime") LocalDateTime dateTime);
}
