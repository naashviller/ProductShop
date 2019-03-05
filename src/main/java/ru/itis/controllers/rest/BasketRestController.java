package ru.itis.controllers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dto.BasketDto;
import ru.itis.services.BasketService;

@RestController
public class BasketRestController {
    private BasketService basketService;

    public BasketRestController(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/add/{id}")
    public void addToBasket(@PathVariable Long id) {

        basketService.addProduct(basketService.findUser(1L), id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/basket")
    public ResponseEntity<BasketDto> getUserProducts() {

        return ResponseEntity.ok(basketService.getUserProducts(basketService.findUser(1L)));
    }

}
