package by.artkostm.timetable.assets;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Artsiom on 20.04.2015.
 */
public class FontManager {

    private static Typeface labelFont;

    public static Typeface getLabelFont(Context context){
        if(labelFont == null){
            labelFont  = Typeface.createFromAsset(context.getAssets(), "fonts/eurofurence_classic_light.ttf");
        }
        return labelFont;
    }
}
