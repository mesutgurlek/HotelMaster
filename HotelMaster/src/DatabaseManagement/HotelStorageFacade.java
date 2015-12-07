package DatabaseManagement;
import HotelEntities.*;

import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Heaven on 11/6/2015.
 */
public class HotelStorageFacade {
    public void addRoom(int roomNo, String roomType, String roomStat, int floorNo, int adultCount, int childCount, double dailyPrice, String extraInfo){
        RoomStorage roomStorage = new RoomStorage();
        roomStorage.insertRoom(roomNo, roomType, roomStat, floorNo, adultCount, childCount, dailyPrice, extraInfo);
    }

    public void deleteRoom(int roomNo){
        RoomStorage roomStorage = new RoomStorage();
        roomStorage.deleteRoom(roomNo);
    }

    public ArrayList<Room> getRooms(){
        RoomStorage roomStorage = new RoomStorage();
       return roomStorage.getRooms();
    }

    public void addAccount(String name, String password){
        LoginStorage loginStorage = new LoginStorage();
        loginStorage.insertAccount(name, password);
    }

    public ArrayList<Reservation> getReservations(){
        ReservationStorage reservationStorage = new ReservationStorage();
        return reservationStorage.getReservations();
    }

    public void addReservation(String name, String phoneNo, int roomNo, Date arrivalDate, Date departureDate, double totalCost){
        ReservationStorage reservationStorage = new ReservationStorage();
        reservationStorage.insertReservation(name, phoneNo, roomNo, arrivalDate, departureDate, totalCost);
    }

    public void deleteReservation(int roomNo){
        ReservationStorage reservationStorage = new ReservationStorage();
        reservationStorage.deleteReservation(roomNo);
    }

    public ArrayList<Customer> getCustomers(){
        CustomerStorage customerStorage = new CustomerStorage();
        return customerStorage.getCustomers();
    }

    public void addCustomer(String name, String phoneNo, String purchaseType, int roomNo, Date arrivalDate, Date departureDate, double totalCost) {
        CustomerStorage customerStorage = new CustomerStorage();
        customerStorage.insertCustomer(name, phoneNo, purchaseType, roomNo, arrivalDate, departureDate, totalCost);
    }

    public void deleteCustomer(int roomNo){
        CustomerStorage customerStorage = new CustomerStorage();
        customerStorage.deleteCustomer(roomNo);
    }

    public Hashtable<String, String> getStaffAccounts(){
        LoginStorage storage = new LoginStorage();
        return storage.getAccounts();
    }

    public void updateRoom(int roomNo, String status){
        RoomStorage storage = new RoomStorage();
        storage.updateRoom(roomNo, status);
    }

}
