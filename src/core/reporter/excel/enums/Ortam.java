package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum Ortam
{
    TEST("Test"), PROD("Prod"), PRE_PROD("Pre Prod");

    private String text;

    Ortam(String text) {
        this.text = text;
    }

    private static Map<String, Ortam> reverseLookUpMap = new HashMap<>();

    static {
        for (Ortam detay : Ortam.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static Ortam get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
