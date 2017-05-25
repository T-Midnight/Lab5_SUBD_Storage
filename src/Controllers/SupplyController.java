/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.Supply;
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
public class SupplyController extends AbstractController<Supply>{

    Connection connection;
    Statement statement;
    public SupplyController(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void add(Supply entity) throws SQLException {
        statement = connection.createStatement();
        String query1 = "insert into supply values" 
            + "(nextval('seq_id_supply')," + entity.getCount() + ",'"
            +  entity.getSupplyDate() + "'," + entity.getIdProvider() + ");";
        System.out.println(query1);
        statement.execute(query1);
    }

    @Override
    public void delete(Supply entity) throws SQLException {
        statement = connection.createStatement();
        String query = "delete from supply where id_supply = " 
                    + entity.getIdSupply();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void update(Supply entity) throws SQLException {
        statement = connection.createStatement();
        String query = "update supply set count = " 
                    + entity.getCount() + "," + "supply_date = '" 
                    + entity.getSupplyDate() + "',"
                    + "id_provider = " + entity.getIdProvider()
                    + " where id_supply = " + entity.getIdSupply();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public List<Supply> selectAll() throws SQLException {
        statement = connection.createStatement();
        List<Supply> supply_list = null;
        supply_list = new ArrayList<>();
        
        ResultSet rs = getTable();
        while (rs.next()) {
            Supply supply = new Supply();
            supply.setIdProvider(rs.getInt("id_provider"));
            supply.setIdSupply(rs.getInt("id_supply"));
            supply.setSupplyDate(rs.getDate("supply_date"));
            supply.setCount(rs.getInt("count"));
            supply_list.add(supply);
        }
        return supply_list;
    }
    
    private ResultSet getTable() throws SQLException { 
        statement = connection.createStatement(); 
        return statement.executeQuery("select * from supply"); 
    }
     
    public Object[] getIds() throws SQLException {
        List<Supply> supply_list = selectAll();
        Object[] result = new Object[supply_list.size()];
        for(int i = 0; i < supply_list.size(); i++) {
            result[i] = supply_list.get(i).getIdSupply();
        }
        return result;
    }
    
    //для вставки индекса только что добавленной поставки в таблицу, реализующую связь многие ко многим
    public int getLastIdSupply() throws SQLException {
        Object[] ids = getIds();
        int max = ids.length;
        return max;
    }
}
