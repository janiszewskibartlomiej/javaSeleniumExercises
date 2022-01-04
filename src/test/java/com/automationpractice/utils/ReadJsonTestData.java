package com.automationpractice.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.sun.xml.internal.ws.binding.WebServiceFeatureList.toList;

public class ReadJsonTestData {

    public static Map<String, Object> getJsonObject() {
        JSONParser jsonParser = new JSONParser();
        Map<String, Object> testData = null;
        try {
            Object json = jsonParser.parse(new FileReader("src/test/java/com/automationpractice/testData/testDataAutomationPractice.json"));
            JSONObject jsonObject = (JSONObject) json;
            testData = toMap((JSONObject) jsonObject.get("testData"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;

    }

    public static Map<String, Object> toMap(JSONObject jsonobj) {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonobj.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }
}
