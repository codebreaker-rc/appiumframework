package org.example.core;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class JsonReader {

    public static JSONObject parseit(String filename){
        InputStream inputStream = JsonReader.class.getClassLoader().getResourceAsStream(filename);
        assert inputStream != null;
        return new JSONObject(new JSONTokener(inputStream));
    }
}
