package core.reporter.enums;

import java.util.HashMap;
import java.util.Map;

public enum Domain
{
    WEB("Web"), MOBILE("Mobil"), SERVICE("Web Servis") ;

    private String name;
    Domain(String name) {
        this.name = name;
    }

    public String getName() {
        return  name;
    }

    private static final Map<String, Domain> reverseLookUpMap = new HashMap<>();

    static {
        for (Domain domain : Domain.values()) {
            reverseLookUpMap.put(domain.name, domain);
        }
    }

    public static Domain get(String name) {
        return reverseLookUpMap.get(name);
    }
}
