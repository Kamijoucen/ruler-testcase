package com.kamijoucen.testcase.function;

import java.util.Collections;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.kamijoucen.ruler.function.RulerFunction;
import com.kamijoucen.ruler.runtime.RuntimeContext;
import com.kamijoucen.ruler.runtime.Scope;
import com.kamijoucen.ruler.value.BaseValue;
import com.kamijoucen.testcase.util.JsonUtil;

public class RsonFunction implements RulerFunction {

    @Override
    public Object call(RuntimeContext ctx, Scope scope, BaseValue self, Object... param) {
        if (ArrayUtils.isEmpty(param)) {
            return Collections.emptyList();
        }
        String json = param[0].toString();
        if (StringUtils.isBlank(json)) {
            return Collections.emptyList();
        }
        return JsonUtil.fromJson(json);
    }

    @Override
    public String getName() {
        return "Rson";
    }
}
