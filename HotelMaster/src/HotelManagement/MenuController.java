package HotelManagement;

import HotelEntities.Hotel;
import HotelStaffScreen.*;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;

/**
 * Created by Heaven on 12/4/2015.
 */
public class MenuController {
    private MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;

        this.menuView.getCheckInLogo().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /*Hotel hotel = new Hotel();
                Main.changeSceneRoot(hotel.getCheckInView());*/
                CheckInView checkInView= new CheckInView(Main.hotel);
                CheckInController checkInViewController= new CheckInController(checkInView);
                Main.changeSceneRoot(checkInView);
                Main.hotel.unsubscribe(menuView);
            }
        });

        this.menuView.getCustomerListLogo().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CustomerListView customerListView = new CustomerListView(Main.hotel);
                CustomerListController customerListController = new CustomerListController(customerListView);
                Main.changeSceneRoot(customerListView);
                Main.hotel.unsubscribe(menuView);
            }
        });

        this.menuView.getRoomEditorLogo().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                RoomEditorView roomEditorView = new RoomEditorView(Main.hotel);
                RoomEditorController roomEditorController = new RoomEditorController(roomEditorView);
                Main.changeSceneRoot(roomEditorView);
                Main.hotel.unsubscribe(menuView);
            }
        });
    }
}
