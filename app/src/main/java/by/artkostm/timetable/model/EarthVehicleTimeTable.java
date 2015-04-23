package by.artkostm.timetable.model;

import by.artkostm.androidparsers.core.annotations.xml.XMLAttribute;

/**
 * Created by Artsiom on 21.04.2015.
 */
public class EarthVehicleTimeTable extends VehicleTimeTable {
    @XMLAttribute(name = "station")
    private String station;
    @XMLAttribute(name = "platform")
    private String platform;
    @XMLAttribute(name = "destStation")
    private String destStation;

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDestStation() {
        return destStation;
    }

    public void setDestStation(String destStation) {
        this.destStation = destStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EarthVehicleTimeTable)) return false;
        if (!super.equals(o)) return false;

        EarthVehicleTimeTable that = (EarthVehicleTimeTable) o;

        if (station != null ? !station.equals(that.station) : that.station != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null)
            return false;
        return !(destStation != null ? !destStation.equals(that.destStation) : that.destStation != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (station != null ? station.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (destStation != null ? destStation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EarthVehicleTimeTable{" +
                "station='" + station + '\'' +
                ", platform='" + platform + '\'' +
                ", destStation='" + destStation + '\'' +
                '}';
    }
}
