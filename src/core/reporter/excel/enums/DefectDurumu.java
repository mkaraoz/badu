package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum DefectDurumu
{
    ACIK("Açık"), KAPALI("Kapalı"), DOGRULAMA_BEKLIYOR("Doğrulama Bekliyor");

    private String text;

    DefectDurumu(String text) {
        this.text = text;
    }

    private static Map<String, DefectDurumu> reverseLookUpMap = new HashMap<>();

    static {
        for (DefectDurumu detay : DefectDurumu.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static DefectDurumu get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
