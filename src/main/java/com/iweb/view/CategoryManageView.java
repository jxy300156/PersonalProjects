package com.iweb.view;

import com.iweb.pojo.Category;
import com.iweb.util.ManagerController;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class CategoryManageView {
    public void view() throws ParseException {
        ManagerController mc = new ManagerController();
        System.out.println("请做出您的选择：");
        System.out.println("1.添加分类");
        System.out.println("2.修改分类");
        System.out.println("3.移除分类");
        System.out.println("4.返回");
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入您要添加的分类信息：");
                    System.out.println("分类名称：");
                    sc.nextLine();
                    String cname1 = sc.nextLine();
                    mc.addCategory(new Category(cname1));
                    view();
                    break;
                case 2:
                    System.out.println("请输入您要修改的分类信息：");
                    System.out.println("分类名称：");
                    sc.nextLine();
                    String cname2 = sc.nextLine();
                    System.out.println("分类id:");
                    int cid1 = sc.nextInt();
                    mc.changeCategory(new Category(cid1, cname2));
                    view();
                    break;
                case 3:
                    System.out.println("请输入您要删除的分类信息：");
                    System.out.println("分类id：");
                    int cid2 = sc.nextInt();
                    mc.deleteCategory(cid2);
                    view();
                    break;
                case 4:
                    ManagerLoginView managerLoginView = new ManagerLoginView();
                    managerLoginView.view();
                    break;
                default:
                    System.out.println("输入有误请重新输入！");
            }
        }catch (InputMismatchException e) {
            System.out.println("输入不匹配预期类型，请输入一个整数。");
        }
    }
}
