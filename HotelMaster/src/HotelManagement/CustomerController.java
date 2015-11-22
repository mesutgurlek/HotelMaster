package HotelManagement;

import DatabaseManagement.HotelStorage;
import HotelEntities.Customer;

import java.util.ArrayList;

/**
 * Created by Heaven on 11/21/2015.
 */
public class CustomerController {
    HotelStorage storage;

    public CustomerController() {
        storage = new HotelStorage();
    }

    public ArrayList<Customer> getAllCustomers(){
        return storage.getCustomers();
    }

    public void addCustomer(Customer customer){
        storage.addCustomer(customer.getName(), customer.getPhoneNo(), customer.getPayment(), customer.getRoomNo(),
                customer.getArrivalDate(), customer.getDepartureDate(), customer.getTotalCost());
    }

    public void deleteCustomer(int roomNo){
        storage.deleteCustomer(roomNo);
    }
}
