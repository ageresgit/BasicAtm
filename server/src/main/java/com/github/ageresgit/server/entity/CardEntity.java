package com.github.ageresgit.server.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Paymentcards")
@NoArgsConstructor
@Getter
@Setter
public class CardEntity {
    @Id
    @Column(name = "pan", nullable = false, length = 16)
    private String pan;

    @Column(name = "pin", nullable = false, length = 4)
    private String pin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account", referencedColumnName = "id")
    private AccountEntity account;
}
