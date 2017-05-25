/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.Provider;
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
public class ProviderController extends AbstractController<Provider>{

    Connection connection;
    Statement statement;
    public ProviderController(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(Provider entity) throws SQLException {
        statement = connection.createStatement();
        String query = "insert into provider values" 
                    + "(nextval('seq_id_provider'),'" 
                    + entity.getNameOfCompany()+ "',"
                    + "'" + entity.getAdress() + "');";
        System.out.println(query);
        statement.execute(query);
    }

    @Override
    public void delete(Provider entity) throws SQLException {
        statement = connection.createStatement();
        String query = "delete from provider where id_provider = " 
                    + entity.getIdProvider();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void update(Provider entity) throws SQLException {
        statement = connection.createStatement();
        String query = "update provider set name_of_company = '" 
                    + entity.getNameOfCompany() + "'," + "adress = '" 
                    + entity.getAdress() + "'"
                    + " where id_provider = " + entity.getIdProvider();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public List<Provider> selectAll() throws SQLException {
        statement = connection.createStatement();
        List<Provider> provider_list = null;
        provider_list = new ArrayList<>();
        
        ResultSet rs = getTable();
        while (rs.next()) {
            Provider provider = new Provider();
            provider.setIdProvider(rs.getInt("id_provider"));
            provider.setNameOfCompany(rs.getString("name_of_company"));
            provider.setAdress(rs.getString("adress"));
            provider_list.add(provider);
        }
        return provider_list;
    }
    
    private ResultSet getTable() throws SQLException{ 
        statement = connection.createStatement(); 
        return statement.executeQuery("select * from provider"); 
    }
    
    public Object[] getIds () throws SQLException {
        List<Provider> provider_list = selectAll();
        Object[] result = new Object[provider_list.size()];
        for(int i = 0; i < provider_list.size(); i++) {
            result[i] = provider_list.get(i).getIdProvider();
        }
        return result;
    }
}
