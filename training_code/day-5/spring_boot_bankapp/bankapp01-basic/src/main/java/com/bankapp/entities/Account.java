package com.bankapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "account_table")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal balance;

    private String phone;
    private String email;


    public Account(String name, BigDecimal balance, String phone, String email) {
        this.name = name;
        this.balance = balance;
        this.phone = phone;
        this.email = email;
    }
}
