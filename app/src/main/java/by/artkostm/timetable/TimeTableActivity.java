package by.artkostm.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import by.artkostm.timetable.model.filter.TimeTableFilter;


/**
 * Created by Artsiom on 20.04.2015.
 */
public class TimeTableActivity extends Activity {

    public static TimeTableFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int type = intent.getIntExtra(LoadActivity.TIMETABLE_TYPE, LoadActivity.BUS_TIMETABLE);
        filter = new TimeTableFilter(type, LoadActivity.container);
        processViews(type);
        Toast.makeText(this, "Container size: "+LoadActivity.container.getTables().size(), Toast.LENGTH_LONG).show();
    }

    private void processViews(int type){
        switch (type){
            case LoadActivity.AIR_TIMETABLE:
                processAir();
                return;
            case LoadActivity.BUS_TIMETABLE:
                processBus();
                return;
            case LoadActivity.TRAIN_TIMETABLE:
                processTrain();
                return;
            default:
                setContentView(R.layout.error_settings_activity);
                return;
        }
    }

    private void processBus() {
        setContentView(R.layout.bus_settings_activity);
    }

    private void processAir() {
        setContentView(R.layout.air_settings_activity);
    }

    private void processTrain() {
        setContentView(R.layout.train_settings_activity);
    }
}
