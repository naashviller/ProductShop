package ru.itis.dto;

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
    private List<Product> products;

    public static BasketDto from(Basket basket) {
        return BasketDto.builder()
                .products(basket.getProductList())
                .build();
    }

    public static List<BasketDto> from(List<Basket> baskets) {
        return baskets.stream().map(BasketDto::from).collect(Collectors.toList());
    }
}
