package com.vitali.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double quantity;

    @ManyToOne
    private Coin coin;

    private double buyPrice;
    private double sellPrice;

    @JsonIgnore //solve recursion problem
    @OneToOne
    private Order order;
}
