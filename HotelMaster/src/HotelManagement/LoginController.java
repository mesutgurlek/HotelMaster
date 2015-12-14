package HotelManagement;

import DatabaseManagement.HotelStorageFacade;
import HotelEntities.Hotel;
import HotelEntities.HotelStaff;
import HotelStaffScreen.LoginView;
import HotelStaffScreen.Main;
import HotelStaffScreen.MenuView;

import java.util.Hashtable;

/**
 * Created by Heaven on 11/21/2015.
 */
public class LoginController {
    private HotelStorageFacade storage;
    private HotelStaff staff;
    private LoginView loginView;

    public LoginController(LoginView loginView){
        storage = new HotelStorageFacade();

        this.loginView = loginView;

        loginView.getLoginButton().setOnAction(e ->{
            String username = loginView.getUsernameTextField().getText();
            String password = loginView.getPasswordField().getText();
            if(this.checkAuth(username, password)) {
                System.out.println("Successfull!!!!!!");
                MenuView menuView = new MenuView(Main.hotel);
                MenuController menuController = new MenuController(menuView);
                Main.changeSceneRoot(menuView);
                Main.hotel.unsubscribe(this.loginView);
            }
        });
    }

    public boolean checkAuth(String username, String password){
        staff = new HotelStaff(username, password);
        Hashtable<String, String> accounts = storage.getStaffAccounts();
        if( accounts.containsKey(staff.getUsername()) && accounts.get(staff.getUsername()).equals(staff.getPassword())){
            System.out.println("Authorized = " + username);
            return true;
        }
        else {
            System.out.println("Wrong account information = " + username);
            return true;
        }

    }
}
