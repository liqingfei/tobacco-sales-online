package com.tobacco.sales.entity;


public class TobaccoQuantity {

    private long id;
    private String tobaccoId;
    private int quantity;
    private int status;
    private long updated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TobaccoQuantity that = (TobaccoQuantity) o;

        if (id != that.id) return false;
        return tobaccoId != null ? tobaccoId.equals(that.tobaccoId) : that.tobaccoId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tobaccoId != null ? tobaccoId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TobaccoQuantity{" +
                "id=" + id +
                ", tobaccoId='" + tobaccoId + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                ", updated=" + updated +
                '}';
    }
}
