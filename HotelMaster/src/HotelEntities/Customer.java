package HotelEntities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Heaven on 11/21/2015.
 */
public class Customer{
    private String name;
    private int roomNo;
    private String payment;
    private Date arrivalDate;
    private Date departureDate;
    private double totalCost;
    private String phoneNo;

    //Updated items
    private BooleanProperty checkbox;
    private Boolean isSelected;

    public Customer(String name, int roomNo, String payment, Date arrivalDate, Date departureDate, double totalCost, String phoneNo) {
        this.name = name;
        this.roomNo = roomNo;
        this.payment = payment;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.totalCost = totalCost;
        this.phoneNo = phoneNo;

        //Handles with choosing customer
        this.checkbox = new SimpleBooleanProperty(false);
        this.checkbox.addListener(new ChangeListener<Boolean>() {

            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                isSelected = t1;
                System.out.println(getRoomNo() + " " + getName() + " " + isSelected);
            }
        });
    }
    ////////////////////////////////
    private List<Observer> subscribedViews= new ArrayList<>();

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
//////////////////////////////////////

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
