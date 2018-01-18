package br.com.box1993.aluracursolayout.ui.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/**
 * Created by khalleb on 17/01/18.
 */

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolverDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDrawable);
    }
}
