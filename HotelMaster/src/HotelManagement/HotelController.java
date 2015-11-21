package HotelManagement;

/**
 * Created by Heaven on 11/21/2015.
 */
public class HotelController {
    static LoginController loginController = new LoginController();

    public HotelController(){
        loginController = new LoginController();
    }

    public static void main(String[] args){
        loginController.checkAuth("mesut", "123");
        loginController.checkAuth("veli", "123");
        loginController.checkAuth("ali", "345");
    }
}
