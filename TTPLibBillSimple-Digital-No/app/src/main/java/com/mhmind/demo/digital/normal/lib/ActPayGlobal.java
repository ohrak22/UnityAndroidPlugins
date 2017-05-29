package com.mhmind.demo.digital.normal.lib;

import java.util.Locale;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import com.mhmind.demo.digital.normal.R;
import com.mhmind.ttp.view.TTPActPayGlobal;

public class ActPayGlobal extends TTPActPayGlobal {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttp_act_pay_global);

        setLocale("en");

        // Initializes inherited member
        cTTPView = new TTPView(this);

        // Sets title of activity
        TextView tvTitleCenter = (TextView)findViewById(R.id.ttp_tv_title_center);
        tvTitleCenter.setText(R.string.ttp_title_pay_tab);

         StartTTPActivity();
    }

    public void setLocale(String c) {
    	Configuration config = new Configuration();
    	config.locale = new Locale(c);
    	getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

}
