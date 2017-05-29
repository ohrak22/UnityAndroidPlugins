package com.john.basicplugin;

import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class MainActivity extends UnityPlayerActivity {

    static final int REQUEST_CODE = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UnityPlayer.UnitySendMessage("BasicPluginExample", "OnUnitySendMessage", "MainActivity onCreate");

    }

    public void LaunchActivity() {
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }

    public void LaunchActivityForResult() {
        Intent intent = new Intent(this, SubActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                UnityPlayer.UnitySendMessage("BasicPluginExample", "OnUnitySendMessage", "onActivityResult: " + data.getStringExtra("key"));
            }
        }
    }

}
