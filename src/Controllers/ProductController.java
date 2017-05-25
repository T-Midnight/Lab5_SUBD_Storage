/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProductController extends AbstractController<Product>{
    private Connection connection;
    private Statement statement;
    public ProductController(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Product entity) throws SQLException {
        statement = connection.createStatement();
        String query = "insert into product values" 
            + "(nextval('seq_id_product'),'" + entity.getName() + "'," 
            + entity.getCost() +","+ entity.getCount()+","+ entity.getId_storage() + ");";
        System.out.println(query);
        statement.execute(query);
    }

    @Override
    public void delete(Product entity) throws SQLException {
        statement = connection.createStatement();
        String query = "delete from product where id_product = " + entity.getId_product();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void update(Product entity) throws SQLException {
        statement = connection.createStatement();
        String query = "update product set name = '" + entity.getName()
        + "'," + "cost = " + entity.getCost() + ","
        + "count = " + entity.getCount()
        + " where id_product = " + entity.getId_product();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public List<Product> selectAll() throws SQLException {
        statement = connection.createStatement();
        List<Product> product_list = null;
        product_list = new ArrayList<>();
        
        ResultSet rs = getTable();
        while (rs.next()) {
            Product product = new Product();
            product.setId_product(rs.getInt("id_product"));
            product.setName(rs.getString("name"));
            product.setCost(rs.getInt("cost"));
            product.setCount(rs.getInt("count"));
            product.setId_storage(rs.getInt("id_storage"));
            product_list.add(product);
        }
        return product_list;
    }
    
    //метод возвращающий список id-шников этого класса. Для внешних ключей, при заполнении comboBox
    public Object[] getIds () throws SQLException {
        List<Product> product_list = selectAll();
        Object[] result = new Object[product_list.size()];
        for(int i = 0; i < product_list.size(); i++) {
            result[i] = product_list.get(i).getId_product();
        }
        return result;
    }
    
    private ResultSet getTable() throws SQLException{ 
        statement = connection.createStatement(); 
        return statement.executeQuery("select * from product"); 
    }
    
//    public Product getStorageById(int id) throws SQLException {
//        statement = connection.createStatement(); 
//        List<Product> product_list = null;
//        product_list = new ArrayList<>();
//        
//        ResultSet rs = statement.executeQuery("select * from product"
//                + " where id_product = " + id);
//        while (rs.next()) {
//            Product product = new Product();
//            product.setId_product(rs.getInt("id_product"));
//            product.setName(rs.getString("name"));
//            product.setCost(rs.getInt("cost"));
//            product.setCount(rs.getInt("count"));
//            product.setId_storage(rs.getInt("id_storage"));
//            product_list.add(product);
//        }
//        return product_list.get(0);
//    }
}
