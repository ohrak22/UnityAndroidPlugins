package com.mhmind.demo.digital.normal.lib;

import android.os.Bundle;

import com.mhmind.demo.digital.normal.R;
import com.mhmind.ttp.view.TTPActPayPhoneWeb;

public class ActPayPhoneWeb extends TTPActPayPhoneWeb {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttp_act_web);

        // Initializes inherited member
        cTTPView = new TTPView(this);

        StartTTPActivity();
    }

}