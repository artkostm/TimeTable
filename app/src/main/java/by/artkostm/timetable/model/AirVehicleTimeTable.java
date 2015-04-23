package by.artkostm.timetable.model;

import by.artkostm.androidparsers.core.annotations.xml.XMLAttribute;
import by.artkostm.androidparsers.core.annotations.xml.XMLElement;

/**
 * Created by Artsiom on 21.04.2015.
 */
@XMLElement(name = "AirTimeTable")
public class AirVehicleTimeTable extends VehicleTimeTable {
    @XMLAttribute(name = "airport")
    private String airport;
    @XMLAttribute(name = "destinceToCenter")
    private double distanceToCenter;
    @XMLAttribute(name = "destinationAirport")
    private String destinationAirport;
    @XMLAttribute(name = "movingTime")
    private String movingTime;
    @XMLAttribute(name = "transplantNumber")
    private int transplantNumber;
    @XMLAttribute(name = "company")
    private String company;
    @XMLAttribute(name = "maxWeight")
    private double maxWeight;

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public double getDistanceToCenter() {
        return distanceToCenter;
    }

    public void setDistanceToCenter(double distanceToCenter) {
        this.distanceToCenter = distanceToCenter;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getMovingTime() {
        return movingTime;
    }

    public void setMovingTime(String movingTime) {
        this.movingTime = movingTime;
    }

    public int getTransplantNumber() {
        return transplantNumber;
    }

    public void setTransplantNumber(int transplantNumber) {
        this.transplantNumber = transplantNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirVehicleTimeTable)) return false;
        if (!super.equals(o)) return false;

        AirVehicleTimeTable that = (AirVehicleTimeTable) o;

        if (Double.compare(that.distanceToCenter, distanceToCenter) != 0) return false;
        if (transplantNumber != that.transplantNumber) return false;
        if (Double.compare(that.maxWeight, maxWeight) != 0) return false;
        if (airport != null ? !airport.equals(that.airport) : that.airport != null) return false;
        if (destinationAirport != null ? !destinationAirport.equals(that.destinationAirport) : that.destinationAirport != null)
            return false;
        if (movingTime != null ? !movingTime.equals(that.movingTime) : that.movingTime != null)
            return false;
        return !(company != null ? !company.equals(that.company) : that.company != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        temp = Double.doubleToLongBits(distanceToCenter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (destinationAirport != null ? destinationAirport.hashCode() : 0);
        result = 31 * result + (movingTime != null ? movingTime.hashCode() : 0);
        result = 31 * result + transplantNumber;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        temp = Double.doubleToLongBits(maxWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "AirVehicleTimeTable{" +
                "airport='" + airport + '\'' +
                ", distanceToCenter=" + distanceToCenter +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", movingTime='" + movingTime + '\'' +
                ", transplantNumber=" + transplantNumber +
                ", company='" + company + '\'' +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
