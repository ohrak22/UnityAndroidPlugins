using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Collections;

public class BasicExample : MonoBehaviour
{
	public Text log;
	AndroidJavaClass PluginClass;

	void Start ()
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

		// UnitySendMessage.
		PluginObj.Call("Call");
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
