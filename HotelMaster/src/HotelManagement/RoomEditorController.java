package HotelManagement;

import HotelEntities.Hotel;
import HotelEntities.Room;
import HotelEntities.RoomStatus;
import HotelEntities.RoomType;
import HotelStaffScreen.Main;
import HotelStaffScreen.MenuView;
import HotelStaffScreen.RoomEditorView;

/**
 * Created by Heaven on 12/7/2015.
 */
public class RoomEditorController {
    private RoomEditorView roomEditorView;

    public RoomEditorController(RoomEditorView roomEditorView){
        this.roomEditorView = roomEditorView;

        roomEditorView.getBackButton().setOnAction(e -> {
            /*Hotel hotel = new Hotel();
            Main.changeSceneRoot(hotel.getMenuView());*/
            MenuView menuView = new MenuView(Main.hotel);
            MenuController menuController = new MenuController(menuView);
            Main.changeSceneRoot(menuView);
            Main.hotel.unsubscribe(this.roomEditorView);
        });

        roomEditorView.getConfirmButton().setOnAction(e->{
            int roomNo = Integer.parseInt(roomEditorView.getRoomNoField().getText());
            int floorNo = Integer.parseInt(roomEditorView.getFloorNoField().getText());
            double dailyPrice = Double.parseDouble(roomEditorView.getDailyPriceField().getText());
            int adultCount = Integer.parseInt(roomEditorView.getAdultCountField().getText());
            int childCount = Integer.parseInt(roomEditorView.getChildCountField().getText());
            String extraInfo = roomEditorView.getExtraInfoField().getText();
            RoomType roomType = typeConverter(roomEditorView.getRoomTypeBox().getValue().toString());

            Room room = new Room(roomNo, floorNo, roomType, RoomStatus.empty, dailyPrice, childCount, adultCount, extraInfo);
            RoomController roomController = new RoomController();
            roomController.addRoom(room);

            Main.hotel.notifyObservers();
        });
    }

    public RoomType typeConverter(String type){
        if( type.equals("king")){
            return RoomType.king;
        }
        else if( type.equals("family") ){
            return RoomType.family;
        }
        else if( type.equals("regular") ){
            return RoomType.regular;
        }
        else{
            return null;
        }
    }
}
