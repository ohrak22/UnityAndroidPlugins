using UnityEngine;
using UnityEngine.SceneManagement;
using System.Collections;

public class MainExample : MonoBehaviour
{
	public void OnBasicClick()
	{
		SceneManager.LoadScene("BasicExample");
	}

	public void OnOverrideClick()
	{
		SceneManager.LoadScene("OverrideExample");
	}

	public void OnPhoneClick()
	{
		SceneManager.LoadScene("PhoneExample");
	}
}
