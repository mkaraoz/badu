package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum DefectTipi
{
    TEST_DEFECT("Test Defect"), 
    PROD_DEFECT("Prod Defect"),
    BOS("");

    private String text;

    DefectTipi(String text) {
        this.text = text;
    }

    private static Map<String, DefectTipi> reverseLookUpMap = new HashMap<>();

    static {
        for (DefectTipi detay : DefectTipi.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static DefectTipi get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
