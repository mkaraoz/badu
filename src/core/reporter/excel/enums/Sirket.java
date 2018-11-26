package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum Sirket
{
    TURK_TELEKOM("Türk Telekom"), TT_NET("TTNET"), AVEA("AVEA"), BOS("");

    private String text;

    Sirket(String text) {
        this.text = text;
    }

    private static final Map<String, Sirket> reverseLookUpMap = new HashMap<>();

    static {
        for (Sirket detay : Sirket.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static Sirket get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
