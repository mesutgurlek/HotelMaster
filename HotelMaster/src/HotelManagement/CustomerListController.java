package HotelManagement;

import HotelEntities.Customer;
import HotelEntities.Hotel;
import HotelStaffScreen.CustomerListView;
import HotelStaffScreen.Main;
import HotelStaffScreen.MenuView;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Heaven on 12/5/2015.
 */
public class CustomerListController {
    private CustomerListView customerListView;

    public CustomerListController(CustomerListView customerListView){
        this.customerListView = customerListView;

        customerListView.getBackButton().setOnAction(e -> {
            MenuView menuView = new MenuView(Main.hotel);
            MenuController menuController = new MenuController(menuView);
            Main.changeSceneRoot(menuView);
            Main.hotel.unsubscribe(this.customerListView);
        });

        customerListView.getProcessButton().setOnAction(e->{
            ObservableList<Customer> customers = customerListView.getData();
            ArrayList<Customer> selectedCustomers = new ArrayList<Customer>();
            for(Customer c : customers){
                if(c.getCheckbox()){
                    selectedCustomers.add(c);
                }
            }

            CustomerController customerController = new CustomerController();
            RoomController roomController = new RoomController();
            for(Customer c : selectedCustomers){
                customerController.deleteCustomer(c.getRoomNo());
                roomController.updateRoom(c.getRoomNo(), "empty");
            }

            for(Observer o : Main.hotel.getObservers()){
                System.out.println("observer" + o.toString());
            }
            Main.hotel.notifyObservers();
        });
    }

}
