package com.john.phoneplugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
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

    public static void ShowProgressDialog(final Activity activity, final String message){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ProgressDialog progress = new ProgressDialog(activity);
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.setMessage(message);
                progress.show();
            }
        };

        activity.runOnUiThread(runnable);
    }

    public static void ShowAlert(final Activity activity, final String title, final String message){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(activity)
                        .setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
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

    public static void SendSMS(Activity activity, String phoneNumber, String message){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
