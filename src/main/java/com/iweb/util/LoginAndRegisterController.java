package com.iweb.util;

import com.iweb.pojo.User;
import com.iweb.pool.ConnectionPool;
import com.iweb.view.ManagerLoginView;
import com.iweb.view.UserLoginView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author jxy
 * @date
 */
public class LoginAndRegisterController {
    private static final int CORE_THREADS =20;
    private static final int CONNECTIONS = 20;
    private ConnectionPool connectionPool;
    private ThreadPoolExecutor threadPool;
    private List<User> loginUsers;
    public LoginAndRegisterController(){
        connectionPool = new ConnectionPool(CONNECTIONS);
        threadPool = new ThreadPoolExecutor(CORE_THREADS,25,60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
    }
    public void loginUser() throws ParseException {
        UserLoginView userLoginView = new UserLoginView();
        ManagerLoginView managerLoginView = new ManagerLoginView();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名:");
        String userName = sc.nextLine();
        System.out.println("请输入您的密码:");
        String password = sc.nextLine();
        System.out.println("请选择您的账户类型:");
        System.out.println("1.user");
        System.out.println("2.admin");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                boolean isUser = checkUserInfo(userName,password,"user");
                if (isUser){
                    System.out.println("登录成功");
                    userLoginView.view();
                }else {
                    System.out.println("登录失败");
                }
                break;
            case 2:
                boolean isManager = checkManagerInfo(userName,password,"admin");
                if(isManager){
                    System.out.println("登录成功");
                    managerLoginView.view();
                }else {
                    System.out.println("登录失败");
                }
                break;
            default:
                System.out.println("输入有误，没有这个用户类型");
        }
    }
    public void registerUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请完善您的注册信息：");
        System.out.println("用户名：");
        String userName = sc.nextLine();
        System.out.println("密码:");
        String password = sc.nextLine();
        System.out.println("用户类型:");
        String authority = sc.nextLine();
        System.out.println("手机号:");
        String phone = sc.nextLine();
        System.out.println("账号金额:");
        double money = sc.nextDouble();
        User RegisterUser = new User(userName,password,authority,phone,money);
        if(checkRegister(RegisterUser)){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }
    private boolean checkUserInfo(String userName,String password,String authority){
        Connection connection = connectionPool.getConnection();
        try{
            if(userName==null||userName.equals("")||password==null||password.equals("")){
                System.out.println("参数有误！");
                return false;
            }
            String sql = "select * from shop.user where username = ? and password = ? and authority = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, authority);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPool.returnConnection(connection);
        }
        return false;
    }
    private boolean checkManagerInfo(String userName,String password,String authoritye){
        Connection connection = connectionPool.getConnection();
        try {
            if (userName == null || userName.equals("") || password == null || password.equals("")) {
                System.out.println("参数有误！");
                return false;
            }
            String sql = "select * from shop.user where username = ? and password = ? and authority = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, authoritye);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPool.returnConnection(connection);
        }
        return false;
    }
    private boolean checkRegister(User u){
        Connection connection = connectionPool.getConnection();
        try{
            if(u==null||u.getUserName()==null||u.getUserName().equals("")||
            u.getPassword()==null||u.getPassword().equals("")||u.getAuthority()==null||
            !(u.getAuthority().equals("user")||u.getAuthority().equals("admin"))||u.getPhone()==null
            ||u.getPhone().equals("")||u.getMoney()==0){
                System.out.println("参数有误！");
                return false;
            }
            String sql = "insert into shop.user(username,password,authority,phone,money) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,u.getUserName());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getAuthority());
            ps.setString(4,u.getPhone());
            ps.setDouble(5,u.getMoney());
            ps.execute();
            ResultSet result = ps.getGeneratedKeys();
            if(result.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPool.returnConnection(connection);
        }
        return false;
    }
}
