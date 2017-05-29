using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class BasicPluginExample : MonoBehaviour
{
	public Text log;
	AndroidJavaClass UnityPlayer;
	AndroidJavaObject currentActivity;

	void Start ()
	{
		UnityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
		currentActivity = UnityPlayer.GetStatic<AndroidJavaObject>("currentActivity");

		CallBasicClass();

		CallPluginClass();
	}

	private void CallBasicClass()
	{
		// Call Static.
		AndroidJavaClass PluginClass = new AndroidJavaClass("com.john.basicplugin.BasicClass");
		PluginClass.CallStatic("SetIntStatic", 10);
		int num = PluginClass.CallStatic<int>("GetIntStatic");

		// Call.
		AndroidJavaObject PluginObj = new AndroidJavaObject("com.john.basicplugin.BasicClass");
		PluginObj.Call("SetString", "Test001");
		string str = PluginObj.Call<string>("GetString");

		log.text = num + "\n";
		log.text += str + "\n";
	}

	private void CallPluginClass()
	{
		AndroidJavaClass PluginClass = new AndroidJavaClass("com.john.basicplugin.PluginClass");

		currentActivity.Call("runOnUiThread", new AndroidJavaRunnable(() =>
		{
			PluginClass.CallStatic("ShowToast", currentActivity, "Toast Message");
		}));

	}

	public void OnLaunchActivity()
	{
		currentActivity.Call("LaunchActivity");
	}

	public void OnLaunchActivityForResult()
	{
		currentActivity.Call("LaunchActivityForResult");
	}

	public void OnUnitySendMessage(string message)
	{
		log.text += message + "\n";
	}

}
