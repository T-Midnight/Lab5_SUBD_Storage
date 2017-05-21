package Entity;

import java.sql.SQLException;

public class Provider {
    private int idProvider;
    private String nameOfCompany;
    private String adress;

    public String[] getString() throws SQLException {
	return new String[] { getIdProvider() + "", getNameOfCompany(),
                     getAdress() };
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

    /**
     * @return the nameOfCompany
     */
    public String getNameOfCompany() {
        return nameOfCompany;
    }

    /**
     * @param nameOfCompany the nameOfCompany to set
     */
    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
}
