package br.com.marcellogalhardo.simplesettings.util;

import android.content.Intent;

public class IntentUtils {

    public static Intent createSendMailChooserIntent(String appName, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("vnd.android.cursor.item/email");
        intent.putExtra(Intent.EXTRA_EMAIL, "noreply@simplesettings.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, appName + " Settings");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        Intent mailer = Intent.createChooser(intent, null);
        return mailer;
    }

}
