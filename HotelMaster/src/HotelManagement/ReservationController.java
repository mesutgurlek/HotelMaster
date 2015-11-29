package HotelManagement;

import DatabaseManagement.HotelStorageFacade;
import HotelEntities.Reservation;

import java.util.ArrayList;

/**
 * Created by Heaven on 11/21/2015.
 */
public class ReservationController {
    HotelStorageFacade storage;

    public ReservationController(){
        storage = new HotelStorageFacade();
    }

    public ArrayList<Reservation> getReservations(){
        return storage.getReservations();
    }

    public void addReservation(Reservation reservation){
        storage.addReservation(reservation.getPersonName(), reservation.getPhoneNo(), reservation.getReservedRoomNo(), reservation.getArrivalDate(), reservation.getDepartureDate(),reservation.getTotalCost());
    }

    public void deleteReservation(int roomNo){
        storage.deleteReservation(roomNo);
    }

}
