using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Collections;

public class PhoneExample : MonoBehaviour {

	public Text log;
	AndroidJavaClass UnityPlayer;
	AndroidJavaObject currentActivity;
	AndroidJavaClass PhoneClass;
	
void Start()
	{
		UnityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
		currentActivity = UnityPlayer.GetStatic<AndroidJavaObject>("currentActivity");
		PhoneClass = new AndroidJavaClass("com.john.phoneplugin.PhoneClass");

		currentActivity.Call("runOnUiThread", new AndroidJavaRunnable(() =>
		{
			PhoneClass.CallStatic("ShowToast", currentActivity, "Toast Message");
		}));
	}

	public void OnShowToastClick()
	{
		PhoneClass.CallStatic("ShowToastRunnable", currentActivity, "Show Toast Runnable");
	}
	public void OnShowProgressDialogClick()
	{
		PhoneClass.CallStatic("ShowProgressDialog", currentActivity, "No Message");
	}
	public void OnShowAlertClick()
	{
		PhoneClass.CallStatic("ShowAlert", currentActivity, "No Title", "No Message");
	}
	public void OnPhoneCallClick()
	{
		PhoneClass.CallStatic("PhoneCall", currentActivity, "111-222-333-444");
	}
	public void OnSendSMSClick()
	{
		PhoneClass.CallStatic("SendSMS", currentActivity, "082146274833", "No Message");
	}

	public void OnBackClick()
	{
		SceneManager.LoadScene("MainExample");
	}
	
	public void OnUnitySendMessage(string message)
	{
		log.text += message + "\n";
	}
}
