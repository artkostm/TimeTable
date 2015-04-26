package by.artkostm.timetable;

import android.app.Activity;
import android.os.Bundle;

import by.artkostm.androidparsers.core.util.AndroidDexUtil;
import by.artkostm.timetable.model.AirVehicleTimeTable;
import by.artkostm.timetable.model.BusTimeTable;
import by.artkostm.timetable.model.TimeTableContainer;
import by.artkostm.timetable.model.TrainTimeTable;

/**
 * Created by Artsiom on 26.04.2015.
 */
public class RegisterTableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegisterHolder.register();
    }

    public static class RegisterHolder{
        private static void register(){
            AndroidDexUtil.register(BusTimeTable.class);
            AndroidDexUtil.register(AirVehicleTimeTable.class);
            AndroidDexUtil.register(TrainTimeTable.class);
            AndroidDexUtil.register(TimeTableContainer.class);
        }
    }
}
