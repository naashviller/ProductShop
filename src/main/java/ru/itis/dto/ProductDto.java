package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private Long cost;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }

    public static List<ProductDto> from(List<Product> products) {
        return products.stream().map(ProductDto::from).collect(Collectors.toList());
    }
}
