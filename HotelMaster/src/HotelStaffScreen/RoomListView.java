package HotelStaffScreen;

import HotelEntities.Customer;
import HotelEntities.Hotel;
import HotelEntities.Room;
import HotelEntities.RoomType;
import HotelManagement.CustomerController;
import HotelManagement.RoomController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Callback;

import java.sql.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Heaven on 12/7/2015.
 */
public class RoomListView extends Pane implements Observer{
    private ObservableList<Room> data;
    private Line separator1;
    private Button backButton, processButton;
    private TableView table;
    private Hotel hotel;
    private ImageView miniLogo;

    public RoomListView(Hotel hotel){
        this.hotel = hotel;
        hotel.subscribe(this);

        miniLogo = new ImageView(getClass().getResource("icons/room_listmenu_icon.png").toExternalForm());
        miniLogo.setLayoutX(0);
        miniLogo.setLayoutY(0);

        hotel.updateHotelRooms();
        data = FXCollections.observableArrayList(hotel.getRooms());

        backButton = new Button("Back");
        backButton.setLayoutX(700);
        backButton.setLayoutY(25);
        backButton.setMinWidth(50);

        processButton = new Button("Process Changes");
        processButton.setLayoutX(800);
        processButton.setLayoutY(25);

        separator1 = new Line(0,80, 950, 82);

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
        delCol.setText("Delete");
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
        table.setLayoutY(83);
        table.setEditable(true);
        table.getColumns().addAll(roomNo, floorNo, roomType, roomStatus, dailyPrice, childCount, adultCount,extraInfo, delCol);

        getChildren().addAll(miniLogo, backButton, processButton, separator1, table);
    }

    @Override
    public void update(Observable o, Object arg) {
        hotel.updateHotelRooms();
        hotel.updateHotelCustomers();
        hotel.updateHotelReservations();
        data = FXCollections.observableArrayList(hotel.getRooms());
        getChildren().removeAll(miniLogo, backButton, processButton, separator1, table);
        table.setItems(data);
        getChildren().addAll(miniLogo, backButton, processButton, separator1, table);
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
}
