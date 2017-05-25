/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.SupplyProduct;
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
public class SupplyProductController extends AbstractController<SupplyProduct>{
    Connection connection;
    Statement statement;
    public SupplyProductController(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(SupplyProduct entity) throws SQLException {
        statement = connection.createStatement();   
        String query2 = "insert into supply_product values (" 
            +  entity.getIdSupply() + "," + entity.getIdProduct() + ");";
        System.out.println(query2);
        statement.execute(query2);
  }

    @Override
    public void delete(SupplyProduct entity) throws SQLException {
        statement = connection.createStatement();
        String query = "delete from supply_product where id_supply = " 
                    + entity.getIdSupply();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void update(SupplyProduct entity) throws SQLException {
        statement = connection.createStatement();
        String query = "update supply_product set id_product = "
                    + entity.getIdProduct() + " where id_supply = " 
                    + entity.getIdSupply();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public List<SupplyProduct> selectAll() throws SQLException {
        statement = connection.createStatement();
        List<SupplyProduct> supplyProduct_list = null;
        
        supplyProduct_list = new ArrayList<>();
        
        ResultSet rs = getTable();
        while (rs.next()) {
            SupplyProduct supplyProduct = new SupplyProduct();
            supplyProduct.setIdSupply(rs.getInt("id_supply"));  
            supplyProduct.setIdProduct(rs.getInt("id_product"));
            supplyProduct_list.add(supplyProduct);
        }
        return supplyProduct_list;
    }
    
    public SupplyProduct selectByIndex(int index)throws SQLException {
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from supply_product "
                 + " where id_supply = " + index ); 
        SupplyProduct supplyProduct = new SupplyProduct();
        while (rs.next()) {
            supplyProduct.setIdSupply(rs.getInt("id_supply"));  
            supplyProduct.setIdProduct(rs.getInt("id_product"));
        }
        return supplyProduct;
    }
    
    private ResultSet getTable() throws SQLException { 
        statement = connection.createStatement(); 
        return statement.executeQuery("select * from supply_product"); 
    }
}
