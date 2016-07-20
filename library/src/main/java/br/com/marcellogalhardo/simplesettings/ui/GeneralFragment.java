package br.com.marcellogalhardo.simplesettings.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.marcellogalhardo.simplesettings.R;
import br.com.marcellogalhardo.simplesettings.util.DeviceUtils;

public class GeneralFragment extends Fragment {

    private EditText versionCode;
    private EditText versionName;
    private EditText osName;
    private EditText osSdk;
    private EditText deviceModel;
    private EditText deviceManufacturer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_general, container, false);
        findViews(view);
        setupUi();
        return view;
    }

    private void setupUi() {
        versionCode.setText(String.valueOf(DeviceUtils.getAppVersionCode()));
        versionName.setText(DeviceUtils.getAppVersionName());
        osName.setText(DeviceUtils.getOsName());
        osSdk.setText(String.valueOf(DeviceUtils.getOsSdk()));
        deviceModel.setText(DeviceUtils.getDeviceModel());
        deviceManufacturer.setText(DeviceUtils.getDeviceManufacturer());
    }

    private void findViews(View view) {
        versionCode = (EditText) view.findViewById(R.id.edittext_version_code);
        versionName = (EditText) view.findViewById(R.id.edittext_version_name);
        osName = (EditText) view.findViewById(R.id.edittext_os_name);
        osSdk = (EditText) view.findViewById(R.id.edittext_os_sdk);
        deviceModel = (EditText) view.findViewById(R.id.edittext_device_model);
        deviceManufacturer = (EditText) view.findViewById(R.id.edittext_device_manufacturer);
    }
}
