package Entity;

import java.sql.SQLException;

public class SupplyProduct {
    private int idSupply;
    private int idProduct;

     public String[] getString() throws SQLException {
	return new String[] { getIdSupply() + "", getIdProduct() + ""};
    }
    /**
     * @return the idSupply
     */
    public int getIdSupply() {
        return idSupply;
    }

    /**
     * @param idSupply the idSupply to set
     */
    public void setIdSupply(int idSupply) {
        this.idSupply = idSupply;
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
}
