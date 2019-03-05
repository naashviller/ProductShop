package ru.itis.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.model.Basket;
import ru.itis.model.Product;
import ru.itis.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketDto {
    private Set<Product> products;

    public static BasketDto from(Basket basket) {
        return BasketDto.builder()
                .products(basket.getProducts())
                .build();
    }

    public static List<BasketDto> from(List<Basket> baskets) {
        return baskets.stream().map(BasketDto::from).collect(Collectors.toList());
    }
}