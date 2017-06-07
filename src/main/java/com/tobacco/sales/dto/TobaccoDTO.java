package com.tobacco.sales.dto;

import com.tobacco.sales.entity.Tobacco;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tobacco")
@XmlAccessorType(XmlAccessType.FIELD)
public class TobaccoDTO extends Tobacco {

    @XmlAttribute
    private int quantity;
    @XmlAttribute
    private int status;

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
