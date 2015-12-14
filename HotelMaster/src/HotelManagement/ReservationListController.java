package HotelManagement;

import HotelEntities.Customer;
import HotelEntities.Reservation;
import HotelEntities.Room;
import HotelStaffScreen.CheckInView;
import HotelStaffScreen.Main;
import HotelStaffScreen.MenuView;
import HotelStaffScreen.ReservationsListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Toggle;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Heaven on 12/8/2015.
 */
public class ReservationListController {
    private ReservationsListView reservationsListView;
    private RoomController roomController;
    private CustomerController customerController;
    private ReservationController reservationController;
    private String paymentMethod;

    public ReservationListController(ReservationsListView reservationsListView){
        this.reservationsListView = reservationsListView;
        this.roomController = new RoomController();
        this.customerController = new CustomerController();
        this.reservationController = new ReservationController();
        this.paymentMethod = "";

        this.reservationsListView.getGroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(reservationsListView.getGroup().getSelectedToggle() != null){
                    paymentMethod = reservationsListView.getGroup().getSelectedToggle().getUserData().toString();
                }
            }
        });

        this.reservationsListView.getBackButton().setOnAction(e -> {
            Main.hotel.unsubscribe(this.reservationsListView);
            MenuView menuView = new MenuView(Main.hotel);
            MenuController menuController = new MenuController(menuView);
            Main.changeSceneRoot(menuView);
        });

        this.reservationsListView.getDeleteButton().setOnAction(e->{
            ObservableList<Reservation> reservations = reservationsListView.getData();
            ArrayList<Reservation> selectedReservations = new ArrayList<Reservation>();
            for(Reservation r : reservations){
                if(r.getCheckbox()){
                    selectedReservations.add(r);
                }
            }

            for(Reservation r : selectedReservations){
                reservationController.deleteReservation(r.getReservedRoomNo());
                roomController.updateRoom(r.getReservedRoomNo(), "empty");
            }

            for(Observer o : Main.hotel.getObservers()){
                System.out.println("observer" + o.toString());
            }
            Main.hotel.notifyObservers();
        });

        this.reservationsListView.getProcessButton().setOnAction(e->{

            ObservableList<Reservation> reservations = reservationsListView.getData();
            Reservation selectedReservation = null;
            for(Reservation r : reservations){
                if(r.getCheckbox()){
                    selectedReservation = r;
                }
            }

            String name = selectedReservation.getPersonName();
            int roomNo = selectedReservation.getReservedRoomNo();
            String phoneNo = selectedReservation.getPhoneNo();
            Date arrivalDate = selectedReservation.getArrivalDate(), departureDate = selectedReservation.getDepartureDate();
            Double totalCost = selectedReservation.getTotalCost();

            Customer customer = new Customer(name, roomNo, paymentMethod, arrivalDate, departureDate, totalCost, phoneNo);
            customerController.addCustomer(customer);
            reservationController.deleteReservation(roomNo);

            roomController.updateRoom(roomNo, "full");

            Main.hotel.notifyObservers();
        });
    }
}
