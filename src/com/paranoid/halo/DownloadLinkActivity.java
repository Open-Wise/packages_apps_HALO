package com.paranoid.halo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.PreferenceManager;

public class DownloadLinkActivity extends PreferenceActivity {

    Preference Paranoid;
    Preference Carbon;
    Preference RootBox;
    Preference uXylon;
    Preference Mirage;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.downloadlink);

        Paranoid = findPreference("paranoid");
        Carbon = findPreference("carbon");
        RootBox = findPreference("rootbox");
        uXylon = findPreference("uxylon");
        Mirage = findPreference("mirage");

    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == Paranoid) {
            launchUrl("http://goo.im/devs/paranoidandroid/roms");
        } else if (preference == Carbon) {
            launchUrl("http://goo.im/devs/carbon");
        } else if (preference == RootBox) {
            launchUrl("http://get.rootbox.ca/");
        } else if (preference == uXylon) {
            launchUrl("http://ultimatumdev.org/downloads/");
        } else if (preference == Mirage) {
            launchUrl("http://d-h.st/users/franco/?fld_id=16158#files");
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
        
    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent download = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(download);
    }
}
