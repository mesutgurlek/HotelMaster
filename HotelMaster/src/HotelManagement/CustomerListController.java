package HotelManagement;

import HotelEntities.Customer;
import HotelEntities.Hotel;
import HotelStaffScreen.CustomerListView;
import HotelStaffScreen.Main;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by Heaven on 12/5/2015.
 */
public class CustomerListController {
    private CustomerListView customerListView;

    public CustomerListController(CustomerListView customerListView){
        this.customerListView = customerListView;

        customerListView.getBackButton().setOnAction(e -> {
            Hotel hotel = new Hotel();
            Main.changeSceneRoot(hotel.getMenuView());
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

            Hotel hotel = new Hotel();
            Main.changeSceneRoot(hotel.getCustomerListView());
        });
    }

}
