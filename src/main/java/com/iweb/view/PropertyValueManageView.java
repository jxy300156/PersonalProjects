package com.iweb.view;

import com.iweb.pojo.Category;
import com.iweb.pojo.Product;
import com.iweb.pojo.Property;
import com.iweb.pojo.PropertyValue;
import com.iweb.util.ManagerController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class PropertyValueManageView {
    public void view() throws ParseException {
        ManagerController mc = new ManagerController();
        System.out.println("请做出您的选择：");
        System.out.println("1.添加属性值");
        System.out.println("2.修改属性值");
        System.out.println("3.移除属性值");
        System.out.println("4.返回");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入您要添加的属性值信息：");
                System.out.println("商品id：");
                Product product1 = mc.getProduct().get(sc.nextInt());
                System.out.println("属性id：");
                Property property1 = mc.getProperty().get(sc.nextInt());
                System.out.println("属性值信息：");
                sc.nextLine();
                String value1 = sc.nextLine();
                mc.addPropertyValue(new PropertyValue(product1,property1,value1));
                view();
                break;
            case 2:
                System.out.println("请输入您要修改的属性值信息：");
                System.out.println("商品属性值id：");
                int propertyValueId = sc.nextInt();
                System.out.println("商品id：");
                Product product2 = mc.getProduct().get(sc.nextInt());
                System.out.println("属性id：");
                Property property2 = mc.getProperty().get(sc.nextInt());
                System.out.println("属性值信息：");
                sc.nextLine();
                String value2 = sc.nextLine();
                mc.changePropertyValue(new PropertyValue(propertyValueId,product2,property2,value2));
                view();
                break;
            case 3:
                System.out.println("请输入您要删除的属性值信息：");
                System.out.println("属性值id：");
                int pvId = sc.nextInt();
                mc.deletePropertyValue(pvId);
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
    }
}
