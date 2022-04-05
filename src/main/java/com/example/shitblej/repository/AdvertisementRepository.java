package com.example.shitblej.repository;

import com.example.shitblej.model.Advertisement;
import com.example.shitblej.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.shitblej.model.Advertisement.Type;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
  @Query(value = "SELECT a FROM Advertisement a "
      + "WHERE (:type IS NULL OR a.type = :type )"
      + "AND (:category IS NULL OR a.category = :category) "
      + "AND (:priceFrom IS NULL OR a.price >= :priceFrom) "
      + "AND (:priceTo IS NULL OR a.price <= :priceTo)")
  Page<Advertisement> findByFiltersPaged(
      @Param("type") Type type,
      @Param("category") Category category,
      @Param("priceFrom") Integer priceFrom,
      @Param("priceTo") Integer priceTo,
      Pageable pageable
  );
}
