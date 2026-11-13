package com.java14.Jpa2.services.Imp;

import com.java14.Jpa2.dto.ProductDTO;
import com.java14.Jpa2.entity.ProductEntity;
import com.java14.Jpa2.repository.ProductRepository;
import com.java14.Jpa2.request.InsertProductRequest;
import com.java14.Jpa2.request.UpdateProductRequest;
import com.java14.Jpa2.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImp implements ProductServices {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO addProduct(InsertProductRequest Request) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(Request.getName());
        productEntity.setPrice(Request.getPrice());
        productEntity.setDescription(Request.getDescription());

        productRepository.save(productEntity);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(productEntity.getName());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setId(productEntity.getId());
        return  productDTO;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(item ->{
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setId(item.getId());
                    productDTO.setName(item.getName());
                    productDTO.setPrice(item.getPrice());
                    productDTO.setDescription(item.getDescription());
                    return  productDTO;
                }).toList();
    }

    @Override
    public ProductDTO getProduct(int id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Không tìm thấy san pham co id = "+id));
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());
        return   productDTO;
    }

    @Override
    public ProductDTO updateProduct(UpdateProductRequest request, int id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Không tìm thấy san pham co id ="+id));
        productEntity.setName(request.getName());
        productEntity.setPrice(request.getPrice());
        productEntity.setDescription(request.getDescription());

        productRepository.save(productEntity);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setDescription(productEntity.getDescription());

        return   productDTO;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy san pham co id = " + id));
        productRepository.deleteById(id);
    }
}
