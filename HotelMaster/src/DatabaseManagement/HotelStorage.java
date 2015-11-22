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
public class HotelStorage {
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



    public static void main(String[] args) throws ParseException {

       //RoomStorage Example
       //addRoom();
       //deleteRoom(124);
       // getRooms();

        //LoginStorage Example
       // addAccount("ali", "345");
       /* Hashtable<String, String> table = getStaffAccounts();
        if(table.containsKey("mesut")){
            System.out.println("hobaaaaaa");
        }*/

        //ReservationStorage Example
        /*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "22-01-2015";
        String dateInString2 = "14-02-2015";
        java.util.Date date;
        date = sdf.parse(dateInString);
        Date date1 = new Date(date.getTime());
        date = sdf.parse(dateInString2);
        Date date2 = new Date(date.getTime());
        addReservation("mesut", "05362365485", 102, date1, date2, 1020.5);
        addReservation("ali", "125487963256", 103, date1, date2, 1111.7);*/
        //deleteReservation(102);
       // getReservations();

        //CustomerStorage Example
        /*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "22-01-2015";
        String dateInString2 = "14-02-2015";
        java.util.Date date;
        date = sdf.parse(dateInString);
        Date date1 = new Date(date.getTime());
        date = sdf.parse(dateInString2);
        Date date2 = new Date(date.getTime());
        addCustomer("mesut", "05362365485", "creditCard", 102, date1, date2, 1020.5);
        addCustomer("ali", "125487963256", "cash", 103, date1, date2, 1111.7);*/
        //deleteCustomer(103);
        //getCustomers();

    }


}
