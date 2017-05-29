package com.mhmind.demo.digital.normal.lib;

import java.lang.reflect.Field;

import android.content.Context;
import android.content.Intent;

import com.mhmind.demo.digital.normal.R;
import com.mhmind.ttp.view.TTPViews;

/**
 * TTP에서 사용되는 뷰 생성.
 */
public class TTPView extends TTPViews {
	static String CPSEQ = "2";
	static String APPSEQ = "35";

	final int INTENT_ACT_PAYMENT_RESULT = 11;
	final int INTENT_ACT_SETTING = 15;
	final int INTENT_ACT_WEB = 17;

	final int INTENT_ACT_PAY_TAB = 99;
	final int INTENT_ACT_PAY_PHONE = 100;
	final int INTENT_ACT_PAY_PHONE_WEB = 1011;
	final int INTENT_ACT_PAY_GIFT = 102;
	final int INTENT_ACT_PAY_CULTURE = 103;
	final int INTENT_ACT_PAY_GAME = 104;
	final int INTENT_ACT_PAY_BOOK = 105;
	final int INTENT_ACT_PAY_HAPPY = 106;
	final int INTENT_ACT_PAY_TEENCASH = 107;
	final int INTENT_ACT_PAY_ONCASH = 108;
	final int INTENT_ACT_PAY_CARD = 110;
	final int INTENT_ACT_PAY_PAYPAL = 111;
	final int INTENT_ACT_PAY_EGGMONEY = 112;
	final int INTENT_ACT_PAY_CARD_GLOBAL = 113;
	final int INTENT_ACT_PAY_MOL = 114;
	final int INTENT_ACT_PAY_CHERRY = 119;
	final int INTENT_ACT_PAY_GLOBAL = 120;
	final int INTENT_ACT_PAY_MYCARD = 121;
	final int INTENT_ACT_PAY_MYCARD_INGAME = 124;
	final int INTENT_ACT_PAY_MOL_COUPON = 125;

	final int INTENT_ACT_DIGITAL_MAIN = 126;
	final int INTENT_ACT_PAY_GUDANG = 127;
	final int INTENT_ACT_PAY_GAMEON = 128;
	final int INTENT_ACT_PAY_UNIPIN = 129;
	final int INTENT_ACT_PAY_PAYLETTER_PHONE = 130;
	final int INTENT_ACT_PAY_VTC = 132;

	/**
	 * Constructor.
	 */
	public TTPView(Context pContext) {
		super(pContext);
		SetCp(CPSEQ);
		SetApp(APPSEQ);

		// Get resource
		for (Field cField : R.id.class.getDeclaredFields()) {
			try {
				if (cField.getName().startsWith("ttp_"))
					hmRID.put(cField.getName(), cField.getInt(cField.getName()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		for (Field cField : R.layout.class.getDeclaredFields()) {
			try {
				if (cField.getName().startsWith("ttp_"))
					hmRLayout.put(cField.getName(), cField.getInt(cField.getName()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		for (Field cField : R.drawable.class.getDeclaredFields()) {
			try {
				if (cField.getName().startsWith("ttp_"))
					hmRDrawable.put(cField.getName(), cField.getInt(cField.getName()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		for (Field cField : R.string.class.getDeclaredFields()) {
			try {
				if (cField.getName().startsWith("ttp_"))
					hmRString.put(cField.getName(), cField.getInt(cField.getName()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static String getAPPSEQ() {
		return APPSEQ;
	}

	public static void setAPPSEQ(String aPPSEQ) {
		APPSEQ = aPPSEQ;
	}

	public static String getCPSEQ() {
		return CPSEQ;
	}

	public static void setCPSEQ(String cPSEQ) {
		CPSEQ = cPSEQ;
	}

	/**
	 * 인텐트 목록 - 가져오기
	 */
	@Override
	public Intent GetIntent(int pActivity) {
		Intent intent = null;
		switch (pActivity) {
		case INTENT_ACT_DIGITAL_MAIN:
			intent = new Intent(cContext, ActDigitalMain.class);
			break;
		case INTENT_ACT_PAYMENT_RESULT:
			intent = new Intent(cContext, ActPaymentResult.class);
			break;
		case INTENT_ACT_SETTING:
			intent = new Intent(cContext, ActSetting.class);
			break;
		case INTENT_ACT_WEB:
			intent = new Intent(cContext, ActWeb.class);
			break;
		case INTENT_ACT_PAY_PHONE:
			intent = new Intent(cContext, ActPayPhone.class);
			break;
		case INTENT_ACT_PAY_PHONE_WEB:
			intent = new Intent(cContext, ActPayPhoneWeb.class);
			break;
		case INTENT_ACT_PAY_GIFT:
			intent = new Intent(cContext, ActPayGift.class);
			break;
		case INTENT_ACT_PAY_CULTURE:
			intent = new Intent(cContext, ActPayCulture.class);
			break;
		case INTENT_ACT_PAY_GAME:
			intent = new Intent(cContext, ActPayGame.class);
			break;
		case INTENT_ACT_PAY_BOOK:
			intent = new Intent(cContext, ActPayBook.class);
			break;
		case INTENT_ACT_PAY_HAPPY:
			intent = new Intent(cContext, ActPayHappy.class);
			break;
		case INTENT_ACT_PAY_TEENCASH:
			intent = new Intent(cContext, ActPayTeencash.class);
			break;
		case INTENT_ACT_PAY_ONCASH:
			intent = new Intent(cContext, ActPayOncash.class);
			break;
		case INTENT_ACT_PAY_CARD:
			intent = new Intent(cContext, ActPayCard.class);
			break;
		case INTENT_ACT_PAY_EGGMONEY:
			intent = new Intent(cContext, ActPayEggmoney.class);
			break;
		case INTENT_ACT_PAY_PAYPAL:
			intent = new Intent(cContext, ActPayPaypal.class);
			break;
		case INTENT_ACT_PAY_CARD_GLOBAL:
			intent = new Intent(cContext, ActPayCardGlobal.class);
			break;
		case INTENT_ACT_PAY_MOL:
			intent = new Intent(cContext, ActPayMol.class);
			break;
		case INTENT_ACT_PAY_CHERRY:
			intent = new Intent(cContext, ActPayCherry.class);
			break;
		case INTENT_ACT_PAY_MYCARD:
			intent = new Intent(cContext, ActPayMyCard.class);
			break;
		case INTENT_ACT_PAY_GLOBAL:
			intent = new Intent(cContext, ActPayGlobal.class);
			break;
		case INTENT_ACT_PAY_TAB:
			intent = new Intent(cContext, ActPayTab.class);
			break;
		case INTENT_ACT_PAY_MYCARD_INGAME:
			intent = new Intent(cContext, ActPayMyCardInGame.class);
			break;
		case INTENT_ACT_PAY_MOL_COUPON:
			intent = new Intent(cContext, ActPayMolCoupon.class);
			break;
		case INTENT_ACT_PAY_GAMEON:
			intent = new Intent(cContext, ActPayGameOn.class);
			break;
		case INTENT_ACT_PAY_GUDANG:
			intent = new Intent(cContext, ActPayGudangVoucher.class);
			break;
		case INTENT_ACT_PAY_UNIPIN:
			intent = new Intent(cContext, ActPayUniPin.class);
			break;
		case INTENT_ACT_PAY_PAYLETTER_PHONE:
			intent = new Intent(cContext, ActPayPayletterPhone.class);
			break;
		case INTENT_ACT_PAY_VTC:
			intent = new Intent(cContext, ActPayVtc.class);
			break;
		}

		return intent;
	}

	@Override
	public void PayProcess(String pResultCode, String pOrderNo, String pAppParam, String pAppInCrcyPrc) {
		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
