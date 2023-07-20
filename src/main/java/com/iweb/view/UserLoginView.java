package com.iweb.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class UserLoginView {
    public void view() {
        System.out.println("欢迎用户！");
        System.out.println("请做出您的选择：");
        System.out.println("1.用户信息查看");
        System.out.println("2.商品选购");
        System.out.println("3.购物车管理");
        System.out.println("4.购物车结算");
        System.out.println("5.收货地址管理");
        System.out.println("6.充值账户");
        System.out.println("7.联系客服");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("输入有误请重新输入！");
            }
        }catch (InputMismatchException e) {
            System.out.println("输入不匹配预期类型，请输入一个整数。");
        }
    }
}
