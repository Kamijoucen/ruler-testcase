package com.kamijoucen.testcase;

import java.util.Map;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BaseTest {

    private static final Gson gson = new Gson();

    @Test
    public void gsonTest() {
        String json = "{\"name\":\"kamijoucen\", list:[1, 2, 3], map:{\"key\":\"value\"}}";
        Map<String, Object> map =
                gson.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
        System.out.println(map);
    }

}
