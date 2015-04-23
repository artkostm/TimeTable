package by.artkostm.timetable.model;

import java.util.ArrayList;
import java.util.List;

import by.artkostm.androidparsers.core.annotations.xml.XMLElement;
import by.artkostm.androidparsers.core.annotations.xml.XMLElements;

/**
 * Created by Artsiom on 23.04.2015.
 */
@XMLElement(name = "TimeTables")
public class TimeTableContainer {
    @XMLElements(baseType = VehicleTimeTable.class)
    private List<? extends VehicleTimeTable> tables;

    public TimeTableContainer(){
        tables = new ArrayList<>();
    }

    public List<? extends VehicleTimeTable> getTables() {
        return tables;
    }

    public void setTables(List<? extends VehicleTimeTable> tables) {
        this.tables = tables;
    }
}

