package by.artkostm.timetable.model.filter;

import java.util.ArrayList;
import java.util.List;

import by.artkostm.timetable.LoadActivity;
import by.artkostm.timetable.model.TimeTableContainer;
import by.artkostm.timetable.model.TrainTimeTable;

/**
 * Created by Artsiom on 26.04.2015.
 */
public class TrainFilter extends TimeTableFilter {

    private List<TrainTimeTable> tables;

    public TrainFilter(TimeTableContainer c){
        super(LoadActivity.TRAIN_TIMETABLE);
//        tables = getTrainTimeTable();
    }

    public List<String> getStations(){
        List<String> stations = new ArrayList<>();
        for(TrainTimeTable btt : tables){
            stations.add(btt.getStation());
        }
        return stations;
    }

    public List<String> getStations(String destSt){
        List<String> stations = new ArrayList<>();
        for(TrainTimeTable btt : tables){
            if(btt.getDestStation().equals(destSt)) {
                stations.add(btt.getStation());
            }
        }
        return stations;
    }

    public List<String> getDestStations(){
        List<String> stations = new ArrayList<>();
        for(TrainTimeTable btt : tables){
            stations.add(btt.getDestStation());
        }
        return stations;
    }

    public List<String> getDestStations(String st){
        List<String> stations = new ArrayList<>();
        for(TrainTimeTable btt : tables){
            if(btt.getStation().equals(st)){
                stations.add(btt.getDestStation());
            }
        }
        return stations;
    }
}
