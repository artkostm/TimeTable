package by.artkostm.timetable.model.filter;

import java.util.ArrayList;
import java.util.List;

import by.artkostm.timetable.LoadActivity;
import by.artkostm.timetable.model.AirVehicleTimeTable;
import by.artkostm.timetable.model.TimeTableContainer;

/**
 * Created by Artsiom on 26.04.2015.
 */
public class AirFilter extends TimeTableFilter {

    private List<AirVehicleTimeTable> tables;

    public AirFilter(TimeTableContainer c){
        super(LoadActivity.AIR_TIMETABLE);
//        tables = getAirTimeTable();
    }

    public List<String> getAirports(){
        List<String> stations = new ArrayList<>();
        for(AirVehicleTimeTable btt : tables){
            stations.add(btt.getAirport());
        }
        return stations;
    }

    public List<String> getAirports(String destAirport){
        List<String> stations = new ArrayList<>();
        for(AirVehicleTimeTable btt : tables){
            if(btt.getDestinationAirport().equals(destAirport)){
                stations.add(btt.getAirport());
            }
        }
        return stations;
    }

    public List<String> getDestAirports(){
        List<String> stations = new ArrayList<>();
        for(AirVehicleTimeTable btt : tables){
            stations.add(btt.getDestinationAirport());
        }
        return stations;
    }

    public List<String> getDestAirports(String airport){
        List<String> stations = new ArrayList<>();
        for(AirVehicleTimeTable btt : tables){
            if(btt.getAirport().equals(airport)){
                stations.add(btt.getDestinationAirport());
            }
        }
        return stations;
    }
}
