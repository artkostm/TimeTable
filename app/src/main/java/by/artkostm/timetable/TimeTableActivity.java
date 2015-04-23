package by.artkostm.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import by.artkostm.androidparsers.core.ParserContextFactory;
import by.artkostm.androidparsers.core.context.ParserContext;
import by.artkostm.timetable.model.TimeTableContainer;


/**
 * Created by Artsiom on 20.04.2015.
 */
public class TimeTableActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_notification);

        Intent intent = getIntent();
        int type = intent.getIntExtra(LoadActivity.TIMETABLE_TYPE, LoadActivity.BUS_TIMETABLE);
        ParserContext context = ParserContextFactory.getInstance().getParserContext(ParserContextFactory.Type.XML, "by.artkostm.timetable.model");
        ParserContext.Unmarshaller<TimeTableContainer> unmarshaller = context.getUnmarshaller();
        try{
            TimeTableContainer container = unmarshaller.unmarshal(this.getAssets().open("files/tables.xml"));
            Toast.makeText(this, "Size: "+container.getTables().size(), Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(this, "Some ERROR", Toast.LENGTH_LONG).show();
        }

//        String str = FuckaTonyMontana.sayFuck();
//        Toast.makeText(this, "Type is " + getType(type)+"\n"+str, Toast.LENGTH_LONG).show();
    }

    private String getType(int type){
        switch (type){
            case LoadActivity.AIR_TIMETABLE:
                return "AIR_TIMETABLE";
            case LoadActivity.BUS_TIMETABLE:
                return "BUS_TIMETABLE";
            case LoadActivity.TRAIN_TIMETABLE:
                return "TRAIN_TIMETABLE";
            default:
                return "UNKNOWN";
        }
    }
}
