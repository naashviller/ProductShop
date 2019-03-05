package ru.itis.services;

import ru.itis.dto.BasketDto;
import ru.itis.model.User;

public interface BasketService {

    User findUser(Long id);

    void addProduct(Long userId, Long productId);

    BasketDto getUserProducts(User user);
}
