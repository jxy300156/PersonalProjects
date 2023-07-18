package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author jxy
 * @date
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int pid;
    private String pName;
    private double originalPrice;
    private Category category;
    private int stock;
    private Date createDate;
    private double promotePrice;
    private String subTitle;

    public Product(String pName, double originalPrice, Category category, int stock, Date createDate, double promotePrice, String subTitle) {
        this.pName = pName;
        this.originalPrice = originalPrice;
        this.category = category;
        this.stock = stock;
        this.createDate = createDate;
        this.promotePrice = promotePrice;
        this.subTitle = subTitle;
    }
}
