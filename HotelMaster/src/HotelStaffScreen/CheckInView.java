package HotelStaffScreen;

import HotelEntities.Hotel;
import HotelEntities.Room;
import HotelEntities.RoomStatus;
import HotelEntities.RoomType;
import HotelManagement.RoomController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * Created by Heaven on 12/4/2015.
 */
public class CheckInView extends Pane {
    private ObservableList<Room> data;


    public CheckInView(){
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
        extraInfo.setMinWidth(150);
        extraInfo.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("extraInfo"));

        //"Checkbox" column
        TableColumn delCol = new TableColumn<Room, Boolean>();
        delCol.setText("Delete");
        delCol.setMinWidth(50);
        delCol.setCellValueFactory(new PropertyValueFactory("checkbox"));
        delCol.setCellFactory(new Callback<TableColumn<Room, Boolean>, TableCell<Room, Boolean>>() {
            public TableCell<Room, Boolean> call(TableColumn<Room, Boolean> p) {
                return new CheckBoxTableCell<Room, Boolean>();
            }
        });
        TableView table = new TableView();
        table.setItems(data);
        table.setLayoutX(0);
        table.setLayoutY(350);
        table.setEditable(true);
        table.getColumns().addAll(roomNo, floorNo, roomType, roomStatus, dailyPrice, childCount, adultCount,extraInfo, delCol);
        getChildren().add(table);
    }
}
