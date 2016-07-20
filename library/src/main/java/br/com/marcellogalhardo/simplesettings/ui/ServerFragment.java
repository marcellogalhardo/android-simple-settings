package br.com.marcellogalhardo.simplesettings.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import br.com.marcellogalhardo.simplesettings.R;
import br.com.marcellogalhardo.simplesettings.SimpleSettingsHelper;
import br.com.marcellogalhardo.simplesettings.entity.SimpleSettings;

public class ServerFragment extends Fragment {

    private ScrollView container;
    private EditText serverUrl;
    private EditText timeout;
    private Button restoreDefault;
    private Button save;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_server, container, false);
        findViews(view);
        loadPreferences();
        setListeners();
        return view;
    }

    private void setListeners() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleSettings settings = getSettings();
                saveSettings(settings);
                showSuccessMessage();
            }
        });
        restoreDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleSettings settings = getDefaultSettings();
                saveSettings(settings);
                loadPreferences();
                showRestoreDefaultMessage();
            }
        });
    }

    private void showSuccessMessage() {
        Snackbar.make(container, R.string.settings_successfully_saved, Snackbar.LENGTH_SHORT).show();
    }

    private void showRestoreDefaultMessage() {
        Snackbar.make(container, R.string.default_settings_have_been_restored, Snackbar.LENGTH_SHORT).show();
    }

    private void saveSettings(SimpleSettings settings) {
        SimpleSettingsHelper.putSimpleSettings(getActivity(), settings);
    }

    private SimpleSettings getSettings() {
        return new SimpleSettings.Builder()
                .baseUrl(serverUrl.getText().toString())
                .timeout(Integer.parseInt(timeout.getText().toString()))
                .build();
    }

    private SimpleSettings getDefaultSettings() {
        return SimpleSettingsHelper.getDefaultSimpleSettings(getActivity());
    }

    private void findViews(View view) {
        container = (ScrollView) view.findViewById(R.id.scrollview_container);
        serverUrl = (EditText) view.findViewById(R.id.edittext_server_url);
        timeout = (EditText) view.findViewById(R.id.edittext_timeout);
        restoreDefault = (Button) view.findViewById(R.id.button_restore_default);
        save = (Button) view.findViewById(R.id.button_save);
    }

    private void loadPreferences() {
        SimpleSettings settings = SimpleSettingsHelper.getSimpleSettings(getActivity());
        serverUrl.setText(settings.getBaseUrl());
        if (settings.getTimeout() > 0) {
            timeout.setText(settings.getTimeoutAsText());
        }
    }

}
