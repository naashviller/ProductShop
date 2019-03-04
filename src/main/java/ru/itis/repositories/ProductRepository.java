package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Product;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
