package com.mhmind.demo.digital.normal.lib;

import android.os.Bundle;

import com.mhmind.demo.digital.normal.R;
import com.mhmind.ttp.view.TTPActPayGift;

public class ActPayGift extends TTPActPayGift {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttp_act_pay_gift);

        // Initializes inherited member
        cTTPView = new TTPView(this);

        StartTTPActivity();
    }


}