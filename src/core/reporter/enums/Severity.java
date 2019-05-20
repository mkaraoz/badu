package core.reporter.enums;

import core.reporter.TTColor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mk on 15.09.2018.
 */
public enum Severity  {
    ACIL    ("ACİL"  ,  TTColor.URGENT_RED    , TTColor.URGENT_RED      ),
    KRITIK  ("KRİTİK",  TTColor.CRITICAL_RED  , TTColor.CRITICAL_RED    ),
    YUKSEK  ("YÜKSEK",  TTColor.HIGH_RED      , TTColor.HIGH_RED        ),
    ORTA    ("ORTA"  ,  TTColor.MID_YELLOW    , TTColor.MID_YELLOW      ),
    DUSUK   ("DÜŞÜK" ,  TTColor.BLUE          , TTColor.LOW_YELLOW_2    );

    private String name;
    private final String reportColor;
    private final String chartColor;

    Severity(String name, String reportColor, String chartColor) {
        this.name = name;
        this.reportColor = reportColor;
        this.chartColor = chartColor;
    }

    public String getName() {
        return  name;
    }

    public String reportColor() {
        return reportColor;
    }

    public String chartColor() {
        return chartColor;
    }

    private static final Map<String, Severity> reverseLookUpMap = new HashMap<>();

    static {
        for (Severity severity : Severity.values()) {
            reverseLookUpMap.put(severity.name, severity);
        }
    }

    public static Severity get(String name) {
        return reverseLookUpMap.get(name);
    }
}
