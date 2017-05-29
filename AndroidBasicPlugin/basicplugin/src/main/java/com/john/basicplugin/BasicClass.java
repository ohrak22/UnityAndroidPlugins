package com.john.basicplugin;

public class BasicClass {

    private static int g_num = 0;
    private String str = "";

    public static void SetIntStatic(int num){
        g_num = num;
    }

    public static int GetIntStatic(){
        return g_num;
    }

    public void SetString(String str){
        this.str = str;
    }

    public String GetString(){
        return str;
    }

}
