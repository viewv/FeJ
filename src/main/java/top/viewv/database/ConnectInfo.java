package top.viewv.database;

import java.io.Serializable;

public class ConnectInfo implements Serializable {
    private String JDBC_DRIVER;
    private String DB_URL;
    private String USER;
    private String PASS;

    public ConnectInfo(String jdbc_driver, String db_url, String user, String pass) {
        JDBC_DRIVER = jdbc_driver;
        DB_URL = db_url;
        USER = user;
        PASS = pass;
    }

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public void setJDBC_DRIVER(String JDBC_DRIVER) {
        this.JDBC_DRIVER = JDBC_DRIVER;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }
}
