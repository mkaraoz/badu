package core.reporter.excel; 

public class CommonCells
{
    final String projeAdi;
    final String uygulamaOrtami;
    final String etkilenenSistem;
    final String sirket;
    final String pentestContact;
    final String defectSorumlusu;
    final String projeYoneticisi;
    final String sorumluDirektorluk;
    final String ortam;
    final String defectTipi;   

    public CommonCells( String projeAdi, 
                        String uygulamaOrtami,
                        String etkilenenSistem, 
                        String sirket,
                        String pentestContact,
                        String defectSorumlusu,
                        String projeYoneticisi, 
                        String sorumluDirektorluk, 
                        String ortam,   
                        String defectTipi)
    {
        this.projeAdi = projeAdi;
        this.uygulamaOrtami = uygulamaOrtami;
        this.etkilenenSistem = etkilenenSistem; 
        this.sirket = sirket;
        this.pentestContact = pentestContact;
        this.defectSorumlusu = defectSorumlusu;
        this.projeYoneticisi = projeYoneticisi; 
        this.sorumluDirektorluk = sorumluDirektorluk;
        this.ortam = ortam; 
        this.defectTipi = defectTipi;
    }
}
