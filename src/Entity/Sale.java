package Entity;

import java.sql.SQLException;

public class Sale {
    private int idSale;
    private int count;
    private int idProduct;
    private int idCustomer;

    public String[] getString() throws SQLException {
	return new String[] { getIdSale() + "", getCount() + "",
                     getIdProduct() + "", getIdCustomer() + ""};
    }
    
    /**
     * @return the idSale
     */
    public int getIdSale() {
        return idSale;
    }

    /**
     * @param idSale the idSale to set
     */
    public void setIdSale(int idSale) {
        this.idSale = idSale;
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
     * @return the idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the idCustomer
     */
    public int getIdCustomer() {
        return idCustomer;
    }

    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    
}
