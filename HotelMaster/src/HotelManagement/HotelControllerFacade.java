package HotelManagement;

import HotelEntities.*;
import HotelStaffScreen.CheckInView;
import HotelStaffScreen.LoginView;
import HotelStaffScreen.MenuView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Heaven on 11/21/2015.
 */
public class HotelControllerFacade {
    public Hotel myHotel;
    private LoginView loginView;
    private MenuView menuView;
    private CheckInView checkInView;
    private LoginController loginController;
    private MenuController menuController;
    private CheckInController checkInController;
    private RoomController roomController = new RoomController();
    private CustomerController customerController = new CustomerController();
    private ReservationController reservationController = new ReservationController();

    public HotelControllerFacade(Hotel hotel){
        this.myHotel = hotel;
        this.loginView = myHotel.getLoginView();
        this.menuView = myHotel.getMenuView();
        this.checkInView = myHotel.getCheckInView();

        checkInController = new CheckInController(checkInView);
        menuController = new MenuController(menuView);
        loginController = new LoginController(loginView);
        roomController = new RoomController();
        customerController = new CustomerController();
        reservationController = new ReservationController();
    }

    public static void main(String[] args) throws ParseException {
      //  loginController.checkAuth("mesut", "123");
     //   loginController.checkAuth("veli", "123");
      //  loginController.checkAuth("ali", "345");

        Room room = new Room(101, 4, RoomType.king, RoomStatus.reserved, 1002, 4, 2, "");
        //roomController.addRoom(room);
        // roomController.deleteRoom(room.getRoomNo());

        //Customer add example
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "22-01-2015";
        String dateInString2 = "14-02-2015";
        java.util.Date date;
        date = sdf.parse(dateInString);
        Date date1 = new Date(date.getTime());
        date = sdf.parse(dateInString2);
        Date date2 = new Date(date.getTime());
        Reservation reservation = new Reservation("Jonny", 435, date2, date1, "31231564899", 5000);
        //reservationController.addReservation(reservation);
        //reservationController.deleteReservation(103);
       // Customer customer = new Customer("Jason", "pitt", 502, "cash", date1, date2, 4026, "236547895123");
        //customerController.addCustomer(customer);
        //customerController.deleteCustomer(502);
    }

    public Hotel getMyHotel() {
        return myHotel;
    }

    public void setMyHotel(Hotel myHotel) {
        this.myHotel = myHotel;
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
        myHotel.updateHotelRooms();
    }

    public void deleteRoomFromHotel(int roomNo){
        roomController.deleteRoom(roomNo);
        myHotel.updateHotelRooms();
    }

    public void addCustomerToHotel(Customer customer){
        customerController.addCustomer(customer);
        myHotel.updateHotelCustomers();
    }

    public void deleteCustomerFromHotel(int roomNo){
        customerController.deleteCustomer(roomNo);
        myHotel.updateHotelCustomers();
    }

    public void addReservationToHotel(Reservation reservation){
        reservationController.addReservation(reservation);
        myHotel.updateHotelReservations();
    }

    public void deleteReservationFromHotel(int roomNo){
        reservationController.deleteReservation(roomNo);
        myHotel.updateHotelReservations();
    }


}
