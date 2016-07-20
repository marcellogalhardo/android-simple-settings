package br.com.marcellogalhardo.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.marcellogalhardo.simplesettings.SimpleSettingsHelper;
import br.com.marcellogalhardo.simplesettings.entity.SimpleSettings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        SimpleSettings settings = new SimpleSettings.Builder()
                .baseUrl("www.google.com.br")
                .timeout(20)
                .build();
        SimpleSettingsHelper.putDefaultSettings(MainActivity.this, settings);
        findViewById(R.id.button_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (BuildConfig.DEBUG) {
                    SimpleSettingsHelper.startSettingsActivity(MainActivity.this);
                }
            }
        });
    }
}
