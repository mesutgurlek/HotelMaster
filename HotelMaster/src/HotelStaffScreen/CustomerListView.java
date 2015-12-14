package HotelStaffScreen;

import HotelEntities.Customer;
import HotelEntities.Hotel;
import HotelEntities.Room;
import HotelEntities.RoomType;
import HotelManagement.CustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Callback;

import java.sql.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Heaven on 12/5/2015.
 */
public class CustomerListView extends Pane implements Observer{
    private ObservableList<Customer> data;
    private Line separator1;
    private Button backButton, processButton;
    private Hotel hotel;
    private TableView table;
    private ImageView miniLogo;

    public CustomerListView(Hotel hotel){
        this.hotel = hotel;
        hotel.subscribe(this);

        miniLogo = new ImageView(getClass().getResource("icons/customer_listmenu_icon.png").toExternalForm());
        miniLogo.setLayoutX(0);
        miniLogo.setLayoutY(0);

        hotel.updateHotelCustomers();
        data = FXCollections.observableArrayList(hotel.getCustomers());

        backButton = new Button("Back");
        backButton.setLayoutX(700);
        backButton.setLayoutY(25);
        backButton.setMinWidth(50);

        processButton = new Button("Process Changes");
        processButton.setLayoutX(800);
        processButton.setLayoutY(25);

        separator1 = new Line(0,80, 950, 82);

        TableColumn name = new TableColumn("Name");
        name.setMinWidth(150);
        name.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("name"));

        TableColumn roomNo = new TableColumn("Room No");
        roomNo.setMinWidth(100);
        roomNo.setCellValueFactory(
                new PropertyValueFactory<Customer, Integer>("roomNo"));

        TableColumn payment = new TableColumn("Payment");
        payment.setMinWidth(100);
        payment.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("payment"));

        TableColumn arrivalDate = new TableColumn("Arrival Date");
        arrivalDate.setMinWidth(100);
        arrivalDate.setCellValueFactory(
                new PropertyValueFactory<Customer, Date>("arrivalDate"));

        TableColumn departureDate = new TableColumn("Departure Date");
        departureDate.setMinWidth(100);
        departureDate.setCellValueFactory(
                new PropertyValueFactory<Customer, Date>("departureDate"));

        TableColumn totalCost = new TableColumn("Total Cost");
        totalCost.setMinWidth(100);
        totalCost.setCellValueFactory(
                new PropertyValueFactory<Customer, Double>("totalCost"));

        TableColumn phoneNo = new TableColumn("Phone No");
        phoneNo.setMinWidth(150);
        phoneNo.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("phoneNo"));


        //"Checkbox" column
        TableColumn delCol = new TableColumn<Customer, Boolean>();
        delCol.setText("Delete");
        delCol.setMinWidth(100);
        delCol.setCellValueFactory(new PropertyValueFactory("checkbox"));
        delCol.setCellFactory(new Callback<TableColumn<Customer, Boolean>, TableCell<Customer, Boolean>>() {
            public TableCell<Customer, Boolean> call(TableColumn<Customer, Boolean> p) {
                return new CheckBoxTableCell<Customer, Boolean>();
            }
        });
        table = new TableView();
        table.setItems(data);
        table.setLayoutX(0);
        table.setLayoutY(83);
        table.setEditable(true);
        table.getColumns().addAll(name, roomNo, arrivalDate, departureDate,phoneNo, totalCost, payment, delCol);

        getChildren().addAll(backButton, processButton, separator1, table, miniLogo);
    }


    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Button getProcessButton() {
        return processButton;
    }

    public void setProcessButton(Button processButton) {
        this.processButton = processButton;
    }

    public ObservableList<Customer> getData() {
        return data;
    }

    public void setData(ObservableList<Customer> data) {
        this.data = data;
    }

    @Override
    public void update(Observable o, Object arg) {
        hotel.updateHotelRooms();
        hotel.updateHotelCustomers();
        hotel.updateHotelReservations();
        data = FXCollections.observableArrayList(hotel.getCustomers());
        getChildren().removeAll(backButton, processButton, separator1, table, miniLogo);
        table.setItems(data);
        getChildren().addAll(backButton, processButton, separator1, table, miniLogo);
    }
}
