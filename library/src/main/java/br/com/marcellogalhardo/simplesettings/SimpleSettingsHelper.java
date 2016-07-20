package br.com.marcellogalhardo.simplesettings;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import br.com.marcellogalhardo.simplesettings.entity.SimpleSettings;
import br.com.marcellogalhardo.simplesettings.ui.SimpleSettingsActivity;
import br.com.marcellogalhardo.simplesettings.util.SharedPreferencesUtils;

public class SimpleSettingsHelper {

    public static Intent createSettingsActivityIntent(Context context) {
        return new Intent(context, SimpleSettingsActivity.class);
    }

    public static void startSettingsActivity(Context context) {
        Intent intent = createSettingsActivityIntent(context);
        context.startActivity(intent);
    }

    public static void startSettingsActivityIfNotDebug(Context context) {
        if (BuildConfig.DEBUG) {
            startSettingsActivity(context);
        }
    }

    public static SimpleSettings getSimpleSettings(Context context) {
        return new SimpleSettings.Builder()
                .baseUrl(SharedPreferencesUtils.getString(context, SimpleSettings.BASE_URL, ""))
                .timeout(SharedPreferencesUtils.getInt(context, SimpleSettings.TIMEOUT, 0))
                .build();
    }

    public static SimpleSettings getDefaultSimpleSettings(Context context) {
        return new SimpleSettings.Builder()
                .baseUrl(SharedPreferencesUtils.getString(context, SimpleSettings.DEFAULT_BASE_URL, ""))
                .timeout(SharedPreferencesUtils.getInt(context, SimpleSettings.DEFAULT_TIMEOUT, 0))
                .build();
    }

    public static void putSimpleSettings(Context context, SimpleSettings settings) {
        SharedPreferencesUtils.putString(context, SimpleSettings.BASE_URL, settings.getBaseUrl());
        SharedPreferencesUtils.putInt(context, SimpleSettings.TIMEOUT, settings.getTimeout());
    }

    public static void putDefaultSettings(Context context, SimpleSettings settings) {
        if (!defaultSettingsAlreadyExists(context)) {
            SharedPreferencesUtils.putString(context, SimpleSettings.DEFAULT_BASE_URL, settings.getBaseUrl());
            SharedPreferencesUtils.putInt(context, SimpleSettings.DEFAULT_TIMEOUT, settings.getTimeout());
            putSimpleSettings(context, settings);
        }
    }

    private static boolean defaultSettingsAlreadyExists(Context context) {
        return !TextUtils.isEmpty(SharedPreferencesUtils.getString(context, SimpleSettings.DEFAULT_BASE_URL, ""));
    }

}
