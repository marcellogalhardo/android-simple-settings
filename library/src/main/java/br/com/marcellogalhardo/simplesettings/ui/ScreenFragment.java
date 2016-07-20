package br.com.marcellogalhardo.simplesettings.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.marcellogalhardo.simplesettings.R;
import br.com.marcellogalhardo.simplesettings.util.ScreenUtils;

public class ScreenFragment extends Fragment {

    private EditText displayWidthPixels;
    private EditText displayHeightPixels;
    private EditText displayDensity;
    private EditText displayDensityDpi;
    private EditText displayDensityScaled;
    private EditText displayDensityType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen, container, false);
        findViews(view);
        setupUi();
        return view;
    }

    private void setupUi() {
        FragmentActivity activity = getActivity();
        displayWidthPixels.setText(String.valueOf(ScreenUtils.getDisplayWidthPixels(activity)));
        displayHeightPixels.setText(String.valueOf(ScreenUtils.getDisplayHeightPixels(activity)));
        displayDensity.setText(String.valueOf(ScreenUtils.getDisplayDensity(activity)));
        displayDensityDpi.setText(String.valueOf(ScreenUtils.getDisplayDensityDpi(activity)));
        displayDensityScaled.setText(String.valueOf(ScreenUtils.getDisplayDensityScaled(activity)));
        displayDensityType.setText(ScreenUtils.getDensityType(activity));
    }

    private void findViews(View view) {
        displayWidthPixels = (EditText) view.findViewById(R.id.edittext_display_width_pixels);
        displayHeightPixels = (EditText) view.findViewById(R.id.edittext_display_height_pixels);
        displayDensity = (EditText) view.findViewById(R.id.edittext_display_density);
        displayDensityDpi = (EditText) view.findViewById(R.id.edittext_display_density_dpi);
        displayDensityScaled = (EditText) view.findViewById(R.id.edittext_display_density_scaled);
        displayDensityType = (EditText) view.findViewById(R.id.edittext_display_density_type);
    }
}
