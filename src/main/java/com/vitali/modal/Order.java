package com.vitali.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}