package HotelEntities;

import java.util.Date;

/**
 * Created by Heaven on 11/21/2015.
 */
public class Cash extends Payment {
    private double cost;
    private String name;
    private Date date;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
