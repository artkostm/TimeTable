package by.artkostm.timetable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import by.artkostm.androidparsers.core.ParserContextFactory;
import by.artkostm.androidparsers.core.context.ParserContext;
import by.artkostm.timetable.assets.FontManager;
import by.artkostm.timetable.model.TimeTableContainer;
import by.artkostm.timetable.notification.NotificationHelper;


public class LoadActivity extends RegisterTableActivity implements View.OnClickListener{

    private TextView busTextView;
    private TextView airTextView;
    private TextView trainTextView;

    private ImageButton busIB;
    private ImageButton airIB;
    private ImageButton trainIB;

    public static final int AIR_TIMETABLE = 10;
    public static final int BUS_TIMETABLE = 20;
    public static final int TRAIN_TIMETABLE = 30;
    public static final String TIMETABLE_TYPE = "by.artkostm.timetable.TIMETABLE_TYPE";

    public static TimeTableContainer container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        busTextView = (TextView)findViewById(R.id.busText);
        airTextView = (TextView)findViewById(R.id.airText);
        trainTextView = (TextView)findViewById(R.id.trainText);

        final Typeface labelFont = FontManager.getLabelFont(this);
        busTextView.setTypeface(labelFont);
        airTextView.setTypeface(labelFont);
        trainTextView.setTypeface(labelFont);

        busIB = (ImageButton)findViewById(R.id.imageButton2);
        airIB = (ImageButton)findViewById(R.id.imageButton);
        trainIB = (ImageButton)findViewById(R.id.imageButton3);

        busIB.setOnClickListener(this);
        airIB.setOnClickListener(this);
        trainIB.setOnClickListener(this);

        ParserContext context = ParserContextFactory.getInstance().getParserContext(ParserContextFactory.Type.XML, "by.artkostm.timetable");
        ParserContext.Unmarshaller<TimeTableContainer> unmarshaller = context.getUnmarshaller();
        try{
            container = unmarshaller.unmarshal(this.getAssets().open("files/tables.xml"));
        }catch (Exception e){
            Toast.makeText(this, ""+e, Toast.LENGTH_LONG).show();
        }
        NotificationHelper.show(this, "Choose transport type you need", R.layout.load_activity_info, 4000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_load, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton:
                startActivity(setExtra(AIR_TIMETABLE));
                return;
            case R.id.imageButton2:
                startActivity(setExtra(BUS_TIMETABLE));
                return;
            case R.id.imageButton3:
                startActivity(setExtra(TRAIN_TIMETABLE));
                return;
        }
    }

    private Intent setExtra(int type){
        Intent intent = new Intent(this, TimeTableActivity.class);
        intent.putExtra(TIMETABLE_TYPE, type);
        return intent;
    }
}
