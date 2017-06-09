package com.john.overrideplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.unity3d.player.UnityPlayer;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(R.string.hello_world);

        UnityPlayer.UnitySendMessage("OverrideExample", "OnUnitySendMessage", "SubActivity onCreate");
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = this.getIntent();
        intent.putExtra("key", "Test001");
        setResult(RESULT_OK, intent);
        finish();
    }
}
