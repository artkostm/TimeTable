package by.artkostm.timetable.model.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.artkostm.timetable.LoadActivity;
import by.artkostm.timetable.model.AirVehicleTimeTable;
import by.artkostm.timetable.model.BusTimeTable;
import by.artkostm.timetable.model.TimeTableContainer;
import by.artkostm.timetable.model.TrainTimeTable;
import by.artkostm.timetable.model.VehicleTimeTable;

/**
 * Created by Artsiom on 26.04.2015.
 */
public class TimeTableFilter {

    public static interface Switcher{
        public void condition(List<VehicleTimeTable> list, VehicleTimeTable vtt);
    }

    private final int type;
    private static TimeTableContainer container;
    private static List<? extends VehicleTimeTable> typeTable;
    private static Map<Integer, TimeTableFilter> filters;

    static{
        filters = new HashMap<>();
        filters.put(LoadActivity.AIR_TIMETABLE, new AirFilter(container));
        filters.put(LoadActivity.BUS_TIMETABLE, new BusFilter(container));
        filters.put(LoadActivity.TRAIN_TIMETABLE, new TrainFilter(container));
    }

    public TimeTableFilter(){
        type = 0;
    }

    public TimeTableFilter(int t){
        type = t;
    }

    public TimeTableFilter(int t, TimeTableContainer c){
        type = t;
        container = c;
        if(typeTable == null){
            typeTable = getByType(type);
        }
    }

    public List<? extends VehicleTimeTable> getByType(int type){
        Switcher s = null;
        switch (type){
            case LoadActivity.TRAIN_TIMETABLE:
                s = new Switcher() {
                    @Override
                    public void condition(List<VehicleTimeTable> list, VehicleTimeTable vtt) {
                        if(vtt instanceof TrainTimeTable){
                            list.add(vtt);
                        }
                    }
                };
                return getList(s);
            case LoadActivity.BUS_TIMETABLE:
                s = new Switcher() {
                    @Override
                    public void condition(List<VehicleTimeTable> list, VehicleTimeTable vtt) {
                        if(vtt instanceof BusTimeTable){
                            list.add(vtt);
                        }
                    }
                };
                return getList(s);
            case LoadActivity.AIR_TIMETABLE:
                s = new Switcher() {
                    @Override
                    public void condition(List<VehicleTimeTable> list, VehicleTimeTable vtt) {
                        if(vtt instanceof AirVehicleTimeTable){
                            list.add(vtt);
                        }
                    }
                };
                return getList(s);
        }
        return container.getTables();
    }

    private List<? extends VehicleTimeTable> getList(Switcher switcher){
        List<VehicleTimeTable> table = new ArrayList<>();
        for(VehicleTimeTable vtt : container.getTables()){
            switcher.condition(table, vtt);
        }
        return table;
    }

    public List<BusTimeTable> getBusTimeTable(){
        return (List<BusTimeTable>)typeTable;
    }

    public List<TrainTimeTable> getTrainTimeTable(){
        return (List<TrainTimeTable>)typeTable;
    }

    public List<AirVehicleTimeTable> getAirTimeTable(){
        return (List<AirVehicleTimeTable>)typeTable;
    }

    public List<String> getStartDateTimes(){
        List<String> sdt = new ArrayList<>();
        for(VehicleTimeTable vtt : typeTable){
            sdt.add(vtt.getDispatchDateTime());
        }
        return sdt;
    }

    public List<String> getStartDateTimes(String endDate){
        List<String> sdt = new ArrayList<>();
        for(VehicleTimeTable vtt : typeTable){
            if(vtt.getArrivalDateTime().equals(endDate)) {
                sdt.add(vtt.getDispatchDateTime());
            }
        }
        return sdt;
    }

    public List<String> getEndDateTimes(){
        List<String> sdt = new ArrayList<>();
        for(VehicleTimeTable vtt : typeTable){
            sdt.add(vtt.getArrivalDateTime());
        }
        return sdt;
    }

    public List<String> getEndDateTimes(String startDate){
        List<String> sdt = new ArrayList<>();
        for(VehicleTimeTable vtt : typeTable){
            if(vtt.getDispatchDateTime().equals(startDate)) {
                sdt.add(vtt.getArrivalDateTime());
            }
        }
        return sdt;
    }

    public List<String> getDestinations(){
        List<String> sdt = new ArrayList<>();
        for(VehicleTimeTable vtt : typeTable){
            sdt.add(vtt.getDestination());
        }
        return sdt;
    }

    public TimeTableFilter getFilterByType(int type){
        return filters.get(type);
    }
}
