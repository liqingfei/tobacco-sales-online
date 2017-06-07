package com.tobacco.sales.entity;

import java.util.UUID;

public class Tobacco {

    private String id;
    private String name;
    private String mfrs;
    private String spec;
    private float price;
    private String description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMfrs() {
        return mfrs;
    }

    public void setMfrs(String mfrs) {
        this.mfrs = mfrs;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        Tobacco tobacco = (Tobacco) o;

        return id != null ? id.equals(tobacco.id) : tobacco.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tobacco{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mfrs='" + mfrs + '\'' +
                ", spec='" + spec + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", updated=" + updated +
                '}';
    }
}
