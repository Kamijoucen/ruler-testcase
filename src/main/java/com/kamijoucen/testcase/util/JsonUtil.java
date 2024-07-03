package com.kamijoucen.testcase.util;

import java.lang.reflect.Type;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

    private static final Gson GSON = new Gson();

    private static final Type TYPE = new TypeToken<Map<String, Object>>() {}.getType();

    public static String toJsonString(Object obj) {
        return GSON.toJson(obj);
    }

    public static Map<String, Object> fromJson(String json) {
        return GSON.fromJson(json, TYPE);
    }

}
