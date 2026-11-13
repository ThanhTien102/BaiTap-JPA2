package com.java14.Jpa2.services;

import com.java14.Jpa2.dto.BookDTO;

import java.math.BigDecimal;
import java.util.List;

public interface BookServices {
    List<BookDTO> getBookByAuthor(String author);
    List<BookDTO> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
