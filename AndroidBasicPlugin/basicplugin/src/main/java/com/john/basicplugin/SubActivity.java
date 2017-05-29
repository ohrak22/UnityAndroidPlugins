package com.john.basicplugin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unity3d.player.UnityPlayer;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub);

        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                0.0F);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setBackgroundColor(Color.WHITE);

        TextView textView = new TextView(this);
        textView.setText("Hello world");
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                0.0F);
        textView.setLayoutParams(textViewParams);
        textView.setTextColor(Color.BLACK);

        layout.addView(textView);

        setContentView(layout);

        UnityPlayer.UnitySendMessage("BasicPluginExample", "OnUnitySendMessage", "SubActivity onCreate");
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
