package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
