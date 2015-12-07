package HotelManagement;

import HotelEntities.*;
import HotelStaffScreen.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Heaven on 11/21/2015.
 */
public class HotelControllerFacade {

    private LoginController loginController;

    private RoomController roomController;
    private CustomerController customerController;
    private ReservationController reservationController;

    public HotelControllerFacade(){

        roomController = new RoomController();
        customerController = new CustomerController();
        reservationController = new ReservationController();
    }

    public ArrayList<Reservation> getAllReservations(){
        return reservationController.getReservations();
    }

    public ArrayList<Room> getAllRooms(){
        return roomController.getAllRooms();
    }

    public ArrayList<Room> getAvailableRooms(){
        return roomController.getAvailableRooms();
    }

    public ArrayList<Customer> getAllCustomers(){
        return customerController.getAllCustomers();
    }

    public void checkAuthorization(String username, String password){
        loginController.checkAuth(username, password);
    }

    public void addRoomToHotel(Room room){
        roomController.addRoom(room);
    }

    public void deleteRoomFromHotel(int roomNo){
        roomController.deleteRoom(roomNo);
    }

    public void addCustomerToHotel(Customer customer){
        customerController.addCustomer(customer);
    }

    public void deleteCustomerFromHotel(int roomNo){
        customerController.deleteCustomer(roomNo);
    }

    public void addReservationToHotel(Reservation reservation){
        reservationController.addReservation(reservation);
    }

    public void deleteReservationFromHotel(int roomNo){
        reservationController.deleteReservation(roomNo);
    }


}
