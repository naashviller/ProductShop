package ru.itis.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Long cost;

    @ManyToMany(mappedBy = "productList")
    private List<Basket> basketList = new ArrayList<>();


    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basbas",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "basket_id"))
    private List<Basket> basketList = new ArrayList<>();*/

    /*@ManyToMany(mappedBy = "products")
    private List<Basket> baaskets = new ArrayList<>();*/


    //@ManyToMany
    /*@JoinTable(name = "baskets_products", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns=@JoinColumn(name="basket_id"))*/
    //@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    /*@ManyToMany(mappedBy = "productBasket")
    private List<Basket> basket;*/

}