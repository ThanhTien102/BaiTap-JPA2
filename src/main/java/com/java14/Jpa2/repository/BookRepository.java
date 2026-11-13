package com.java14.Jpa2.repository;

import com.java14.Jpa2.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
