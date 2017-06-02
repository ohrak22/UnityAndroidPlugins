package com.john.overrideplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

import com.unity3d.player.UnityPlayer;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UnityPlayer.UnitySendMessage("OverrideExample", "OnUnitySendMessage", "SubActivity onCreate");

        //setContentView(R.layout.activity_sub);
        Resources res = getResources();
        int layoutId = res.getIdentifier("activity_sub", "layout", getPackageName());
        setContentView(layoutId);

        int strId = res.getIdentifier("test_string", "string", getPackageName());
        String str = res.getString(strId);

        int viewId = res.getIdentifier("textView", "id", getPackageName());
        TextView textView = (TextView)findViewById(viewId);
        textView.setText(strId);

        UnityPlayer.UnitySendMessage("OverrideExample", "OnUnitySendMessage", str);

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
