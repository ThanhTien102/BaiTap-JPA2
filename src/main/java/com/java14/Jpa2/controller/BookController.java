package com.java14.Jpa2.controller;

import com.java14.Jpa2.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {

        if (author != null && !author.isEmpty()) {
            return ResponseEntity.ok(bookServices.getBookByAuthor(author));
        }
        if (minPrice != null && maxPrice != null) {
            return ResponseEntity.ok(bookServices.findByPriceBetween(minPrice, maxPrice));
        }
        return ResponseEntity.badRequest().body("Vui lòng truyền tham số tìm kiếm (author hoặc minPrice & maxPrice)");
    }
}
