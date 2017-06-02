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

	public void OnPhoneCall()
	{
		PhoneClass.CallStatic("PhoneCall", currentActivity, "111-222-333-444");
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
