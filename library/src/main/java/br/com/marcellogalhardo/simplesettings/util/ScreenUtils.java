package br.com.marcellogalhardo.simplesettings.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtils {

    public static final String DENSITY_LOW = "LDPI";
    public static final String DENSITY_MEDIUM = "MDPI";
    public static final String DENSITY_HIGH = "HDPI";
    public static final String DENSITY_XHIGH = "XHDPI";
    public static final String DENSITY_XXHIGH = "XXHDPI";
    public static final String DENSITY_XXXHIGH = "XXXHDPI";
    public static final String DENSITY_UNKNOWN = "UNKNOWN";

    public static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        return metrics;
    }

    public static int getDisplayWidthPixels(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getDisplayHeightPixels(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    public static float getDisplayDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    public static float getDisplayDensityDpi(Context context) {
        return getDisplayMetrics(context).densityDpi;
    }

    public static float getDisplayDensityScaled(Context context) {
        return getDisplayMetrics(context).scaledDensity;
    }

    public static String getDensityType(Context context) {
        float densityDpi = getDisplayMetrics(context).densityDpi;
        if (DisplayMetrics.DENSITY_LOW == densityDpi) {
            return DENSITY_LOW;
        } else if (DisplayMetrics.DENSITY_MEDIUM == densityDpi) {
            return DENSITY_MEDIUM;
        } else if (DisplayMetrics.DENSITY_HIGH == densityDpi) {
            return DENSITY_HIGH;
        } else if (DisplayMetrics.DENSITY_XHIGH == densityDpi) {
            return DENSITY_XHIGH;
        } else if (DisplayMetrics.DENSITY_XXHIGH == densityDpi) {
            return DENSITY_XXHIGH;
        } else if (DisplayMetrics.DENSITY_XXXHIGH == densityDpi) {
            return DENSITY_XXXHIGH;
        } else {
            return DENSITY_UNKNOWN;
        }
    }

}
