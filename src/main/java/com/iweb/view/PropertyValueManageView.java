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
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入您要添加的属性值信息：");
                Product product1 = mc.getProduct().get(sc.nextInt());
                Property property1 = mc.getProperty().get(sc.nextInt());
                String cname1 = sc.nextLine();
                mc.addPropertyValue(new PropertyValue(product1,property1,cname1));
                break;
            case 2:
                System.out.println("请输入您要修改的属性值信息：");
                Product product2 = mc.getProduct().get(sc.nextInt());
                Property property2 = mc.getProperty().get(sc.nextInt());
                String cname2 = sc.nextLine();
                mc.changePropertyValue(new PropertyValue(product2,property2,cname2));
                break;
            case 3:
                System.out.println("请输入您要删除的属性值信息：");
                int pvId = sc.nextInt();
                mc.deletePropertyValue(pvId);
                break;
            default:
                System.out.println("输入有误请重新输入！");
        }
    }
}
