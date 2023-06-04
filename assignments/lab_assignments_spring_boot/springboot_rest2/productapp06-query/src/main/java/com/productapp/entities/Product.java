package com.productapp.entities;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

//OOPs: SRP
//Product : Entity and it working as DTO and validation
//2 sepate classes Product in entity package and one in dto
@Entity
@Table(name="product_table")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name should be left black")
    private String name;

   // @NotNull(message = "product.price.absent")
  //  @Range(min = 100, max = 200000, message = "product.price.invalid")
    private BigDecimal price;

    private LocalDate mfgDate;

    public Product(String name, BigDecimal price, LocalDate mfgDate) {
        this.name = name;
        this.price = price;
        this.mfgDate = mfgDate;
    }
}










