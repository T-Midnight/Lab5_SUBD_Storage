package Entity;


public class Storage {
    private int id_storage;
    private String adress;

    public Storage() {}

    public Storage(int id_storage, String adress) {
            this.id_storage = id_storage;
            this.adress = adress;
    }

    public int getId_storage() {
            return id_storage;
    }

    public void setId_storage(int id_storage) {
            this.id_storage = id_storage;
    }

    public String getAdress() {
            return adress;
    }

    public void setAdress(String adress) {
            this.adress = adress;
    }

    public String[] getString() {
            return new String[] { getId_storage() + "", getAdress()};
    }

    @Override
    public String toString() {
        return getAdress();
    }
}
