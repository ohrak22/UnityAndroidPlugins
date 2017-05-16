using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class BasicPluginExample : MonoBehaviour
{
	private static AndroidJavaClass javaClass;

	public Text log;

	void Start () {

		javaClass = new AndroidJavaClass("com.john.basic.PluginClass");
		AndroidJavaObject obj = new AndroidJavaObject("com.john.basic.PluginClass");

		javaClass.CallStatic("SetStaticInt", 10);
		int num1 = javaClass.CallStatic<int>("GetStaticInt");

		obj.Call("SetInt", 20);
		int num2 = obj.Call<int>("GetInt");

		log.text = "CallStatic<int>: " + num1;
		log.text += "\nobj.Call<int>: " + num2;

	}
}
