package core.reporter.excel.enums;

import java.util.HashMap;
import java.util.Map;

public enum DefectDetay
{
    PROD_DEFECT("Prod Defect"), TEST_DEFECT("Test Defect");

    private String text;

    DefectDetay(String text) {
        this.text = text;
    }

    private static final Map<String, DefectDetay> reverseLookUpMap = new HashMap<>();

    static {
        for (DefectDetay detay : DefectDetay.values()) {
            reverseLookUpMap.put(detay.text, detay);
        }
    }

    public static DefectDetay get(String text) {
        return reverseLookUpMap.get(text);
    }

    public String getText() {
        return text;
    }
}
