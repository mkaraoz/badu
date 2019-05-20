package core.reporter.enums;

import java.util.HashMap;
import java.util.Map;

public enum Category
{
    // WEB
    INFO_GATHER("Bilgi Toplama"),
    CONFIGURATION("Konfigürasyon"),
    ID("Kimlik Doğrulama"),
    AUTH("Yetkilendirme"),
    SESSION("Oturum Yönetimi"),
    INPUT_VALIDATION("Girdi Kontrolü"),
    CRYPTO("Kripto"),
    ERROR_HANDLING("Hata Ayıklama"),
    LOGIC("İş Mantığı"),

    // MOBİL
    ARCHITECTURE("Mimari"),
    DATA_STORAGE("Veri Saklama"),
    NETWORK_COMM("Ağ İletişimi"),
    PLATFORM("Platform Kullanımı"),
    CODE_QUALITY("Kod Kalitesi"),

    // OTHER
    OTHER("Diğer");

    private String name;
    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return  name;
    }

    private static final Map<String, Category> reverseLookUpMap = new HashMap<>();

    static {
        for (Category category : Category.values()) {
            reverseLookUpMap.put(category.name, category);
        }
    }

    public static Category get(String name) {
        return reverseLookUpMap.get(name);
    }
}
