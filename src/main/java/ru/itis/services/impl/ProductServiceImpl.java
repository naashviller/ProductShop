package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.ProductDto;
import ru.itis.repositories.ProductRepository;
import ru.itis.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    public List<ProductDto> getAllProducts() {
        return ProductDto.from(repository.findAll());
    }


}
