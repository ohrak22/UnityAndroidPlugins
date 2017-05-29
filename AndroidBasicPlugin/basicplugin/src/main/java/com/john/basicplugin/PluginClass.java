package com.john.basicplugin;

import android.app.Activity;
import android.widget.Toast;

public class PluginClass {

    public static void ShowToast(Activity activity, String message) {
        Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
