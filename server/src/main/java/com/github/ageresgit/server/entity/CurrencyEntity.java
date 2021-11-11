package com.github.ageresgit.server.entity;

import com.github.ageresgit.common.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Currency")
@NoArgsConstructor
@Getter
@Setter
public class CurrencyEntity {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "iso")
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
}
