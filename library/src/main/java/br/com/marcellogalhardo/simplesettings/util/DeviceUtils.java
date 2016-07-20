package br.com.marcellogalhardo.simplesettings.util;

import android.os.Build;

import br.com.marcellogalhardo.simplesettings.BuildConfig;

public class DeviceUtils {

    public static int getAppVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public static String getOsName() {
        return Build.VERSION.RELEASE;
    }

    public static int getOsSdk() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    public static String getDeviceManufacturer() {
        return android.os.Build.MANUFACTURER;
    }

}
