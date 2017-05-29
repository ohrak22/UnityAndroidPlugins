package com.mhmind.demo.digital.normal;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mhmind.demo.digital.normal.lib.ActDigitalMain;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */

    String pCode  = "90457A4C8F7280D5A1799B3A18E0E7CD79";  // 피자한판

    /**
     * pCode 는 관리자에서 생성된 상품코드 번호
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout ll = (LinearLayout)findViewById(R.id.main);

        // 기본결제
        Button payBasic = new Button(this);
        payBasic.setText("기본 결제(국내)");
        payBasic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);
                    intent.putExtra("CP_SEQ", "2");
            		intent.putExtra("APP_SEQ", "1");
                    intent.putExtra("PARAM_COUNTRY", "KR");
                    intent.putExtra("PARAM_VALUE", "90BDDFE973735AF594C5DB76B924DFDDC4");
                    intent.putExtra("APP_PARAM", "a_" + System.currentTimeMillis());

                    startActivityForResult(intent, 1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button payBtn = new Button(this);
        payBtn.setText("US 결제 ");
        payBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);

                intent.putExtra("PARAM_VALUE", pCode);
                intent.putExtra("PARAM_COUNTRY", "US");
                intent.putExtra("APP_PARAM", "a_" + System.currentTimeMillis());

                startActivityForResult(intent, 1);
            }
        });

        Button payBtn2 = new Button(this);
        payBtn2.setText("말레이시아 결제 ");
        payBtn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);

                intent.putExtra("PARAM_VALUE", pCode);
                intent.putExtra("PARAM_COUNTRY", "MY");
                intent.putExtra("APP_PARAM", "a_" + System.currentTimeMillis());

                startActivityForResult(intent, 1);
            }
        });

        Button payBtn3 = new Button(this);
        payBtn3.setText("싱가포르 결제 ");
        payBtn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);

                intent.putExtra("PARAM_VALUE", pCode);
                intent.putExtra("PARAM_COUNTRY", "SG");
                intent.putExtra("APP_PARAM", "a_" + System.currentTimeMillis());

                startActivityForResult(intent, 1);
            }
        });

        Button payBtn4 = new Button(this);
        payBtn4.setText("대만 결제 ");
        payBtn4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);

                intent.putExtra("PARAM_VALUE", pCode);
                intent.putExtra("PARAM_COUNTRY", "TW");
                intent.putExtra("APP_PARAM", "a_" + System.currentTimeMillis());

                startActivityForResult(intent, 1);
            }
        });

        Button payBtn5 = new Button(this);
        payBtn5.setText("앱 충전 방식 결제 ");
        payBtn5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);

                intent.putExtra("PARAM_VALUE", "929BC04A92DB6CB23218EB1046800CB9AD"); // App Seq 피자앱해외
                intent.putExtra("PARAM_COUNTRY", "");
                intent.putExtra("APP_PARAM", "a_" + System.currentTimeMillis());
                startActivityForResult(intent, 1);
            }
        });

        Button payBtn7 = new Button(this);
        payBtn7.setText("인도네시아 결제");
        payBtn7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);

                intent.putExtra("PARAM_VALUE", pCode);
                intent.putExtra("PARAM_COUNTRY", "ID");
                intent.putExtra("APP_PARAM", "a_" + System.currentTimeMillis());

                startActivityForResult(intent, 1);

			}
		});

        Button payBtn9 = new Button(this);
        payBtn9.setText("쿠폰 결제");
        payBtn9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, ActDigitalMain.class);

                intent.putExtra("CP_SEQ", "2");
        		intent.putExtra("APP_SEQ", "35");
                intent.putExtra("PARAM_COUNTRY", "KR");

                // 쿠폰
                intent.putExtra("USE_COUPONMODE", "Y");
                intent.putExtra("APP_PARAM", "coupon_" + System.currentTimeMillis());

                startActivityForResult(intent, 2);
			}
		});

        ll.addView(payBasic);
        ll.addView(payBtn);
        ll.addView(payBtn2);
        ll.addView(payBtn3);
        ll.addView(payBtn4);
        ll.addView(payBtn7);
        ll.addView(payBtn5);
        ll.addView(payBtn9);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, 0, 0, "Version");

    	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	switch (item.getItemId()) {
		case 0:
			try {
				PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);

				Toast.makeText(MainActivity.this, pInfo.versionName.trim(), Toast.LENGTH_SHORT).show();
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}

			return true;
		}

    	return false;
    }

    /**
     * 결과 리턴
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String payResult = intent.getStringExtra("RESULT_CODE"); // 100이면 결제성공
                String payOrderNo = intent.getStringExtra("ORDER_NO");
                String payAppParam = intent.getStringExtra("APP_PARAM");
                String payAppInCrcyPrc = intent.getStringExtra("APP_IN_CRCY_PRC");

                if (payAppInCrcyPrc == null || payAppInCrcyPrc.equals("")){
                    Toast.makeText(getApplicationContext(), "Success RESULT - " + payResult + ", ORDERNO - " + payOrderNo + ", APP_PARAM - " + payAppParam, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Success RESULT - " + payResult + ", ORDERNO - " + payOrderNo + ", APP_PARAM - " + payAppParam + ", APP_IN_CRCY_PRC - " + payAppInCrcyPrc, Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(getApplicationContext(), "Failure payment", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 2) { // 쿠폰인 경우
            if (resultCode == RESULT_OK) {
                String payResult = intent.getStringExtra("RESULT_CODE"); // 100이면 결제성공
                String payOrderNo = intent.getStringExtra("ORDER_NO");
                String payAppParam = intent.getStringExtra("APP_PARAM");
                String newCouponSeq = intent.getStringExtra("COUPON_SEQ");
                String newItemSeqEnc = intent.getStringExtra("ITEM_SEQ_ENC");
                String newItemName = intent.getStringExtra("ITEM_NAME");
                String newAppSeqEnc = intent.getStringExtra("APP_SEQ_ENC");
                String newAppInCrcyPrc = intent.getStringExtra("APP_IN_CRCY_PRC");
                String newCouponHashData = intent.getStringExtra("COUPON_HASH_DATA");

                Toast.makeText(
                        getApplicationContext(),
                        "Success coupon RESULT -" + payResult + ", ORDERNO - " + payOrderNo + ", APP_PARAM - " + payAppParam + ", COUPON_SEQ - " + newCouponSeq + ", ITEM_SEQ_ENC - " + newItemSeqEnc
                                + ", ITEM_NAME - " + newItemName + ", APP_SEQ_ENC = " + newAppSeqEnc + ", APP_IN_CRCY_PRC = " + newAppInCrcyPrc + ", COUPON_HASH_DATA = " + newCouponHashData, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Failure coupon", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void setLocale(String c) {
    	Configuration config = new Configuration();
    	config.locale = new Locale(c);
    	getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}
