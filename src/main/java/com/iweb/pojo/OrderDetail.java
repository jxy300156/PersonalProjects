package com.iweb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jxy
 * @date
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetail {
    private int orderDeId;
    private int orderId;
    private int productId;
    private int quantity;
}
