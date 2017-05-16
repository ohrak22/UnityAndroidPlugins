package com.john.basic;

/**
 * Created by John Park on 2017-05-16.
 */

public class PluginClass
{
    private static int g_num;
    private int num;

    public static void SetStaticInt(int a)
    {
        g_num = a;
    }

    public static int GetStaticInt()
    {
        return g_num;
    }

    public void SetInt(int a)
    {
        num = a;
    }

    public int GetInt()
    {
        return num;
    }

}
