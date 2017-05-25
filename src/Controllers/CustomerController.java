/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.Customer;
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
public class CustomerController extends AbstractController<Customer>{

    private Connection connection;
    private Statement statement;
    public CustomerController(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void add(Customer entity) throws SQLException {
        statement = connection.createStatement();
        String query = "insert into customer values" 
            + "(nextval('seq_id_customer'),'" + entity.getName() + "'," 
            + "'" + entity.getSurname() + "'," + "'"+ entity.getAdress() +"');";
        System.out.println(query);
        statement.execute(query);
    }

    @Override
    public void delete(Customer entity) throws SQLException {
        statement = connection.createStatement();
        String query = "delete from customer where id_customer = " + entity.getIdCustomer();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void update(Customer entity) throws SQLException {
        statement = connection.createStatement();
        String query = "update customer set name = '" + entity.getName()
        + "'," + "surname = '" + entity.getSurname() + "',"
        + "adress = '" + entity.getAdress() + "'"
        + " where id_customer = " + entity.getIdCustomer();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    private ResultSet getTable() throws SQLException{ 
        statement = connection.createStatement(); 
        return statement.executeQuery("select * from customer"); 
    }
    
    @Override
    public List<Customer> selectAll() throws SQLException {
         statement = connection.createStatement();
        List<Customer> customer_list = null;
        customer_list = new ArrayList<>();
        
        ResultSet rs = getTable();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setIdCustomer(rs.getInt("id_customer"));
            customer.setName(rs.getString("name"));
            customer.setSurname(rs.getString("surname"));
            customer.setAdress(rs.getString("adress"));
            customer_list.add(customer);
        }
        return customer_list;
    }
    
    //метод возвращающий список id-шников этого класса. Для внешних ключей, при заполнении comboBox
    public Object[] getIds () throws SQLException {
        List<Customer> customer_list = selectAll();
        Object[] result = new Object[customer_list.size()];
        for(int i = 0; i < customer_list.size(); i++) {
            result[i] = customer_list.get(i).getIdCustomer();
        }
        return result;
    }
}
