package br.com.marcellogalhardo.simplesettings.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardUtils {

    public static void copyToClipboard(Context context, String appName, String text) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(appName + " Settings", text);
        clipboard.setPrimaryClip(clip);
    }

}
