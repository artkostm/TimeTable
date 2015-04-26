package by.artkostm.timetable.model.filter;

import java.util.ArrayList;
import java.util.List;

import by.artkostm.timetable.LoadActivity;
import by.artkostm.timetable.model.BusTimeTable;
import by.artkostm.timetable.model.TimeTableContainer;

/**
 * Created by Artsiom on 26.04.2015.
 */
public class BusFilter extends TimeTableFilter {

    private List<BusTimeTable> tables;

    public BusFilter(TimeTableContainer c){
        super(LoadActivity.BUS_TIMETABLE);
//        tables = getBusTimeTable();
    }

    public List<String> getStations(){
        List<String> stations = new ArrayList<>();
        for(BusTimeTable btt : tables){
            stations.add(btt.getStation());
        }
        return stations;
    }

    public List<String> getStations(String destSt){
        List<String> stations = new ArrayList<>();
        for(BusTimeTable btt : tables){
            if(btt.getDestStation().equals(destSt)) {
                stations.add(btt.getStation());
            }
        }
        return stations;
    }

    public List<String> getDestStations(){
        List<String> stations = new ArrayList<>();
        for(BusTimeTable btt : tables){
            stations.add(btt.getDestStation());
        }
        return stations;
    }

    public List<String> getDestStations(String st){
        List<String> stations = new ArrayList<>();
        for(BusTimeTable btt : tables){
            if(btt.getStation().equals(st)){
                stations.add(btt.getDestStation());
            }
        }
        return stations;
    }
}
