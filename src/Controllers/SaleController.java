/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.Sale;
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
public class SaleController extends AbstractController<Sale>{
    private Connection connection;
    private Statement statement;
    public SaleController(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void add(Sale entity) throws SQLException {
        statement = connection.createStatement();
        String query1 = "insert into sale values" 
            + "(nextval('seq_is_sale')," + entity.getCount()+ ","
            +  entity.getIdProduct() + "," + entity.getIdCustomer() + ");";
        System.out.println(query1);
        statement.execute(query1);
    }

    @Override
    public void delete(Sale entity) throws SQLException {
        statement = connection.createStatement();
        String query = "delete from sale where id_sale = " 
                    + entity.getIdSale();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void update(Sale entity) throws SQLException {
        statement = connection.createStatement();
        String query = "update sale set count = " 
                    + entity.getCount() + "," + "id_product = " 
                    + entity.getIdProduct() + ","
                    + "id_customer = " + entity.getIdCustomer()
                    + " where id_sale = " + entity.getIdSale();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public List<Sale> selectAll() throws SQLException {
        statement = connection.createStatement();
        List<Sale> sale_list = null;
        sale_list = new ArrayList<>();
        
        ResultSet rs = getTable();
        while (rs.next()) {
            Sale sale = new Sale();
            sale.setIdSale(rs.getInt("id_sale"));
            sale.setIdProduct(rs.getInt("id_product"));
            sale.setIdCustomer(rs.getInt("id_customer"));
            sale.setCount(rs.getInt("count"));
            sale_list.add(sale);
        }
        return sale_list;
    }
    
    private ResultSet getTable() throws SQLException { 
        statement = connection.createStatement(); 
        return statement.executeQuery("select * from sale"); 
    }
    
}
