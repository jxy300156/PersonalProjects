package com.iweb.view;

import com.iweb.util.LoginAndRegisterController;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class InitialView {
    public void view() throws ParseException {
        LoginAndRegisterController loginAndRegisterController = new LoginAndRegisterController();
        System.out.println("欢迎来到自助商城系统");
        System.out.println("请选择：");
        System.out.println("1.登录");
        System.out.println("2.注册");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    loginAndRegisterController.loginUser();
                    break;
                case 2:
                    loginAndRegisterController.registerUser();
                    break;
                default:
                    System.out.println("输入有误请重新输入！");
                    view();
            }
        }catch (InputMismatchException e){
            System.out.println("输入不匹配预期类型，请输入一个整数。");
        }
    }
}
