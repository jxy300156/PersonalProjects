package com.iweb.view;

import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class ManagerLoginView {
    public void view() {
        System.out.println("欢迎管理员！");
        System.out.println("请做出您的选择：");
        System.out.println("1.商品管理");
        System.out.println("2.分类管理");
        System.out.println("3.商品属性管理");
        System.out.println("4.商品属性值管理");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                ManagerLoginView managerLoginView = new ManagerLoginView();
                managerLoginView.view();
                break;
            case 2:
                CategoryManageView categoryManageView = new CategoryManageView();
                categoryManageView.view();
                break;
            case 3:
                PropertyManageView propertyManageView = new PropertyManageView();
                propertyManageView.view();
                break;
            case 4:
                PropertyValueManageView propertyValueManageView = new PropertyValueManageView();
                propertyValueManageView.view();
                break;
            default:
                System.out.println("输入有误请重新输入！");
        }
    }
}
