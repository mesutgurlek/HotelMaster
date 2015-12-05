package HotelEntities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

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
    private String extraInfo;
    private List<Observer> subscribedViews= new ArrayList<>();

    //Updated items
    private BooleanProperty checkbox;
    private Boolean isSelected;


    public Room(int roomNo, int floorNo, RoomType type, RoomStatus status, double dailyPrice, int childCount, int adultCount, String extraInfo) {
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.type = type;
        this.status = status;
        this.dailyPrice = dailyPrice;
        this.childCount = childCount;
        this.adultCount = adultCount;
        this.extraInfo = extraInfo;
        this.isSelected = false;

        //Handles with choosing room
        this.checkbox = new SimpleBooleanProperty(false);
        this.checkbox.addListener(new ChangeListener<Boolean>() {

            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                isSelected = t1;
            }
        });
    }
///////////////////////
    public void subscribe(Observer observer){
        subscribedViews.add(observer);
    }

    public void unsubscribe(Observer observer){
        subscribedViews.remove(observer);
    }

    public void notifyObservers(){
        for(Observer o: subscribedViews){
            o.notify();
        }
    }

    public List<Observer> getSubscribedViews() {
        return subscribedViews;
    }

    public void setSubscribedViews(List<Observer> subscribedViews) {
        this.subscribedViews = subscribedViews;
    }
//////////////////////////////////////////

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

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }
    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }


    public int getChildCount() {
        return childCount;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public boolean getCheckbox() {
        return checkbox.get();
    }

    public BooleanProperty checkboxProperty() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox.set(checkbox);
    }
}
