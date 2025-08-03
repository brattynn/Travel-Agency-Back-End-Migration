package com.d288.d288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;      //Info from carts table. This needs to have a UML relationship.

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    private Vacation vacation;  //Info from vacations table. This needs to have a UML relationship.

    @ManyToMany
    private Set<Excursion> excursions;
}
