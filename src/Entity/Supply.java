package Entity;

import java.sql.Date;
import java.sql.SQLException;

public class Supply {
    private int idSupply;
    private int count;
    private Date supplyDate;
    private int idProvider;

     public String[] getString() throws SQLException {
	return new String[] { getIdSupply() + "", getCount() + "", 
                            getSupplyDate() + "", getIdProvider() + ""};
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
     * @return the supplyDate
     */
    public Date getSupplyDate() {
        return supplyDate;
    }

    /**
     * @param supplyDate the supplyDate to set
     */
    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    /**
     * @return the idProvider
     */
    public int getIdProvider() {
        return idProvider;
    }

    /**
     * @param idProvider the idProvider to set
     */
    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }
}
