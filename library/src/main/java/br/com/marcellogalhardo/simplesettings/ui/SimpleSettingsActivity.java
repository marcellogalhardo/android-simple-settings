package br.com.marcellogalhardo.simplesettings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import br.com.marcellogalhardo.simplesettings.R;
import br.com.marcellogalhardo.simplesettings.SimpleSettingsHelper;
import br.com.marcellogalhardo.simplesettings.entity.SimpleSettings;
import br.com.marcellogalhardo.simplesettings.util.ClipboardUtils;
import br.com.marcellogalhardo.simplesettings.util.ExportUtils;
import br.com.marcellogalhardo.simplesettings.util.IntentUtils;

public class SimpleSettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CoordinatorLayout container;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static String getApplicationName(Context context) {
        int stringId = context.getApplicationInfo().labelRes;
        return context.getString(stringId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_settings);
        findViews();
        setupToolbar(toolbar);
        setupUi();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return super.onOptionsItemSelected(item);
        } else if (id == R.id.action_send_by_email) {
            sendMail(getApplicationName(this), getAppInfo());
            return false;
        } else if (id == R.id.action_copy_to_clipboard) {
            copyToClipboard(getApplicationName(this), getAppInfo());
            Snackbar.make(container, R.string.settings_successfully_copy_to_clipboard, Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_simple_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private String getAppInfo() {
        SimpleSettings defaultSettings = SimpleSettingsHelper.getDefaultSimpleSettings(this);
        SimpleSettings customSettings = SimpleSettingsHelper.getSimpleSettings(this);
        return ExportUtils.getExportData(this, defaultSettings, customSettings);
    }

    private void sendMail(String appName, String text) {
        Intent mailer = IntentUtils.createSendMailChooserIntent(appName, text);
        startActivity(mailer);
    }

    private void copyToClipboard(String appName, String text) {
        ClipboardUtils.copyToClipboard(this, appName, text);
    }

    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setTitle(R.string.settings);
        }
    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        container = (CoordinatorLayout) findViewById(R.id.coordinatorlayout_container);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void setupUi() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private static final int TAB_TOTAL_COUNT = 3;
        private static final int TAB_POSITION_SERVER = 0;
        private static final int TAB_POSITION_GENERAL = 1;
        private static final int TAB_POSITION_SCREEN = 2;

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == TAB_POSITION_SERVER) {
                return new ServerFragment();
            } else if (position == TAB_POSITION_GENERAL) {
                return new GeneralFragment();
            } else if (position == TAB_POSITION_SCREEN) {
                return new ScreenFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == TAB_POSITION_SERVER) {
                return getString(R.string.tab_http);
            } else if (position == TAB_POSITION_GENERAL) {
                return getString(R.string.tab_general);
            } else if (position == TAB_POSITION_SCREEN) {
                return getString(R.string.tab_screen);
            }
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return TAB_TOTAL_COUNT;
        }
    }

}
