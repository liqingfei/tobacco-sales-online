package com.tobacco.sales.entity;

import java.util.UUID;

public class Order {

    private String id;
    private String username;
    private String tobaccoId;
    private int quantity;
    private float money;
    private int status;
    private long updated;

    public String getId() {
        if (id == null) {
            id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTobaccoId() {
        return tobaccoId;
    }

    public void setTobaccoId(String tobaccoId) {
        this.tobaccoId = tobaccoId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUpdated() {
        if (updated == 0) {
            updated = System.currentTimeMillis();
        }
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id != null ? id.equals(order.id) : order.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", tobaccoId='" + tobaccoId + '\'' +
                ", quantity=" + quantity +
                ", money=" + money +
                ", status=" + status +
                ", updated=" + updated +
                '}';
    }
}
