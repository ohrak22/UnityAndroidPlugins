package com.mhmind.demo.digital.normal.lib;

import android.os.Bundle;

import com.mhmind.demo.digital.normal.R;
import com.mhmind.ttp.view.TTPActPayCardPaygate;

public class ActPayCard extends TTPActPayCardPaygate {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttp_act_pay_card);

        // Initializes inherited member
        cTTPView = new TTPView(this);

        StartTTPActivity();
    }
}