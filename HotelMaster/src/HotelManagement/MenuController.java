package HotelManagement;

import HotelEntities.Hotel;
import HotelStaffScreen.CheckInView;
import HotelStaffScreen.Main;
import HotelStaffScreen.MenuView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Heaven on 12/4/2015.
 */
public class MenuController {
    private MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;

        menuView.getCheckInLogo().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Hotel hotel = new Hotel();
                Main.changeSceneRoot(hotel.getCheckInView());
                /*CheckInView checkInView= new CheckInView();
                RoomController roomController= new RoomController(checkInView);
                Main.changeSceneRoot(checkInView);*/
            }
        });

        menuView.getCustomerListLogo().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Hotel hotel = new Hotel();
                Main.changeSceneRoot(hotel.getCustomerListView());
            }
        });
    }
}
