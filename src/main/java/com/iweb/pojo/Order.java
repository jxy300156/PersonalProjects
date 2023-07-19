package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author jxy
 * @date
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Order {
    private int oid;
    private int userId;
    private int addressId;
    private Date oDate;
    private String orderStatus;

    public Order(int userId, int addressId, Date oDate, String orderStatus) {
        this.userId = userId;
        this.addressId = addressId;
        this.oDate = oDate;
        this.orderStatus = orderStatus;
    }
}
