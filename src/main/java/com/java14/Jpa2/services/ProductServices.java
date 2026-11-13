package com.java14.Jpa2.services;

import com.java14.Jpa2.dto.ProductDTO;
import com.java14.Jpa2.request.InsertProductRequest;
import com.java14.Jpa2.request.UpdateProductRequest;

import java.util.List;

public interface ProductServices {
    ProductDTO addProduct(InsertProductRequest Request);
    List<ProductDTO> getAllProducts();
    ProductDTO getProduct(int id);
    ProductDTO updateProduct(UpdateProductRequest request, int id);
    void deleteProduct(int id);
}
