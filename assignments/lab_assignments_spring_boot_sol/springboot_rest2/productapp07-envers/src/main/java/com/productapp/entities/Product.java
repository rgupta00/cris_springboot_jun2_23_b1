package com.productapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

//OOPs: SRP
//Product : Entity and it working as DTO and validation
//2 sepate classes Product in entity package and one in dto

//4. We need to configure @EntityLister
@Audited
@EntityListeners(AuditingEntityListener.class)
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

    //-----------1. added new fields------------

    @JsonIgnore
    @CreatedBy
    private String createdBy;

    @JsonIgnore
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonIgnore
    @LastModifiedBy
    private String modifiedBy;

    @JsonIgnore
    @LastModifiedDate
    private Date modifiedDate;



    public Product(String name, BigDecimal price, LocalDate mfgDate) {
        this.name = name;
        this.price = price;
        this.mfgDate = mfgDate;
    }
}










