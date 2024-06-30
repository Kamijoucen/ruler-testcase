package com.kamijoucen.testcase.function;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.runtime.RuntimeContext;
import com.kamijoucen.ruler.runtime.Scope;
import com.kamijoucen.ruler.value.BaseValue;

public class RsonFunction implements RulerFunction {

    private static final Gson GSON = new Gson();
    private static final Type TYPE = new TypeToken<Map<String, Object>>() {}.getType();

    @Override
    public Object call(RuntimeContext ctx, Scope scope, BaseValue self, Object... param) {
        if (ArrayUtils.isEmpty(param)) {
            return Collections.emptyList();
        }
        String json = param[0].toString();
        if (StringUtils.isBlank(json)) {
            return Collections.emptyList();
        }
        return GSON.fromJson(json, TYPE);
    }

    @Override
    public String getName() {
        return "Rson";
    }
}
