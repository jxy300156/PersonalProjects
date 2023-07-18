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
public class User {
    private int uid;
    private String userName;
    private String password;
    private String authority;
    private String phone;
    private double money;
    public User(String userName,String password,String authority,String phone,double money){
        this.userName=userName;
        this.password=password;
        this.authority=authority;
        this.phone=phone;
        this.money=money;
    }
}
