package com.iweb.view;

import com.iweb.pojo.Category;
import com.iweb.util.ManagerController;

import java.util.Scanner;

/**
 * @author jxy
 * @date
 */
public class CategoryManageView {
    public void view(){
        ManagerController mc = new ManagerController();
        System.out.println("请做出您的选择：");
        System.out.println("1.添加分类");
        System.out.println("2.修改分类");
        System.out.println("3.移除分类");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请输入您要添加的分类信息：");
                System.out.println("分类名称：");
                String cname1 = sc.nextLine();
                mc.addCategory(new Category(cname1));
                break;
            case 2:
                System.out.println("请输入您要修改的分类信息：");
                System.out.println("分类名称：");
                String cname2 = sc.nextLine();
                mc.changeCategory(new Category(cname2));
                break;
            case 3:
                System.out.println("请输入您要删除的分类信息：");
                System.out.println("分类id：");
                int cid = sc.nextInt();
                mc.deleteCategory(cid);
                break;
            default:
                System.out.println("输入有误请重新输入！");
        }
    }
}
