package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductDetails {

    @Id
    private int productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    private double productPrice;

}
