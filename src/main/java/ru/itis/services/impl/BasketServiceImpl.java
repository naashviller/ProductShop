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

import java.util.ArrayList;
import java.util.List;

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

        if (user.getBasket() == null) {
            Basket basket = new Basket();
            user.setBasket(basket);
            //userRepository.save(user);

/*
            Basket basket = new Basket().builder()

                    .user(user)

                    .products(null)
                    .build();
*/

            userRepository.save(user);
            basketRepository.save(basket);
        }

        List<Product> products = new ArrayList<>();
        //products.addAll(user.getBasket().getProducts());

        products.add(product);
        //user.setBasket((Basket) products);

        userRepository.save(user);
    }


    public BasketDto getUserProducts(User user) {
        return BasketDto.from(user.getBasket());
        //BasketDto.builder(user.getBasket());
    }

}
