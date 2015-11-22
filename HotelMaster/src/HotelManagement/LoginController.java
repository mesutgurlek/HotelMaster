package HotelManagement;

import DatabaseManagement.HotelStorage;
import HotelEntities.HotelStaff;

import java.util.Hashtable;

/**
 * Created by Heaven on 11/21/2015.
 */
public class LoginController {
    private HotelStorage storage;
    private HotelStaff staff;

    public LoginController(){
        storage = new HotelStorage();
    }

    public boolean checkAuth(String username, String password){
        staff = new HotelStaff(username, password);
        Hashtable<String, String> accounts = storage.getStaffAccounts();
        if( accounts.containsKey(username) && accounts.get(username).equals(password)){
            System.out.println("Authorized = " + username);
            return true;
        }
        else {
            System.out.println("Wrong account information = " + username);
        }
        return false;
    }
}
