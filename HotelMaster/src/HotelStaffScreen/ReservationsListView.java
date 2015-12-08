package HotelStaffScreen;

import HotelEntities.Hotel;
import HotelEntities.Reservation;
import HotelEntities.Room;
import HotelEntities.RoomType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Callback;

import java.sql.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Heaven on 12/8/2015.
 */
public class ReservationsListView extends Pane implements Observer{
    private Label paymentMethodText;
    private RadioButton creditCardButton;
    private RadioButton cashButton;
    private ToggleGroup group;
    private ImageView creditCardView;
    private ImageView cashView;
    private ObservableList<Reservation> data;
    private Line separator1;
    private Button backButton, processButton, deleteButton;
    private TableView table;
    private Hotel hotel;


    public ReservationsListView(Hotel hotel){
        this.hotel = hotel;
        hotel.subscribe(this);

        hotel.updateHotelReservations();
        data = FXCollections.observableArrayList(hotel.getReservations());

        group = new ToggleGroup();

        backButton = new Button("Back");
        backButton.setLayoutX(575);
        backButton.setLayoutY(25);
        backButton.setMinWidth(50);

        processButton = new Button("Process CheckIn");
        processButton.setLayoutX(775);
        processButton.setLayoutY(25);

        deleteButton = new Button("Delete Reservation");
        deleteButton.setLayoutX(650);
        deleteButton.setLayoutY(25);

        paymentMethodText = new Label("Payment Method: ");
        paymentMethodText.setLayoutX(300);
        paymentMethodText.setLayoutY(25);

        cashView = new ImageView(getClass().getResource("icons/cashViewIcon.png").toExternalForm());
        cashView.setLayoutX(400);
        cashView.setLayoutY(15);

        creditCardView = new ImageView(getClass().getResource("icons/creditCardIcon.png").toExternalForm());
        creditCardView.setLayoutX(480);
        creditCardView.setLayoutY(15);

        cashButton = new RadioButton();
        cashButton.setLayoutX(423);
        cashButton.setLayoutY(60);
        cashButton.setUserData("cash");
        cashButton.setToggleGroup(group);


        creditCardButton = new RadioButton();
        creditCardButton .setLayoutX(503);

        creditCardButton .setLayoutY(60);
        creditCardButton.setUserData("creditCard");
        creditCardButton.setToggleGroup(group);

        separator1 = new Line(0,80, 950, 82);

        TableColumn name = new TableColumn("Name");
        name.setMinWidth(150);
        name.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("personName"));

        TableColumn roomNo = new TableColumn("Room No");
        roomNo.setMinWidth(100);
        roomNo.setCellValueFactory(
                new PropertyValueFactory<Reservation, Integer>("reservedRoomNo"));

        TableColumn arrivalDate = new TableColumn("Arrival Date");
        arrivalDate.setMinWidth(100);
        arrivalDate.setCellValueFactory(
                new PropertyValueFactory<Reservation, Date>("arrivalDate"));

        TableColumn departureDate = new TableColumn("Departure Date");
        departureDate.setMinWidth(100);
        departureDate.setCellValueFactory(
                new PropertyValueFactory<Reservation, Date>("departureDate"));

        TableColumn phoneNo = new TableColumn("Phone No");
        phoneNo.setMinWidth(150);
        phoneNo.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("phoneNo"));

        TableColumn totalCost = new TableColumn("Total Cost");
        totalCost.setMinWidth(100);
        totalCost.setCellValueFactory(
                new PropertyValueFactory<Reservation, Double>("totalCost"));

        //"Checkbox" column
        TableColumn delCol = new TableColumn<Reservation, Boolean>();
        delCol.setText("Choose");
        delCol.setMinWidth(100);
        delCol.setCellValueFactory(new PropertyValueFactory("checkbox"));
        delCol.setCellFactory(new Callback<TableColumn<Reservation, Boolean>, TableCell<Reservation, Boolean>>() {
            public TableCell<Reservation, Boolean> call(TableColumn<Reservation, Boolean> p) {
                return new CheckBoxTableCell<Reservation, Boolean>();
            }
        });
        table = new TableView();
        table.setItems(data);
        table.setLayoutX(50);
        table.setLayoutY(83);
        table.setEditable(true);
        table.getColumns().addAll(name, roomNo, arrivalDate, departureDate, phoneNo, totalCost, delCol);

        getChildren().addAll(paymentMethodText, backButton, processButton,deleteButton, separator1, cashButton, cashView, creditCardButton, creditCardView, table);
    }

    @Override
    public void update(Observable o, Object arg) {
        hotel.updateHotelRooms();
        hotel.updateHotelCustomers();
        hotel.updateHotelReservations();
        data = FXCollections.observableArrayList(hotel.getReservations());
        getChildren().removeAll(paymentMethodText, backButton, processButton,deleteButton, separator1, cashButton, cashView, creditCardButton, creditCardView, table);
        table.setItems(data);
        getChildren().addAll(paymentMethodText, backButton, processButton,deleteButton, separator1, cashButton, cashView, creditCardButton, creditCardView, table);
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public ObservableList<Reservation> getData() {
        return data;
    }

    public void setData(ObservableList<Reservation> data) {
        this.data = data;
    }

    public Button getProcessButton() {
        return processButton;
    }

    public void setProcessButton(Button processButton) {
        this.processButton = processButton;
    }

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }


    public RadioButton getCashButton() {
        return cashButton;
    }

    public void setCashButton(RadioButton cashButton) {
        this.cashButton = cashButton;
    }

    public Label getPaymentMethodText() {
        return paymentMethodText;
    }

    public void setPaymentMethodText(Label paymentMethodText) {
        this.paymentMethodText = paymentMethodText;
    }

    public ToggleGroup getGroup() {
        return group;
    }

    public void setGroup(ToggleGroup group) {
        this.group = group;
    }

    public ImageView getCreditCardView() {
        return creditCardView;
    }

    public void setCreditCardView(ImageView creditCardView) {
        this.creditCardView = creditCardView;
    }

    public RadioButton getCreditCardButton() {
        return creditCardButton;
    }

    public void setCreditCardButton(RadioButton creditCardButton) {
        this.creditCardButton = creditCardButton;
    }

    public ImageView getCashView() {
        return cashView;
    }

    public void setCashView(ImageView cashView) {
        this.cashView = cashView;
    }

}
