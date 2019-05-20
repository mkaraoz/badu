package core.reporter.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.reporter.Vulnerability;

import java.io.File;
import java.time.temporal.WeekFields;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import tt.badu.ui.master.UpdateCallback;

public class Excel
{
    public static final int COLUMN_COUNT = 27; //starts from one
    
    public static void createExcelSummary(final CommonCells cells, final List<Vulnerability> vulnerabilityList, File rootFolder, UpdateCallback updater) throws IOException
    {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("./base/bulgu-ozeti.xlsx"));
        
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = localDate.get(weekFields.weekOfWeekBasedYear());

        List<RowData> rowList = new ArrayList<>();

        for (Vulnerability v : vulnerabilityList)
        {
            RowData rowData = new RowData();

            rowData.setYil(year);

            rowData.setAy(month);

            rowData.setHafta(weekNumber);

            rowData.setProjeAdi(cells.projeAdi);

            rowData.setAcilanDefectler(v.getTitle());

            rowData.setDefectSeviyesi(v.getSeverity().getName());
            
            rowData.setUygulamaOrtami(cells.uygulamaOrtami);

            rowData.setEtkilenenSistemler(cells.etkilenenSistem);

            rowData.setDefectDetayi("");

            rowData.setDefectDurumu("Açık");

            rowData.setDefectAciklamasi("");

            rowData.setDefectAdedi(1);

            rowData.setSirket(cells.sirket);

            rowData.setProjeStatu("Tamamlandı");

            rowData.setPentestContact(cells.pentestContact);

            rowData.setDefectSorumlusu(cells.defectSorumlusu);

            rowData.setProjeYoneticisi(cells.projeYoneticisi);

            rowData.setSorumluDirektorluk(cells.sorumluDirektorluk);

            rowData.setDefectNo("");

            rowData.setTalepNo("");

            rowData.setTekrarEden("");

            rowData.setOrtam(cells.ortam);

            rowData.setDefectTarihi("");

            rowData.setGecikmeDurumu("Yok");

            rowData.setDefectTipi(cells.defectTipi);

            rowData.setAciklama("");

            rowData.setRaporVarMi("Evet");

            rowList.add(rowData);
        }

        Sheet sheetAll = wb.getSheetAt(0);
        wb.setSheetName(0, "ALL");
        Sheet sheetToday = wb.getSheetAt(1);
        wb.setSheetName(1, String.valueOf(year));

        for (int i = 0; i < rowList.size(); i++)
        {
            Row rowAll = sheetAll.createRow(i + 1);
            Row rowToday = sheetToday.createRow(i + 1);
            
            List<Cell> rowAllCells = new ArrayList<>();
            List<Cell> rowTodayCells = new ArrayList<>();
            
            for(int c = 0; c < COLUMN_COUNT; c++) {
                rowAllCells.add(rowAll.createCell(c));
                rowTodayCells.add(rowToday.createCell(c));
            }

            RowData all = rowList.get(i);

            rowAllCells.get(TARIH).setCellValue(all.getYil());
            rowTodayCells.get(TARIH).setCellValue(all.getYil()); 

            rowAllCells.get(AY).setCellValue(all.getAy()); 
            rowTodayCells.get(AY).setCellValue(all.getAy());

            rowAllCells.get(HAFTA).setCellValue(all.getHafta()); 
            rowTodayCells.get(HAFTA).setCellValue(all.getHafta());

            rowAllCells.get(PROJE_ADI).setCellValue(all.getProjeAdi());
            rowTodayCells.get(PROJE_ADI).setCellValue(all.getProjeAdi());

            rowAllCells.get(ACILAN_DEFECTLER).setCellValue(all.getAcilanDefectler());
            rowTodayCells.get(ACILAN_DEFECTLER).setCellValue(all.getAcilanDefectler());

            rowAllCells.get(DEFECT_SEVIYESI).setCellValue(all.getDefectSeviyesi());
            rowTodayCells.get(DEFECT_SEVIYESI).setCellValue(all.getDefectSeviyesi());
            
            rowAllCells.get(UYGULAMA_ORTAMI).setCellValue(all.getUygulamaOrtami());
            rowTodayCells.get(UYGULAMA_ORTAMI).setCellValue(all.getUygulamaOrtami());

            rowAllCells.get(ETKILENEN_SISTEMLER).setCellValue(all.getEtkilenenSistemler());
            rowTodayCells.get(ETKILENEN_SISTEMLER).setCellValue(all.getEtkilenenSistemler());

            rowAllCells.get(DEFECT_DETAYI).setCellValue(all.getDefectDetayi());
            rowTodayCells.get(DEFECT_DETAYI).setCellValue(all.getDefectDetayi());

            rowAllCells.get(DEFECT_DURUMU).setCellValue(all.getDefectDurumu());
            rowTodayCells.get(DEFECT_DURUMU).setCellValue(all.getDefectDurumu());

            rowAllCells.get(DEFECT_ACIKLAMASI).setCellValue(all.getDefectAciklamasi());
            rowTodayCells.get(DEFECT_ACIKLAMASI).setCellValue(all.getDefectAciklamasi());

            rowAllCells.get(DEFECT_ADEDI).setCellValue(all.getDefectAdedi());
            rowTodayCells.get(DEFECT_ADEDI).setCellValue(all.getDefectAdedi());

            rowAllCells.get(SIRKET).setCellValue(all.getSirket());
            rowTodayCells.get(SIRKET).setCellValue(all.getSirket());

            rowAllCells.get(PROJE_STATUSU).setCellValue(all.getProjeStatu());
            rowTodayCells.get(PROJE_STATUSU).setCellValue(all.getProjeStatu());

            rowAllCells.get(TEST_CONTACT).setCellValue(all.getPentestContact());
            rowTodayCells.get(TEST_CONTACT).setCellValue(all.getPentestContact());

            rowAllCells.get(DEFECT_SORUMLUSU).setCellValue(all.getDefectSorumlusu());
            rowTodayCells.get(DEFECT_SORUMLUSU).setCellValue(all.getDefectSorumlusu());

            rowAllCells.get(PROJE_YONETICISI).setCellValue(all.getProjeYoneticisi());
            rowTodayCells.get(PROJE_YONETICISI).setCellValue(all.getProjeYoneticisi());

            rowAllCells.get(SORUMLU_DIREKTORLUK).setCellValue(all.getSorumluDirektorluk());
            rowTodayCells.get(SORUMLU_DIREKTORLUK).setCellValue(all.getSorumluDirektorluk());

            rowAllCells.get(DEFECT_NO).setCellValue(all.getDefectNo());
            rowTodayCells.get(DEFECT_NO).setCellValue(all.getDefectNo());

            rowAllCells.get(TALEP_NO).setCellValue(all.getTalepNo());
            rowTodayCells.get(TALEP_NO).setCellValue(all.getTalepNo());

            rowAllCells.get(TEKRAR_EDEN).setCellValue(all.getTekrarEden());
            rowTodayCells.get(TEKRAR_EDEN).setCellValue(all.getTekrarEden());

            rowAllCells.get(ORTAM).setCellValue(all.getOrtam());
            rowTodayCells.get(ORTAM).setCellValue(all.getOrtam());

            rowAllCells.get(DEFECT_TARIHI).setCellValue(all.getDefectTarihi());
            rowTodayCells.get(DEFECT_TARIHI).setCellValue(all.getDefectTarihi());

            rowAllCells.get(GECIKME_DURUMU).setCellValue(all.getGecikmeDurumu());
            rowTodayCells.get(GECIKME_DURUMU).setCellValue(all.getGecikmeDurumu());

            rowAllCells.get(DEFECT_TIPI).setCellValue(all.getDefectTipi());
            rowTodayCells.get(DEFECT_TIPI).setCellValue(all.getDefectTipi());

            rowAllCells.get(ACIKLAMA).setCellValue(all.getAciklama());
            rowTodayCells.get(ACIKLAMA).setCellValue(all.getAciklama());

            rowAllCells.get(RAPORU_VAR_MI).setCellValue(all.getRaporVarMi());
            rowTodayCells.get(RAPORU_VAR_MI).setCellValue(all.getRaporVarMi());

            centerCells(rowAll,  rowAllCells, PROJE_ADI, ACILAN_DEFECTLER );
            centerCells(rowToday,  rowTodayCells, PROJE_ADI, ACILAN_DEFECTLER );
        }

        // Write the output to a file
        FileOutputStream out = new FileOutputStream(new File(rootFolder.getAbsolutePath() + "/" + cells.projeAdi + " bulgu_ozeti.xlsx"));

        wb.write(out);
        out.close();

        updater.update("Bulgu özeti excel dosyasına yazıldı.");

        // Closing the workbook
        wb.close();
    }

    private static void centerCells(Row row, List<Cell> cells, int... exceptions) {
        CellStyle cs_CENTER = row.getSheet().getWorkbook().createCellStyle();
        CellStyle cs_LEFT = row.getSheet().getWorkbook().createCellStyle();
        cs_CENTER.setAlignment(HorizontalAlignment.CENTER);
        cs_LEFT.setAlignment(HorizontalAlignment.LEFT);
        for(Cell c : cells){
            c.setCellStyle(cs_CENTER);
        }
        
        for(int i : exceptions)
            cells.get(i).setCellStyle(cs_LEFT);
    }
    
    
    private static final int TARIH = 0;
    private static final int AY = 1;
    private static final int HAFTA = 2;
    private static final int PROJE_ADI = 3;
    private static final int ACILAN_DEFECTLER = 4;
    private static final int DEFECT_SEVIYESI = 5;
    private static final int UYGULAMA_ORTAMI = 6;
    private static final int ETKILENEN_SISTEMLER = 7;
    private static final int DEFECT_DETAYI = 8;
    private static final int DEFECT_DURUMU = 9;
    private static final int DEFECT_ACIKLAMASI = 10;
    private static final int DEFECT_ADEDI = 11; 
    private static final int SIRKET = 12;
    private static final int PROJE_STATUSU = 13;
    private static final int TEST_CONTACT = 14;
    private static final int DEFECT_SORUMLUSU = 15;
    private static final int PROJE_YONETICISI = 16;
    private static final int SORUMLU_DIREKTORLUK = 17;
    private static final int DEFECT_NO = 18;
    private static final int TALEP_NO = 19;
    private static final int TEKRAR_EDEN = 20;
    private static final int ORTAM = 21;
    private static final int DEFECT_TARIHI = 22;
    private static final int GECIKME_DURUMU = 23;
    private static final int DEFECT_TIPI = 24;
    private static final int ACIKLAMA = 25;
    private static final int RAPORU_VAR_MI = 26;
}


