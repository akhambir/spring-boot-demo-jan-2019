package com.akhambir.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "MONEY_TRANSFER_HISTORY")
public class MoneyTransfer {

    private Long id;
    private Integer fromAccount;
    private Integer toAccount;
    private Double amount;
    private LocalDateTime timestamp;

    public MoneyTransfer() {
    }

    public MoneyTransfer(Integer fromAccount, Integer toAccount, Double amount, LocalDateTime timestamp) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Integer fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Integer getToAccount() {
        return toAccount;
    }

    public void setToAccount(Integer toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static MoneyTransfer of(Integer fromAccount, Integer toAccount, Double amount, LocalDateTime now) {
        return new MoneyTransfer(fromAccount, toAccount, amount, now);
    }
}
