package com.example.ecotour;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class ReadJson {

    public static List<List<HashMap<String, String>>> routes = new ArrayList<List<HashMap<String,String>>>();
    //public static Punto coordenadas = new Punto();

    public static String readJson(Context context, String fileName) throws IOException
    {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName), "UTF-8"));

        String content = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            content = content + line;
        }

        return content;

    }
}
