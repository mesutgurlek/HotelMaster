package HotelManagement;

import DatabaseManagement.HotelStorageFacade;
import HotelEntities.Room;
import HotelEntities.RoomStatus;
import HotelEntities.RoomType;

import java.util.ArrayList;

/**
 * Created by Heaven on 11/21/2015.
 */
public class RoomController {
    HotelStorageFacade storage;

    public RoomController() {
        storage = new HotelStorageFacade();
    }

    public void addRoom(Room room){
        storage.addRoom(room.getRoomNo(), typeConverter(room.getType()), statusConverter(room.getStatus()), room.getFloorNo(), room.getAdultCount(), room.getChildCount(), room.getDailyPrice(), room.getExtraInfo());
    }

    public void deleteRoom(int roomNo){
        storage.deleteRoom(roomNo);
    }

    public void updateRoom(int roomNo, String status){
        storage.updateRoom(roomNo, status);
    }

    public ArrayList<Room> getAllRooms(){
       return storage.getRooms();
    }

    public ArrayList<Room> getAvailableRooms(){
        ArrayList<Room> allRooms = storage.getRooms();
        ArrayList<Room> availableRooms = new ArrayList<>();

        for( int i = 0; i < allRooms.size(); i++){
            if(statusConverter(allRooms.get(i).getStatus()).equals("empty")){
                availableRooms.add(allRooms.get(i));
            }
        }

        return availableRooms;
    }

    public String typeConverter(RoomType type){
        if( type == RoomType.king){
            return "king";
        }
        else if( type == RoomType.family){
            return "family";
        }
        else if( type == RoomType.regular){
            return "regular";
        }
        else{
            return "";
        }
    }
    public String statusConverter(RoomStatus stat){
        if( stat == RoomStatus.empty){
            return "empty";
        }
        else if( stat == RoomStatus.full){
            return "full";
        }
        else if( stat == RoomStatus.reserved){
            return "reserved";
        }
        else{
            return "";
        }
    }

}
