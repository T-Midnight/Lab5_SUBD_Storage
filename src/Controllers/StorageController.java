package Controllers;

import Entity.Storage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StorageController extends AbstractController<Storage> {
    private Connection connection;
    private Statement statement;
    public StorageController(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Storage entity) throws SQLException {
        statement = connection.createStatement();
        String query = "insert into storage values" 
            + "(nextval('seq_storage'),'" + entity.getAdress() + "');";
        System.out.println(query);
        statement.execute(query);
    }

    @Override
    public void delete(Storage entity) throws SQLException {
        statement = connection.createStatement();
        String query = "delete from storage where id_storage = " + entity.getId_storage();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void update(Storage entity) throws SQLException {
        statement = connection.createStatement();
        String query = "update storage set adress = '" + entity.getAdress()
        + "' " + "where id_storage = " + entity.getId_storage();
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public List<Storage> selectAll() throws SQLException {
        statement = connection.createStatement();
        List<Storage> storage_list = null;
        storage_list = new ArrayList<>();
        
        ResultSet rs = getTable();
        while (rs.next()) {
            Storage storage = new Storage();
            storage.setId_storage(rs.getInt("id_storage"));
            storage.setAdress(rs.getString("adress"));
            storage_list.add(storage);
        }
        return storage_list;
    }
    
    //метод выозвращающий список id-шников этого класса. Для внешних ключей, при заполнении comboBox
    public Object[] getIds () throws SQLException {
        List<Storage> storage_list = selectAll();
        Object[] result = new Object[storage_list.size()];
        for(int i = 0; i < storage_list.size(); i++) {
            result[i] = storage_list.get(i).getId_storage();
        }
        return result;
    }
    
    private ResultSet getTable() throws SQLException{ 
        statement = connection.createStatement(); 
        return statement.executeQuery("select * from storage"); 
    }
    
    public Storage getStorageById(int id) throws SQLException {
        statement = connection.createStatement(); 
        List<Storage> storage_list = null;
        storage_list = new ArrayList<>();
        
        ResultSet rs = statement.executeQuery("select * from storage"
                + " where id_storage = " + id);
        while (rs.next()) {
            Storage storage = new Storage();
            storage.setId_storage(rs.getInt("id_storage"));
            storage.setAdress(rs.getString("adress"));
            storage_list.add(storage);
        }
        return storage_list.get(0);
    }
}
