package com.example.proyectofinal.fragments;


import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.proyectofinal.R;

public class Fragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
