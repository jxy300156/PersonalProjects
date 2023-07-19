package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jxy
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int addrId;
    private int userId;
    private String province;
    private String city;
    private String detail;

    public Address(int userId, String province, String city, String detail) {
        this.userId = userId;
        this.province = province;
        this.city = city;
        this.detail = detail;
    }
}
