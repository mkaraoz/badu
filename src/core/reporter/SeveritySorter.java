package core.reporter;

import core.reporter.enums.Severity;
import java.util.ArrayList;
import java.util.List;

public class SeveritySorter {

    public static void stupidSort(List<Vulnerability> vulnerabilities)
    {
        List<Vulnerability> sorted = new ArrayList<>();
        for (Vulnerability vuln : vulnerabilities)
        {
            if (vuln.getSeverity().equals(Severity.ACIL))
                sorted.add(vuln);
        }

        for (Vulnerability vuln : vulnerabilities)
        {
            if (vuln.getSeverity().equals(Severity.KRITIK))
                sorted.add(vuln);
        }

        for (Vulnerability vuln : vulnerabilities)
        {
            if (vuln.getSeverity().equals(Severity.YUKSEK))
                sorted.add(vuln);
        }

        for (Vulnerability vuln : vulnerabilities)
        {
            if (vuln.getSeverity().equals(Severity.ORTA))
                sorted.add(vuln);
        }

        for (Vulnerability vuln : vulnerabilities)
        {
            if (vuln.getSeverity().equals(Severity.DUSUK))
                sorted.add(vuln);
        }

        vulnerabilities.clear();
        vulnerabilities.addAll(sorted);
    }
}
