package com.kamijoucen.testcase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.kamijoucen.ruler.Ruler;
import com.kamijoucen.ruler.config.impl.RulerConfigurationImpl;
import com.kamijoucen.ruler.module.RulerRunner;

public class Main {

    private final static RulerConfigurationImpl configuration = new RulerConfigurationImpl();
    static {
        configuration.setMaxStackDepth(100);
        configuration.setMaxLoopNumber(10000);
    }

    public static void main(String[] args) throws IOException {
        if (ArrayUtils.isEmpty(args)) {
            System.out.println("args is empty");
            return;
        }
        String filePath = args[0];
        if (StringUtils.isBlank(filePath)) {
            System.out.println("file path is empty");
            return;
        }
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        RulerRunner runner = Ruler.compileScript(new String(bytes), configuration);
        runner.run();
    }
}
