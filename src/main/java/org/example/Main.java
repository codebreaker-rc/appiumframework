package org.example;

import org.example.core.JsonReader;
import org.json.JSONObject;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        JSONObject jsondata= new JSONObject(JsonReader.parseit("deviceData.json").getJSONObject("Iphone14 Plus").toString());
        System.out.println(jsondata.getString("deviceName"));
    }
}