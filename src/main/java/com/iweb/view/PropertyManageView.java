package com.iweb.view;

import com.iweb.pojo.Category;
import com.iweb.pojo.Property;
import com.iweb.util.ManagerController;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class PropertyManageView {
    public void view(){
        ManagerController mc = new ManagerController();
        System.out.println("请做出您的选择：");
        System.out.println("1.添加属性");
        System.out.println("2.修改属性");
        System.out.println("3.移除属性");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入您要添加的属性信息：");
                System.out.println("商品分类：");
                Category category1 = new Category(sc.nextLine());
                System.out.println("商品属性名");
                String proName1 = sc.nextLine();
                mc.addProperty(new Property(category1,proName1));
                break;
            case 2:
                System.out.println("请输入您要修改的属性信息：");
                System.out.println("商品分类：");
                Category category2 = new Category(sc.nextLine());
                System.out.println("商品属性名");
                String proName2 = sc.nextLine();
                mc.changeProperty(new Property(category2,proName2));
                break;
            case 3:
                System.out.println("请输入您要删除的属性信息：");
                System.out.println("属性id：");
                int proId = sc.nextInt();
                mc.deleteProperty(proId);
                break;
            default:
                System.out.println("输入有误请重新输入！");
        }
    }
}
