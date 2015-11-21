package HotelEntities;

/**
 * Created by Heaven on 11/21/2015.
 */
public class Room {
    private int roomNo;
    private int floorNo;
    private RoomType type;
    private RoomStatus status;
    private double dailyPrice;
    private int childCount;
    private int adultCount;


    public int getRoomNo() {
        return roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public RoomType getType() {
        return type;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public double getDaillyPrice() {
        return dailyPrice;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setDaillyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public int getAdultCount() {
        return adultCount;
    }
}
