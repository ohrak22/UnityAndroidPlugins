package com.john.phoneplugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class PhoneClass {

    public static void ShowToast(Activity activity, String message){
        Toast toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void ShowToastRunnable(final Activity activity, final String message){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
                toast.show();
            }
        };

        activity.runOnUiThread(runnable);
    }


    public static void PhoneCall(Activity activity, String phoneNumber){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        try{
            activity.startActivity(intent);
        }
        catch (RuntimeException e){
            ShowToastRunnable(activity, e.getMessage());
        }
    }
}
