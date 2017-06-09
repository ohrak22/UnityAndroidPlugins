using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class SMSListner : MonoBehaviour {

	public Text log;

	public void OnReceived(string message)
	{
		log.text = message;
	}
}
