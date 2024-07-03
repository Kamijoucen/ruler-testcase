package com.kamijoucen.testcase.function;

import org.apache.commons.lang3.ArrayUtils;
import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.runtime.RuntimeContext;
import com.kamijoucen.ruler.runtime.Scope;
import com.kamijoucen.ruler.value.BaseValue;
import com.kamijoucen.testcase.util.JsonUtil;

public class ToJsonStringFunction implements RulerFunction {

    @Override
    public Object call(RuntimeContext context, Scope scope, BaseValue self, Object... params) {
        if (ArrayUtils.isEmpty(params)) {
            return "";
        }
        return JsonUtil.toJsonString(params[0]);
    }

    @Override
    public String getName() {
        return "ToJsonString";
    }
}
