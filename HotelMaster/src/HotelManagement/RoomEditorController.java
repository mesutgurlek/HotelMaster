package HotelManagement;

import HotelEntities.Hotel;
import HotelStaffScreen.Main;
import HotelStaffScreen.RoomEditorView;

/**
 * Created by Heaven on 12/7/2015.
 */
public class RoomEditorController {
    private RoomEditorView roomEditorView;

    public RoomEditorController(RoomEditorView roomEditorView){
        this.roomEditorView = roomEditorView;

        roomEditorView.getBackButton().setOnAction(e -> {
            Hotel hotel = new Hotel();
            Main.changeSceneRoot(hotel.getMenuView());
        });
    }
}
