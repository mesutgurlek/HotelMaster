package HotelStaffScreen;

import HotelEntities.Hotel;
import HotelEntities.Room;
import HotelEntities.RoomType;
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
        Hotel hotel = new Hotel();
        this.data = FXCollections.observableArrayList(hotel.getAvailableRooms());

        TableColumn roomNo = new TableColumn("Room No");
        roomNo.setMinWidth(100);
        roomNo.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("roomNo"));

        TableColumn floorNo = new TableColumn("Floor No");
        floorNo.setMinWidth(100);
        floorNo.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("floorNo"));

        TableColumn roomType = new TableColumn("Age");
        roomType.setMinWidth(100);
        roomType.setCellValueFactory(
                new PropertyValueFactory<Room, RoomType>("type"));

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
        table.setItems(getData());
        table.setLayoutX(250);
        table.setLayoutY(100);
        table.setEditable(true);
        table.getColumns().addAll(roomNo, floorNo, roomType, delCol);
        getChildren().add(table);
    }
    public ObservableList<Room> getData() {
        return data;
    }

    public void setData(ObservableList<Room> data) {
        this.data = data;
    }


}
