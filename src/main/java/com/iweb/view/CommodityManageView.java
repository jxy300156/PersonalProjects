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
        System.out.println("4.返回");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入您要添加的商品信息：");
                System.out.println("商品名称：");
                sc.nextLine();
                String pName1 = sc.nextLine();
                System.out.println("商品原价：");
                double originalPrice1 = sc.nextDouble();
                System.out.println("商品分类：");
                sc.nextLine();
                Category category1 = new Category(sc.nextLine());
                System.out.println("商品库存：");
                int stock1 = sc.nextInt();
                System.out.println("商品日期：");
                sc.nextLine();
                String dateValue1 = sc.nextLine();
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = dateFormat1.parse(dateValue1);
                System.out.println("商品优惠：");
                double promotePrice1 = sc.nextDouble();
                System.out.println("商品评价：");
                sc.nextLine();
                String subTitle1 = sc.nextLine();
                Product product1 = new Product(pName1,originalPrice1,category1,stock1,date1,promotePrice1,subTitle1);
                mc.addProduct(product1);
                view();
                break;
            case 2:
                System.out.println("请输入您要修改的商品信息：");
                System.out.println("商品id：");
                int productId = sc.nextInt();
                System.out.println("商品名称：");
                sc.nextLine();
                String pName2 = sc.nextLine();
                System.out.println("商品原价：");
                double originalPrice2 = sc.nextDouble();
                System.out.println("商品分类：");
                sc.nextLine();
                Category category2 = new Category(sc.nextLine());
                System.out.println("商品库存：");
                int stock2 = sc.nextInt();
                System.out.println("商品日期：");
                sc.nextLine();
                String dateValue2 = sc.nextLine();
                DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                Date date2 = dateFormat2.parse(dateValue2);
                System.out.println("商品优惠：");
                double promotePrice2 = sc.nextDouble();
                System.out.println("商品评价：");
                sc.nextLine();
                String subTitle2 = sc.nextLine();
                Product product2 = new Product(productId,pName2,originalPrice2,category2,stock2,date2,promotePrice2,subTitle2);
                mc.changeProduct(product2);
                view();
                break;
            case 3:
                System.out.println("请输入您要删除的商品信息：");
                System.out.println("商品id：");
                int pid = sc.nextInt();
                mc.deleteProduct(pid);
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
