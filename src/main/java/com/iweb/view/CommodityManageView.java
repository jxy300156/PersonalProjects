package com.iweb.view;

import com.iweb.pojo.Category;
import com.iweb.pojo.Product;
import com.iweb.util.ManagerController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class CommodityManageView {
    public void view() throws ParseException {
        ManagerController mc = new ManagerController();
        System.out.println("请做出您的选择：");
        System.out.println("1.添加商品");
        System.out.println("2.修改商品");
        System.out.println("3.移除商品");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入您要添加的商品信息：");
                String pName1 = sc.nextLine();
                double originalPrice1 = sc.nextDouble();
                Category category1 = new Category(sc.nextLine());
                int stock1 = sc.nextInt();
                String dateValue1 =sc.nextLine();
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                Date date1 = dateFormat1.parse(dateValue1);
                double promotePrice1 = sc.nextDouble();
                String subTitle1 = sc.nextLine();
                Product product1 = new Product(pName1,originalPrice1,category1,stock1,date1,promotePrice1,subTitle1);
                mc.addProduct(product1);
                break;
            case 2:
                System.out.println("请输入您要修改的商品信息：");
                String pName2 = sc.nextLine();
                double originalPrice2 = sc.nextDouble();
                Category category2 = new Category(sc.nextLine());
                int stock2= sc.nextInt();
                String dateValue2 =sc.nextLine();
                DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                Date date2 = dateFormat2.parse(dateValue2);
                double promotePrice2 = sc.nextDouble();
                String subTitle2 = sc.nextLine();
                Product product2 = new Product(pName2,originalPrice2,category2,stock2,date2,promotePrice2,subTitle2);
                mc.changeProduct(product2);
                break;
            case 3:
                System.out.println("请输入您要删除的商品信息：");
                int pid = sc.nextInt();
                mc.deleteProduct(pid);
                break;
            default:
                System.out.println("输入有误请重新输入！");
        }

    }

}
