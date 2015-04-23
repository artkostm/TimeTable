package by.artkostm.timetable.notification;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import by.artkostm.timetable.R;
import by.artkostm.timetable.assets.FontManager;
import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by Artsiom on 20.04.2015.
 */
public final class NotificationHelper {

    private NotificationHelper(){}

    public static void show(Activity activity, int resource, int duration){
        View v = activity.getLayoutInflater().inflate(resource, null);
        final Crouton crouton;
        crouton = Crouton.make(activity, v);
        Configuration croutonConfiguration = new Configuration.Builder()
                .setDuration(duration)
                .setInAnimation(R.anim.tr)
                .setOutAnimation(R.anim.slide_up)
                .build();
        crouton.setConfiguration(croutonConfiguration);
        crouton.show();
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crouton.hide();
            }
        });
    }

    public static void show(Activity activity, String text, int resource, int duration){
        View v = activity.getLayoutInflater().inflate(resource, null);
        ((TextView)v).setTypeface(FontManager.getLabelFont(activity));
        ((TextView)v).setText(text);
        final Crouton crouton;
        Configuration croutonConfiguration = new Configuration.Builder()
                .setDuration(duration)
                .setInAnimation(R.anim.tr)
                .setOutAnimation(R.anim.slide_up)
                .build();
        crouton = Crouton.make(activity, v);
        crouton.setConfiguration(croutonConfiguration);
        crouton.show();
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crouton.hide();
            }
        });
    }
}
