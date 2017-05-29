package com.mhmind.demo.digital.normal.lib;

import java.util.Locale;

import android.content.res.Configuration;
import android.os.Bundle;

import com.mhmind.ttp.core.CoreUtil;
import com.mhmind.ttp.view.TTPActDigitalMain;

import com.mhmind.demo.digital.normal.R;

public class ActDigitalMain extends TTPActDigitalMain {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String curLanguage = getIntent().getStringExtra("PARAM_COUNTRY");
        String cpSeq  = getIntent().getStringExtra("CP_SEQ");
        String appSeq = getIntent().getStringExtra("APP_SEQ");

        if (!CoreUtil.isNull(cpSeq)) {
        	TTPView.setCPSEQ(cpSeq);
        }
        if (!CoreUtil.isNull(appSeq)) {
        	TTPView.setAPPSEQ(appSeq);
        }

        if (CoreUtil.isNull(curLanguage)) {
            curLanguage = CoreUtil.getLocale(getApplicationContext());
        }

        if (curLanguage.equalsIgnoreCase("kr")) {
            setLocale("ko");
        } else {
            setLocale("en");
        }

        setContentView(R.layout.ttp_act_bs_main);
        cTTPView = new TTPView(this);
        StartTTPActivity();
    }

    public void setLocale(String c) {
    	Configuration config = new Configuration();
    	config.locale = new Locale(c);
    	getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}
