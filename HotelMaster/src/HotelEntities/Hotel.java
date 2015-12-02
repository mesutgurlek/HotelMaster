package HotelEntities;

import HotelManagement.HotelControllerFacade;
import HotelStaffScreen.LoginView;

import java.util.ArrayList;

/**
 * Created by Heaven on 11/21/2015.
 */
public class Hotel {
    private HotelControllerFacade controller;
    private String name;
    private int numberOfRoom;
    private int numberOfCustomer;
    private ArrayList<Room> allRooms;
    private ArrayList<Customer> allCustomers;
    private ArrayList<Reservation> allReservations;
    private ArrayList<Room> availableRooms;
    private LoginView loginView;


    public Hotel(){
        this.loginView = new LoginView();
        controller = new HotelControllerFacade(this);
    }

    public void updateHotelRooms(){
        this.allRooms =  controller.getAllRooms();
        this.availableRooms = controller.getAvailableRooms();
        //Add updateView
    }

    public void updateHotelCustomers(){
        this.allCustomers = controller.getAllCustomers();
        //Add updateView
    }

    public void updateHotelReservations(){
        this.allReservations = controller.getAllReservations();
        //Add updateView
    }
    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public ArrayList<Room> getAvailableRooms(){ return availableRooms; }

    public ArrayList<Room> getRooms(){
        return allRooms;
    }

    public ArrayList<Customer> getCustomers(){
        return allCustomers;
    }

    public ArrayList<Reservation> getReservations(){
        return allReservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public void setNumberOfCustomer(int numberOfCustomer) {
        this.numberOfCustomer = numberOfCustomer;
    }
}
