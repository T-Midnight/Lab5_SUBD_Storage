package Entity;

import Controllers.StorageController;
import java.sql.SQLException;

public class Product {
    private int id_product;
    private String name;
    private int cost;
    private int count;
    private int id_storage;
    StorageController storageController;
    
    public Product() {}

    public String[] getString() throws SQLException {
	return new String[] { getId_product() + "", getName(),
                    + getCost() + "", + getCount() + "", + getId_storage() + ""};
    }
    /**
     * @return the id_product
     */
    public int getId_product() {
        return id_product;
    }

    /**
     * @param id_product the id_product to set
     */
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the id_storage
     */
    public int getId_storage() {
        return id_storage;
    }

    /**
     * @param id_storage the id_storage to set
     */
    public void setId_storage(int id_storage) {
        this.id_storage = id_storage;
    } 
}
