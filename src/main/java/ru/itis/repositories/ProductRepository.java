package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
