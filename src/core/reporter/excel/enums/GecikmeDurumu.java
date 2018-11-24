package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum GecikmeDurumu
{
    VAR("Var"), YOK("Yok");

    private String text;

    GecikmeDurumu(String text) {
        this.text = text;
    }

    private static Map<String, GecikmeDurumu> reverseLookUpMap = new HashMap<>();

    static {
        for (GecikmeDurumu detay : GecikmeDurumu.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static GecikmeDurumu get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
