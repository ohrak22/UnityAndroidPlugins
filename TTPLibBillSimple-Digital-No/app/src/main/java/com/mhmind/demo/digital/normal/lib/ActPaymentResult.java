package com.mhmind.demo.digital.normal.lib;

import android.os.Bundle;
import android.widget.TextView;

import com.mhmind.demo.digital.normal.R;
import com.mhmind.ttp.view.TTPActPaymentResult;

public class ActPaymentResult extends TTPActPaymentResult {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttp_act_bs_payment_result);

        // Initializes inherited member
        cTTPView = new TTPView(this);

		// Sets title of activity
		TextView tvTitleCenter = (TextView)findViewById(R.id.ttp_tv_title_center);
        tvTitleCenter.setText(R.string.ttp_title_payment);

        StartTTPActivity();
    }

}