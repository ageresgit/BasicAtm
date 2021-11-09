package com.github.ageresgit.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@Getter
@Setter
public class AccountEntity {
    @Id
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency", referencedColumnName = "id")
    private CurrencyEntity currency;

    @Column(name = "balance")
    private BigDecimal balance;

}
