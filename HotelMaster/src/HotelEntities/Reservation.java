package HotelEntities;

import java.sql.Date;

/**
 * Created by Heaven on 11/21/2015.
 */
public class Reservation {
    private String personName;
    private String personSurname;
    private int reservedRoomNo;
    private Date arrivalDate;
    private Date departureDate;
    private String phoneNo;
    private double totalCost;

    public Reservation(String personName, int reservedRoomNo, Date arrivalDate, Date departureDate, String phoneNo, double totalCost) {
        this.personName = personName;
        this.reservedRoomNo = reservedRoomNo;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.phoneNo = phoneNo;
        this.totalCost = totalCost;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getReservedRoomNo() {
        return reservedRoomNo;
    }

    public void setReservedRoomNo(int reservedRoomNo) {
        this.reservedRoomNo = reservedRoomNo;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
