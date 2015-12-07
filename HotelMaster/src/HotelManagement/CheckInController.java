package HotelManagement;

import HotelEntities.Customer;
import HotelEntities.Hotel;
import HotelEntities.Room;
import HotelEntities.RoomStatus;
import HotelStaffScreen.CheckInView;
import HotelStaffScreen.Main;
import HotelStaffScreen.MenuView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Toggle;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Observer;

/**
 * Created by Heaven on 12/4/2015.
 */
public class CheckInController {
    private CheckInView checkInView;
    private String paymentMethod;
    private CustomerController customerController;
    private RoomController roomController;

    public CheckInController(CheckInView checkInView){
        this.checkInView = checkInView;
        this.paymentMethod = "";
        this.customerController = new CustomerController();
        this.roomController = new RoomController();

        checkInView.getBackButton().setOnAction(e -> {
            MenuView menuView = new MenuView(Main.hotel);
            MenuController menuController = new MenuController(menuView);
            Main.changeSceneRoot(menuView);
            Main.hotel.unsubscribe(this.checkInView);
        });

        checkInView.getCalculateCostButton().setOnAction(e->{
            //gets daily price
            double dailyPrice = 0;
            ObservableList<Room> rooms = checkInView.getData();
            int roomNo = 0;
            for(Room r : rooms){
                if(r.getCheckbox()){
                    dailyPrice = r.getDailyPrice();
                }
            }
            //Gets arrival date
            LocalDate localDate = checkInView.getArrivalPicker().getValue();
            //Gets Departure date
            LocalDate localDate2 = checkInView.getDeparturePicker().getValue();;
            long days = Period.between(localDate, localDate2).getDays();
            double price = dailyPrice * days;
            checkInView.getTotalCost().setText(Double.toString(price));
        });

        checkInView.getGroup().selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(checkInView.getGroup().getSelectedToggle() != null){
                    paymentMethod = checkInView.getGroup().getSelectedToggle().getUserData().toString();
                    System.out.println(paymentMethod);
                }
            }
        });

        checkInView.getProcessButton().setOnAction(e->{
            String name = checkInView.getNameField().getText() + " " + checkInView.getSurnameField().getText();
            Double totalcost = Double.parseDouble(checkInView.getTotalCost().getText());
            String phoneNo = checkInView.getPhoneField().getText();
            ObservableList<Room> rooms = checkInView.getData();
            int roomNo = 0;
            Room selectedRoom = null;
            for(Room r : rooms){
                if(r.getCheckbox()){
                    roomNo = r.getRoomNo();
                    selectedRoom = r;
                }
            }
            //Gets arrival date
            LocalDate localDate = checkInView.getArrivalPicker().getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date arrivalDate =  new Date(Date.from(instant).getTime());

            //Gets Departure date
            localDate = checkInView.getDeparturePicker().getValue();
            instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date departureDate =  new Date(Date.from(instant).getTime());


            Customer customer = new Customer(name, roomNo, paymentMethod, arrivalDate, departureDate, totalcost, phoneNo);
            customerController.addCustomer(customer);

            roomController.updateRoom(roomNo, "full");

            for(Observer o : Main.hotel.getObservers()){
                System.out.println("observer" + o.toString());
            }
            Main.hotel.notifyObservers();

        });
    }
}
