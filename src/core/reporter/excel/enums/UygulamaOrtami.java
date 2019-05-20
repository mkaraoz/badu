package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum UygulamaOrtami
{
    PROJE_TEST("Proje Test"),
    PCI("PCI"), 
    KRITIK_SISTEM("Kritik Sistem"), 
    INTERNETE_ACIK("İnternete Açık"); 

    private String text;

    UygulamaOrtami(String text) {
        this.text = text;
    }

    private static final Map<String, UygulamaOrtami> reverseLookUpMap = new HashMap<>();

    static {
        for (UygulamaOrtami detay : UygulamaOrtami.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static UygulamaOrtami get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
