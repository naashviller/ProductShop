package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.BasketDto;
import ru.itis.model.Basket;
import ru.itis.model.Product;
import ru.itis.model.User;
import ru.itis.repositories.BasketRepository;
import ru.itis.repositories.ProductRepository;
import ru.itis.repositories.UserRepository;
import ru.itis.services.BasketService;

import java.util.HashSet;
import java.util.Set;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Override
    public User findUser(Long id) {
        return userRepository.getOne(id);
    }

    public void addProduct(User user, Long productId) {

        Product product = productRepository.getOne(productId);
        Basket basket = user.getBasket();

        if (basket == null) {
            basket = Basket.builder()
                    .user(user)
                    .products(new HashSet<>())
                    .build();

            user.setBasket(basket);

            basketRepository.save(basket);
        }

        Set<Product> products = basket.getProducts();

        products.add(product);
        basket.setProducts(products);
        for (Product p : basket.getProducts()) {
            System.out.println(p.getName());
        }

        basketRepository.saveAndFlush(basket);
    }


    public BasketDto getUserProducts(User user) {
        return BasketDto.from(user.getBasket());
    }

}