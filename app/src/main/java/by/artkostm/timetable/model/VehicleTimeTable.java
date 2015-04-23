package by.artkostm.timetable.model;

import by.artkostm.androidparsers.core.annotations.xml.XMLAttribute;

/**
 * Created by Artsiom on 21.04.2015.
 */
public class VehicleTimeTable {
    @XMLAttribute(name = "roteNumber")
    private int roteNumber;
    @XMLAttribute(name = "dispatchDateTime")
    private String dispatchDateTime;
    @XMLAttribute(name = "destination")
    private String destination;
    @XMLAttribute(name = "price")
    private double price;
    @XMLAttribute(name = "arrivalDateTime")
    private String arrivalDateTime;

    public int getRoteNumber() {
        return roteNumber;
    }

    public void setRoteNumber(int roteNumber) {
        this.roteNumber = roteNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDispatchDateTime() {
        return dispatchDateTime;
    }

    public void setDispatchDateTime(String dispatchDateTime) {
        this.dispatchDateTime = dispatchDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleTimeTable)) return false;

        VehicleTimeTable that = (VehicleTimeTable) o;

        if (roteNumber != that.roteNumber) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (!dispatchDateTime.equals(that.dispatchDateTime)) return false;
        return destination.equals(that.destination);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = roteNumber;
        result = 31 * result + dispatchDateTime.hashCode();
        result = 31 * result + destination.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VehicleTimeTable{" +
                "roteNumber=" + roteNumber +
                ", dispatchDateTime='" + dispatchDateTime + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }
}
