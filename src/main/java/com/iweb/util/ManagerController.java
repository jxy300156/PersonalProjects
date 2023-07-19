package com.iweb.util;

import com.iweb.pojo.*;
import com.iweb.pool.ConnectionPool;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jxy
 * @date
 */
public class ManagerController {
    private static final int CORE_THREADS =20;
    private static final int CONNECTIONS = 20;
    private ConnectionPool connectionPool;
    private ThreadPoolExecutor threadPool;
    public ManagerController(){
        connectionPool = new ConnectionPool(CONNECTIONS);
        threadPool = new ThreadPoolExecutor(CORE_THREADS,25,60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
    }
    public void addCategory(Category c){
        if(c==null||c.getCname()==null||c.getCname().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "insert into category(name) values (?)";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,c.getCname());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void changeCategory(Category c){
        if(c==null||c.getCname()==null||c.getCname().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "update category set name = ? where id = ?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,c.getCname());
            ps.setInt(2,c.getCid());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteCategory(int cid){

        String sql = "delete from category where id = ?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,cid);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addProduct(Product p){
        if(p==null||p.getPName()==null||p.getPName().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "insert into shop.product(name,originalprice,cid,stock,creatDate," +
                "promoteprice,subtitle) values (?,?,?,?,?,?,?)";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,p.getPName());
            ps.setDouble(2,p.getOriginalPrice());
            ps.setInt(3,p.getCategory().getCid());
            ps.setInt(4,p.getStock());
            java.util.Date utilDate = p.getCreateDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(5, sqlDate);
            ps.setDouble(6,p.getPromotePrice());
            ps.setString(7,p.getSubTitle());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void changeProduct(Product p){
        if(p==null||p.getPName()==null||p.getPName().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "update shop.product set name=?,originalprice=?,stock=?," +
                "creatDate=?,promoteprice=?,subtitle=? where id = ? and cid=?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,p.getPName());
            ps.setDouble(2,p.getOriginalPrice());

            ps.setInt(3,p.getStock());
            java.util.Date utilDate = p.getCreateDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(4, sqlDate);
            ps.setDouble(5,p.getPromotePrice());
            ps.setString(6,p.getSubTitle());
            ps.setInt(7,p.getPid());
            ps.setInt(8,p.getCategory().getCid());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteProduct(int pid){
        String sql = "delete from shop.product where id = ?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,pid);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addProperty(Property pro){
        if(pro==null||pro.getProName()==null||pro.getProName().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "insert into shop.property(cid,name) values (?,?)";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,pro.getCategory().getCid());
            ps.setString(2,pro.getProName());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void changeProperty(Property pro){
        if(pro==null||pro.getProName()==null||pro.getProName().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "update shop.property set name=? where id = ? and cid=?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1,pro.getProName());
            ps.setInt(2,pro.getProId());
            ps.setInt(3,pro.getCategory().getCid());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteProperty(int proId){

        String sql = "delete from shop.product where id = ?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,proId);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addPropertyValue(PropertyValue pv){
        if(pv==null||pv.getValue()==null||pv.getValue().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "insert into shop.propertyvalue(pid,ptid,`value`) values (?,?,?)";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,pv.getProduct().getPid());
            ps.setInt(2,pv.getProperty().getProId());
            ps.setString(3,pv.getValue());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void changePropertyValue(PropertyValue pv){
        if(pv==null||pv.getValue()==null||pv.getValue().equals("")){
            System.out.println("参数有误！");
            return;
        }
        String sql = "update shop.propertyvalue set value=? where id = ? and pid=? and ptid=? ";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,pv.getValue());
            ps.setInt(2,pv.getPvId());
            ps.setInt(3,pv.getProduct().getPid());
            ps.setInt(4,pv.getProperty().getProId());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletePropertyValue(int pvId){

        String sql = "delete from propertyvalue where id = ?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,pvId);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Product> getProduct() {
        LinkedList<Product> productList = new LinkedList<>();
        String sql="select * from product";
        try (Connection connection= connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double origibakprice = rs.getDouble("originalprice");
                int cid=rs.getInt("cid");
                List<Category> categories = getCategory();
                Category category = categories.get(cid);
                int stock=rs.getInt("stock");
                Date creatDate=rs.getDate("creatDAte");
                double promoteprice=rs.getDouble("promoteprice");
                String subtitle=rs.getString("subtitle");
                Product product = new Product(id,name,origibakprice,category,stock,creatDate,promoteprice,subtitle);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
    public List<Property> getProperty(){
        LinkedList<Property> properties = new LinkedList<>();
        String sql="select * from property";
        try (Connection connection= connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int cid = rs.getInt("cid");
                List<Category> categories = getCategory();
                Category category = categories.get(cid);
                String name = rs.getString("name");
                Property property = new Property(id,category    ,name);
                properties.add(property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
    public List<Category> getCategory() {
        LinkedList<Category> categoryList = new LinkedList<>();
        String sql="select * from category";
        try (Connection connection= connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category(id,name);
                categoryList.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }
    public List<Order> getOrders(){
        LinkedList<Order> orderList = new LinkedList<>();
        String sql="select * from `order`";
        try (Connection c= connectionPool.getConnection();
             PreparedStatement p = c.prepareStatement(sql);
        ){
            ResultSet rs = p.executeQuery();
            while (rs.next()){
                int oid = rs.getInt("order_id");
                int uid = rs.getInt("user_id");
                int addrId = rs.getInt("address_id");
                Date oDate=rs.getDate("order_date");
                String orderStatus=rs.getString("order_status");
                Order order = new Order(oid,uid,addrId,oDate,orderStatus);
                orderList.add(order);
            }
            System.out.println(orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }
    public void settleOrder(int oid,int uid,int addId){
        String sql = "update `order` set order_status=? where order_id = ? and user_id=? and address_id = ?";
        try(
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,"已发货");
            ps.setInt(2,oid);
            ps.setInt(3,uid);
            ps.setInt(4,addId);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
