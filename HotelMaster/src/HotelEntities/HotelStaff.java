package HotelEntities;

/**
 * Created by Heaven on 11/21/2015.
 */
public class HotelStaff {
    private String username;
    private String password;

    public HotelStaff(String username, String pass){
        this.username = username;
        this.password = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
