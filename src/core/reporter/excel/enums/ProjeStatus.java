package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProjeStatus
{
    DEVAM_EDIYOR("Devam Ediyor"), TAMAMLANDI("Tamamlandı");

    private String text;

    ProjeStatus(String text) {
        this.text = text;
    }

    private static final Map<String, ProjeStatus> reverseLookUpMap = new HashMap<>();

    static {
        for (ProjeStatus detay : ProjeStatus.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static ProjeStatus get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
