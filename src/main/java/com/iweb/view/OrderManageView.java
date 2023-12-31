package com.iweb.view;

import com.iweb.pojo.Order;
import com.iweb.util.ManagerController;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class OrderManageView {
    public void view() throws ParseException {
        ManagerController mc = new ManagerController();
        System.out.println("请做出您的选择：");
        System.out.println("1.订单查看");
        System.out.println("2.订单发货");
        System.out.println("3.返回");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    List<Order> orders = mc.getOrders();
                    for (Order o : orders) {
                        System.out.println(o.getOid() + "--" + o.getUserId() + "--" + o.getAddressId() + "--" + o.getODate() + "--" + o.getOrderStatus());
                    }
                    view();
                    break;
                case 2:
                    System.out.println("请输入你所需要发货的订单编号和用户id以及地址编号");
                    System.out.println("订单编号:");
                    int oid = sc.nextInt();
                    System.out.println("用户id:");
                    int uid = sc.nextInt();
                    System.out.println("地址编号:");
                    int addId = sc.nextInt();
                    mc.settleOrder(oid, uid, addId);
                    view();
                    break;
                case 3:
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
