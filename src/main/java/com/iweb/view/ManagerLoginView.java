package com.iweb.view;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class ManagerLoginView {
    public void view() throws ParseException {
        System.out.println("欢迎管理员！");
        System.out.println("请做出您的选择：");
        System.out.println("1.商品管理");
        System.out.println("2.分类管理");
        System.out.println("3.商品属性管理");
        System.out.println("4.商品属性值管理");
        System.out.println("5.订单管理");
        System.out.println("6.退出");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    CommodityManageView commodityManageView = new CommodityManageView();
                    commodityManageView.view();
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
                case 5:
                    OrderManageView orderManageView = new OrderManageView();
                    orderManageView.view();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("输入有误请重新输入！");
            }
        }catch (InputMismatchException e) {
            System.out.println("输入不匹配预期类型，请输入一个整数。");
        }
    }
}
