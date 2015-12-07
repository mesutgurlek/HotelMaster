package HotelStaffScreen;

import HotelEntities.Hotel;
import HotelEntities.Room;
import HotelEntities.RoomStatus;
import HotelEntities.RoomType;
import HotelManagement.RoomController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by Heaven on 12/4/2015.
 */
public class CheckInView extends Pane implements Observer{
    private ObservableList<Room> data;
    private Button backButton;
    private Button processButton;
    private TextField nameField, surnameField, phoneField;
    private Label nameText, surnameText, phoneText;
    private DatePicker arrivalPicker, departurePicker;
    private Label arrivalText, departureText;
    private Line separator1, separator2, separator3;
    private Button calculateCostButton;
    private Label paymentMethodText, totalCostText, totalCost;
    private ImageView cashView, creditCardView;
    private RadioButton cashButton, creditCardButton;
    private ToggleGroup group;
    private Hotel hotel;
    private TableView table;


    public CheckInView(Hotel hotel){
        this.hotel = hotel;
        hotel.subscribe(this);

        hotel.updateHotelRooms();
        data = FXCollections.observableArrayList(hotel.getAvailableRooms());

        group = new ToggleGroup();

        backButton = new Button("Back");
        backButton.setLayoutX(700);
        backButton.setLayoutY(25);
        backButton.setMinWidth(50);

        processButton = new Button("Process Check-In");
        processButton.setLayoutX(800);
        processButton.setLayoutY(25);

        separator1 = new Line(0,80, 950, 82);

        nameText = new Label("Name: ");
        nameText.setLayoutX(50);
        nameText.setLayoutY(105);

        nameField = new TextField();
        nameField.setPromptText("Enter name...");
        nameField.setLayoutX(100);
        nameField.setLayoutY(100);

        surnameText = new Label("Surname: ");
        surnameText.setLayoutX(330);
        surnameText.setLayoutY(105);

        surnameField = new TextField();
        surnameField.setPromptText("Enter surname...");
        surnameField.setLayoutX(400);
        surnameField.setLayoutY(100);

        phoneText = new Label("Phone No: ");
        phoneText.setLayoutX(620);
        phoneText.setLayoutY(105);


        phoneField = new TextField();
        phoneField.setPromptText("Enter phoneNo...");
        phoneField.setLayoutX(700);
        phoneField.setLayoutY(100);

        separator2 = new Line(0, 135, 950, 137);

        arrivalText = new Label("Arrival Date");
        arrivalText.setLayoutX(100);
        arrivalText.setLayoutY(150);

        arrivalPicker = new DatePicker();
        arrivalPicker.setLayoutX(100);
        arrivalPicker.setLayoutY(180);

        departureText = new Label("Departure Date");
        departureText.setLayoutX(350);
        departureText.setLayoutY(150);

        departurePicker = new DatePicker();
        departurePicker.setLayoutX(350);
        departurePicker.setLayoutY(180);

        separator3 = new Line(650, 137, 650, 350);

        paymentMethodText = new Label("Payment Method");
        paymentMethodText.setLayoutX(750);
        paymentMethodText.setLayoutY(145);

        cashView = new ImageView(getClass().getResource("icons/cashViewIcon.png").toExternalForm());
        cashView.setLayoutX(725);
        cashView.setLayoutY(180);

        creditCardView = new ImageView(getClass().getResource("icons/creditCardIcon.png").toExternalForm());
        creditCardView.setLayoutX(825);
        creditCardView.setLayoutY(180);

        cashButton = new RadioButton();
        cashButton.setLayoutX(750);
        cashButton.setLayoutY(225);
        cashButton.setUserData("cash");
        cashButton.setToggleGroup(group);


        creditCardButton = new RadioButton();
        creditCardButton .setLayoutX(850);
        creditCardButton .setLayoutY(225);
        creditCardButton.setUserData("creditCard");
        creditCardButton.setToggleGroup(group);

        calculateCostButton = new Button("Calculate");
        calculateCostButton.setLayoutX(675);
        calculateCostButton.setLayoutY(300);


        totalCostText = new Label("Total Cost: ");
        totalCostText.setLayoutX(750);
        totalCostText.setLayoutY(300);

        totalCost = new Label("0 $");
        totalCost.setLayoutX(850);
        totalCost.setLayoutY(300);

        RoomController controller = new RoomController();
        data = FXCollections.observableArrayList(controller.getAvailableRooms());

        TableColumn roomNo = new TableColumn("Room No");
        roomNo.setMinWidth(100);
        roomNo.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("roomNo"));

        TableColumn floorNo = new TableColumn("Floor No");
        floorNo.setMinWidth(100);
        floorNo.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("floorNo"));

        TableColumn roomType = new TableColumn("Room Type");
        roomType.setMinWidth(100);
        roomType.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("type"));

        TableColumn roomStatus = new TableColumn("Room Status");
        roomStatus.setMinWidth(100);
        roomStatus.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("status"));

        TableColumn dailyPrice = new TableColumn("Daily Price");
        dailyPrice.setMinWidth(100);
        dailyPrice.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("dailyPrice"));

        TableColumn childCount = new TableColumn("Child Count");
        childCount.setMinWidth(100);
        childCount.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("childCount"));

        TableColumn adultCount = new TableColumn("Adult Count");
        adultCount.setMinWidth(100);
        adultCount.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("adultCount"));

        TableColumn extraInfo = new TableColumn("Extra Info");
        extraInfo.setMinWidth(100);
        extraInfo.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("extraInfo"));

        //"Checkbox" column
        TableColumn delCol = new TableColumn<Room, Boolean>();
        delCol.setText("Choose");
        delCol.setMinWidth(100);
        delCol.setCellValueFactory(new PropertyValueFactory("checkbox"));
        delCol.setCellFactory(new Callback<TableColumn<Room, Boolean>, TableCell<Room, Boolean>>() {
            public TableCell<Room, Boolean> call(TableColumn<Room, Boolean> p) {
                return new CheckBoxTableCell<Room, Boolean>();
            }
        });
        table = new TableView();
        table.setItems(data);
        table.setLayoutX(0);
        table.setLayoutY(350);
        table.setMaxHeight(190);
        table.setEditable(true);
        table.getColumns().addAll(roomNo, floorNo, roomType, roomStatus, dailyPrice, childCount, adultCount,extraInfo, delCol);
        getChildren().addAll(calculateCostButton, totalCostText, totalCost, cashButton, creditCardButton, cashView,
                creditCardView,paymentMethodText, separator1, separator2, separator3, arrivalPicker, arrivalText,
                departurePicker, departureText, nameText, surnameText, phoneText, nameField, surnameField, phoneField,
                processButton, backButton, table);
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public ObservableList<Room> getData() {
        return data;
    }

    public void setData(ObservableList<Room> data) {
        this.data = data;
    }

    public ToggleGroup getGroup() {
        return group;
    }

    public void setGroup(ToggleGroup group) {
        this.group = group;
    }

    public DatePicker getArrivalPicker() {
        return arrivalPicker;
    }

    public void setArrivalPicker(DatePicker arrivalPicker) {
        this.arrivalPicker = arrivalPicker;
    }

    public Label getArrivalText() {
        return arrivalText;
    }

    public void setArrivalText(Label arrivalText) {
        this.arrivalText = arrivalText;
    }

    public Button getCalculateCostButton() {
        return calculateCostButton;
    }

    public void setCalculateCostButton(Button calculateCostButton) {
        this.calculateCostButton = calculateCostButton;
    }

    public RadioButton getCashButton() {
        return cashButton;
    }

    public void setCashButton(RadioButton cashButton) {
        this.cashButton = cashButton;
    }

    public ImageView getCashView() {
        return cashView;
    }

    public void setCashView(ImageView cashView) {
        this.cashView = cashView;
    }

    public RadioButton getCreditCardButton() {
        return creditCardButton;
    }

    public void setCreditCardButton(RadioButton creditCardButton) {
        this.creditCardButton = creditCardButton;
    }

    public ImageView getCreditCardView() {
        return creditCardView;
    }

    public void setCreditCardView(ImageView creditCardView) {
        this.creditCardView = creditCardView;
    }

    public DatePicker getDeparturePicker() {
        return departurePicker;
    }

    public void setDeparturePicker(DatePicker departurePicker) {
        this.departurePicker = departurePicker;
    }

    public Label getDepartureText() {
        return departureText;
    }

    public void setDepartureText(Label departureText) {
        this.departureText = departureText;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public Label getNameText() {
        return nameText;
    }

    public void setNameText(Label nameText) {
        this.nameText = nameText;
    }

    public Label getPaymentMethodText() {
        return paymentMethodText;
    }

    public void setPaymentMethodText(Label paymentMethodText) {
        this.paymentMethodText = paymentMethodText;
    }

    public TextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(TextField phoneField) {
        this.phoneField = phoneField;
    }

    public Label getPhoneText() {
        return phoneText;
    }

    public void setPhoneText(Label phoneText) {
        this.phoneText = phoneText;
    }

    public Button getProcessButton() {
        return processButton;
    }

    public void setProcessButton(Button processButton) {
        this.processButton = processButton;
    }

    public Line getSeparator1() {
        return separator1;
    }

    public void setSeparator1(Line separator1) {
        this.separator1 = separator1;
    }

    public Line getSeparator2() {
        return separator2;
    }

    public void setSeparator2(Line separator2) {
        this.separator2 = separator2;
    }

    public Line getSeparator3() {
        return separator3;
    }

    public void setSeparator3(Line separator3) {
        this.separator3 = separator3;
    }

    public TextField getSurnameField() {
        return surnameField;
    }

    public void setSurnameField(TextField surnameField) {
        this.surnameField = surnameField;
    }

    public Label getSurnameText() {
        return surnameText;
    }

    public void setSurnameText(Label surnameText) {
        this.surnameText = surnameText;
    }

    public Label getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Label totalCost) {
        this.totalCost = totalCost;
    }

    public Label getTotalCostText() {
        return totalCostText;
    }

    public void setTotalCostText(Label totalCostText) {
        this.totalCostText = totalCostText;
    }

    @Override
    public void update(Observable o, Object arg) {
        hotel.updateHotelRooms();
        hotel.updateHotelCustomers();
        hotel.updateHotelReservations();
        data = FXCollections.observableArrayList(hotel.getAvailableRooms());
        getChildren().removeAll(calculateCostButton, totalCostText, totalCost, cashButton, creditCardButton, cashView,
                creditCardView,paymentMethodText, separator1, separator2, separator3, arrivalPicker, arrivalText,
                departurePicker, departureText, nameText, surnameText, phoneText, nameField, surnameField, phoneField,
                processButton, backButton, table);
        nameField.setText("");
        phoneField.setText("");
        surnameField.setText("");
        totalCost.setText("");
        arrivalPicker.setValue(null);
        departurePicker.setValue(null);

        table.setItems(data);
        getChildren().addAll(calculateCostButton, totalCostText, totalCost, cashButton, creditCardButton, cashView,
                creditCardView,paymentMethodText, separator1, separator2, separator3, arrivalPicker, arrivalText,
                departurePicker, departureText, nameText, surnameText, phoneText, nameField, surnameField, phoneField,
                processButton, backButton, table);
    }
}
