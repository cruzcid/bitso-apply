package com.bitso.challenge.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents a buy or sell order.
 */
@Entity
public class Order {

    public enum Status {
        active,
        processing,
        cancelled,
        complete,
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long userId;
    private Status status;
    private Date created;
    private Currency major;
    private Currency minor;
    private BigDecimal amount;
    private BigDecimal price;
    private boolean buy;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Currency getMajor() {
        return major;
    }

    public void setMajor(Currency major) {
        this.major = major;
    }

    public Currency getMinor() {
        return minor;
    }

    public void setMinor(Currency minor) {
        this.minor = minor;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

}
