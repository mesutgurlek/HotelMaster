package HotelManagement;

import HotelEntities.Customer;
import HotelEntities.Room;
import HotelStaffScreen.Main;
import HotelStaffScreen.MenuView;
import HotelStaffScreen.RoomListView;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Heaven on 12/7/2015.
 */
public class RoomListController {
    private RoomListView roomListView;

    public RoomListController(RoomListView roomListView){
        this.roomListView = roomListView;

        roomListView.getBackButton().setOnAction(e -> {
            MenuView menuView = new MenuView(Main.hotel);
            MenuController menuController = new MenuController(menuView);
            Main.changeSceneRoot(menuView);
            Main.hotel.unsubscribe(this.roomListView);
        });

        roomListView.getProcessButton().setOnAction(e->{
            ObservableList<Room> rooms = roomListView.getData();
            ArrayList<Room> selectedRooms = new ArrayList<Room>();
            for(Room r : rooms){
                if(r.getCheckbox()){
                    selectedRooms.add(r);
                }
            }

            RoomController roomController = new RoomController();
            for(Room r : selectedRooms){
                roomController.deleteRoom(r.getRoomNo());
            }

            for(Observer o : Main.hotel.getObservers()){
                System.out.println("observer" + o.toString());
            }
            Main.hotel.notifyObservers();
        });

    }
}
