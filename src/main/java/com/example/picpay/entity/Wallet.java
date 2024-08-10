package com.example.picpay.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_wallet")
public class Wallet {
    public Wallet() {
    }

    public Wallet(String fullname, String cpfCnpj, String email, String password, WalletType walletType) {
        this.fullname = fullname;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.walletType = walletType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "full_name")
    private String fullname;

    @Column(name= "cpf_cnpj", unique = true)
    private String cpfCnpj;

    @Column(name= "email", unique = true)
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name= "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @JoinColumn(name = "wallet_type")
    @ManyToOne
    private WalletType walletType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }
}
