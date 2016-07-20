package br.com.marcellogalhardo.simplesettings.util;

import android.content.Context;

import br.com.marcellogalhardo.simplesettings.R;
import br.com.marcellogalhardo.simplesettings.entity.SimpleSettings;

public class ExportUtils {

    public static String getExportData(Context context, SimpleSettings defaultSettings, SimpleSettings customSettings) {
        return getHttpData(context, defaultSettings, customSettings)
                + getGeneralData(context)
                + getScreenData(context);
    }

    private static String getHttpData(Context context, SimpleSettings defaultSettings, SimpleSettings customSettings) {
        return context.getString(R.string.tab_http)
                + context.getString(R.string.line_break)
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_default_base_url, defaultSettings.getBaseUrl())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_default_timeout, defaultSettings.getTimeout())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_base_url, customSettings.getBaseUrl())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_timeout, customSettings.getTimeout())
                + context.getString(R.string.line_break)
                + context.getString(R.string.line_break);
    }

    private static String getGeneralData(Context context) {
        return context.getString(R.string.tab_general)
                + context.getString(R.string.line_break)
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_version_code, DeviceUtils.getAppVersionCode())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_version_name, DeviceUtils.getAppVersionName())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_os_name, DeviceUtils.getOsName())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_os_sdk, DeviceUtils.getOsSdk())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_device_model, DeviceUtils.getDeviceModel())
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_device_manufacturer, DeviceUtils.getDeviceManufacturer())
                + context.getString(R.string.line_break)
                + context.getString(R.string.line_break);
    }

    private static String getScreenData(Context context) {
        return context.getString(R.string.tab_screen)
                + context.getString(R.string.line_break)
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_display_width_pixels, ScreenUtils.getDisplayWidthPixels(context))
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_display_height_pixels, ScreenUtils.getDisplayHeightPixels(context))
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_display_density, ScreenUtils.getDisplayDensity(context))
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_display_density_dpi, ScreenUtils.getDisplayDensityDpi(context))
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_display_density_scaled, ScreenUtils.getDisplayDensityScaled(context))
                + context.getString(R.string.line_break)
                + context.getString(R.string.export_display_density_type, ScreenUtils.getDensityType(context));
    }

}
