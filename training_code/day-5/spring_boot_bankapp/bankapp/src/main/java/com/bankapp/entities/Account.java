package com.bankapp.entities;

import jakarta.persistence.*;


import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "account_table")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "{account.name.absent}")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{account.name.invalid}")
    private String name;

    @NotNull(message = "{account.balance.absent}")
    @Range(min = 100, max = 100000, message = "{account.balance.invalid}")
    private BigDecimal balance;

    @NotNull(message = "{account.phone.absent}")
    @Pattern(regexp = "[789][0-9]{9}", message = "{account.phone.invalid}")
    private String phone;

    @Email(message = "{account.email.invalid}")
    @NotNull(message = "{account.email.absent}")
    private String email;


    public Account(String name, BigDecimal balance, String phone, String email) {
        this.name = name;
        this.balance = balance;
        this.phone = phone;
        this.email = email;
    }
}
