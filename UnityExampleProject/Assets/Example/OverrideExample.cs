using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Collections;

public class OverrideExample : MonoBehaviour {

	public Text log;
	AndroidJavaClass UnityPlayer;
	AndroidJavaObject currentActivity;

	void Start()
	{
		log.text = "";

		UnityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
		currentActivity = UnityPlayer.GetStatic<AndroidJavaObject>("currentActivity");
	}

	public void OnLaunchActivity()
	{
		currentActivity.Call("LaunchActivity");
	}

	public void OnLaunchActivityForResult()
	{
		currentActivity.Call("LaunchActivityForResult");
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
