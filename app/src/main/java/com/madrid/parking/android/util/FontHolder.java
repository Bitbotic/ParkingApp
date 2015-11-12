package com.madrid.parking.android.util;

/**
 * Created by Marcin on 21/10/2015.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FontHolder {

    public static final int ADELPHI_PLAIN = 0;

    private static final String[] TYPEFACE_FILES = {
            "adelphiPlain/ADELP.TTF",
    };

    private static Typeface[] typefaces = new Typeface[TYPEFACE_FILES.length];

    public static Typeface get(Context context, int typeface){
        if(typefaces[typeface]==null)
            typefaces[typeface] = Typeface.createFromAsset(context.getAssets(), "fonts/" + TYPEFACE_FILES[typeface]);
        return typefaces[typeface];
    }

    public static void setTypeface(View rootview, int viewid, int fontid){
        TextView textView = (TextView)rootview.findViewById(viewid);
        if(textView != null)
            textView.setTypeface(get(rootview.getContext(), fontid));
    }

}
