package core.reporter.excel;

import core.reporter.excel.enums.DefectDetay;
import core.reporter.excel.enums.DefectDurumu;
import core.reporter.excel.enums.GecikmeDurumu;
import core.reporter.excel.enums.ProjeStatus;

public class CommonCells
{
    final String projeAdi;
    final String etkilenenSistem;
    final DefectDetay defectDetay;
    final DefectDurumu defectDurumu;
    final ProjeStatus projeStatus;
    final String pentestContact;
    final String defectSorumlusu;
    final String projeYoneticisi;
    final String direktorluk;
    final String ortam;
    final GecikmeDurumu gecikmeDurumu;
    final String defectTipi;
    final String sirket;

    public CommonCells(String projeAdi, String etkilenenSistem, DefectDetay defectDetay, DefectDurumu defectDurumu, ProjeStatus projeStatus, String pentestContact, String defectSorumlusu, String projeYoneticisi, String direktorluk, String ortam, GecikmeDurumu gecikmeDurumu, String defectTipi, String sirket)
    {
        this.projeAdi = projeAdi;
        this.etkilenenSistem = etkilenenSistem;
        this.defectDetay = defectDetay;
        this.defectDurumu = defectDurumu;
        this.projeStatus = projeStatus;
        this.pentestContact = pentestContact;
        this.defectSorumlusu = defectSorumlusu;
        this.projeYoneticisi = projeYoneticisi;
        this.direktorluk = direktorluk;
        this.ortam = ortam;
        this.gecikmeDurumu = gecikmeDurumu;
        this.defectTipi = defectTipi;
        this.sirket = sirket;
    }
}
