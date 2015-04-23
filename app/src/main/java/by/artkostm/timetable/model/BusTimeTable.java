package by.artkostm.timetable.model;

import by.artkostm.androidparsers.core.annotations.xml.XMLAttribute;
import by.artkostm.androidparsers.core.annotations.xml.XMLElement;

/**
 * Created by Artsiom on 21.04.2015.
 */
@XMLElement(name = "BusTimeTable")
public class BusTimeTable extends EarthVehicleTimeTable{
    @XMLAttribute(name = "mark")
    private String busMark;
    @XMLAttribute(name = "adventureTime")
    private int adventureTime;

    public String getBusMark() {
        return busMark;
    }

    public void setBusMark(String busMark) {
        this.busMark = busMark;
    }

    public int getAdventureTime() {
        return adventureTime;
    }

    public void setAdventureTime(int adventureTime) {
        this.adventureTime = adventureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusTimeTable)) return false;
        if (!super.equals(o)) return false;

        BusTimeTable that = (BusTimeTable) o;

        if (adventureTime != that.adventureTime) return false;
        return !(busMark != null ? !busMark.equals(that.busMark) : that.busMark != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (busMark != null ? busMark.hashCode() : 0);
        result = 31 * result + adventureTime;
        return result;
    }

    @Override
    public String toString() {
        return "BusTimeTable{" +
                "busMark='" + busMark + '\'' +
                ", adventureTime=" + adventureTime +
                '}';
    }
}
