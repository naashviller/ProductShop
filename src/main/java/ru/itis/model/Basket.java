package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "basket_id")
    @Column(name = "id")
    private Long id;


    @OneToOne(mappedBy = "basket")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher",
            joinColumns = @JoinColumn(name = "basket_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> productList;






/*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basbas",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();*/
    //@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "baskets")


    /*@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;*/

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "basket_products", joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns=@JoinColumn(name="product_id")
            private List<Product> productBasket;*/
}
