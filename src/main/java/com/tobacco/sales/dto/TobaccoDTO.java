package com.tobacco.sales.dto;

import com.tobacco.sales.entity.Tobacco;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tobacco")
@XmlAccessorType(XmlAccessType.FIELD)
public class TobaccoDTO extends Tobacco {
}
