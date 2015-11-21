package HotelEntities;

import java.util.ArrayList;

/**
 * Created by Heaven on 11/21/2015.
 */
public class Hotel {
    private String name;
    private int numberOfRoom;
    private int numberOfCustomer;


    public ArrayList<Room> getRooms(){
        return null;
    }

    public ArrayList<Customer> getCustomers(){
        return null;
    }

    public ArrayList<Reservation> getReservations(){
        return null;
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
