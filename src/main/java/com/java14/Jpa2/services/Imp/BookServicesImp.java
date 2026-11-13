package com.java14.Jpa2.services.Imp;

import com.java14.Jpa2.dto.BookDTO;
import com.java14.Jpa2.repository.BookRepository;
import com.java14.Jpa2.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServicesImp implements BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author).stream()
                .map(item -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setId(item.getId());
                    bookDTO.setAuthor(item.getAuthor());
                    bookDTO.setPrice(item.getPrice());
                    bookDTO.setTitle(item.getTitle());
                    return bookDTO;
                }).toList();
    }

    @Override
    public List<BookDTO> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice).stream()
                .map(item -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setId(item.getId());
                    bookDTO.setAuthor(item.getAuthor());
                    bookDTO.setPrice(item.getPrice());
                    bookDTO.setTitle(item.getTitle());
                    return bookDTO;
                }).toList();
    }
}
