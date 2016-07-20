package br.com.marcellogalhardo.simplesettings.util;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesUtils {

    private static final String DEFAULT_SUFFIX = "SimpleSettings_";
    private static SharedPreferences mSharedPreferences;

    private SharedPreferencesUtils() {
        throw new UnsupportedOperationException("Use getSharedPreferences.");
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = context.getSharedPreferences(DEFAULT_SUFFIX, Context.MODE_PRIVATE);
        }
        return mSharedPreferences;
    }

    public static boolean getBoolean(Context context, String prefKey, boolean defaultValue) {
        return getSharedPreferences(context).getBoolean(prefKey, defaultValue);
    }

    public static Integer getInt(Context context, String prefKey, Integer defaultValue) {
        return Integer.valueOf(getSharedPreferences(context).getInt(prefKey, defaultValue.intValue()));
    }

    public static Long getLong(Context context, String prefKey, Long defaultValue) {
        return Long.valueOf(getSharedPreferences(context).getLong(prefKey, defaultValue.longValue()));
    }

    public static String getString(Context context, String prefKey, String defaultValue) {
        return getSharedPreferences(context).getString(prefKey, defaultValue);
    }

    public static void putLong(Context context, String prefKey, Long newValue) {
        SharedPreferences mPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putLong(prefKey, newValue.longValue());
        editor.commit();
    }

    public static void putInt(Context context, String prefKey, Integer newValue) {
        SharedPreferences mPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(prefKey, newValue.intValue());
        editor.commit();
    }

    public static void putString(Context context, String prefKey, String newValue) {
        SharedPreferences mPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(prefKey, newValue);
        editor.commit();
    }

    public static void putBoolean(Context context, String prefKey, Boolean newValue) {
        SharedPreferences mPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(prefKey, newValue.booleanValue());
        editor.commit();
    }

    public static void remove(Context context, String prefKey) {
        SharedPreferences mPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.remove(prefKey);
        editor.commit();
    }
}