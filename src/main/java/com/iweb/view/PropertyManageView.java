package com.iweb.view;

import com.iweb.pojo.Category;
import com.iweb.pojo.Property;
import com.iweb.util.ManagerController;

import java.text.ParseException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class PropertyManageView {
    public void view() throws ParseException {
        ManagerController mc = new ManagerController();
        System.out.println("请做出您的选择：");
        System.out.println("1.添加属性");
        System.out.println("2.修改属性");
        System.out.println("3.移除属性");
        System.out.println("4.返回");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入您要添加的属性信息：");
                    System.out.println("商品分类：");
                    sc.nextLine();
                    Category category1 = new Category(sc.nextLine());
                    System.out.println("商品属性名");
                    String proName1 = sc.nextLine();
                    mc.addProperty(new Property(category1, proName1));
                    view();
                    break;
                case 2:
                    System.out.println("请输入您要修改的属性信息：");
                    System.out.println("商品分类：");
                    sc.nextLine();
                    Category category2 = new Category(sc.nextLine());
                    System.out.println("商品属性名");
                    String proName2 = sc.nextLine();
                    System.out.println("商品属性id：");
                    int propertyId = sc.nextInt();
                    mc.changeProperty(new Property(propertyId, category2, proName2));
                    view();
                    break;
                case 3:
                    System.out.println("请输入您要删除的属性信息：");
                    System.out.println("属性id：");
                    int proId = sc.nextInt();
                    mc.deleteProperty(proId);
                    view();
                    break;
                case 4:
                    ManagerLoginView managerLoginView = new ManagerLoginView();
                    managerLoginView.view();
                    break;
                default:
                    System.out.println("输入有误请重新输入！");
                    view();
            }
        }catch (InputMismatchException e) {
            System.out.println("输入不匹配预期类型，请输入一个整数。");
        }
    }
}
