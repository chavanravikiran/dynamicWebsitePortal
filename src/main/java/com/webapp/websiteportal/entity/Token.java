package com.webapp.websiteportal.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Token {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq")
    @SequenceGenerator(name = "token_seq", sequenceName = "token_seq", allocationSize = 100)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String token;

    @NotNull
    private Date createdAt = new Date();

    @NotNull
    private Date expiryAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Token(String token, Date expiryAt, Account account) {
        this.token = token;
        this.expiryAt = expiryAt;
        this.account = account;
    }

}
