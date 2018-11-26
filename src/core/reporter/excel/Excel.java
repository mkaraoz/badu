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
import tt.badu.ui.master.UpdateCallback;

public class Excel
{
    public static void createExcelSummary(final CommonCells cells,
                                          final List<Vulnerability> vulnerabilityList,
                                          File rootFolder,
                                          UpdateCallback updater) throws IOException
    {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("./base/bulgu_master.xlsx"));

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();

        List<RowData> rowList = new ArrayList<>();

        for (Vulnerability v : vulnerabilityList) {

            RowData rowData = new RowData();

            rowData.setTarih(String.valueOf(year));

            rowData.setAy(String.valueOf(month));

            rowData.setProje_adi(cells.projeAdi);

            rowData.setAcilan_defectler(v.getTitle());

            rowData.setDefect_seviyesi(v.getSeverity().getName());

            rowData.setEtkilenen_sistemler(cells.etkilenenSistem);

            rowData.setDefect_detayi(cells.defectDetay.getText());

            rowData.setDefect_durumu(cells.defectDurumu.getText());

            rowData.setDefect_aciklamasi("");

            rowData.setDefect_adedi("1");

            rowData.setSirket("Türk Telekom");

            rowData.setProje_statu(cells.projeStatus.getText());

            rowData.setPentest_contact(cells.pentestContact);

            rowData.setDefect_sorumlusu(cells.defectSorumlusu);

            rowData.setProje_yoneticisi(cells.projeYoneticisi);

            rowData.setSorumlu_direktorluk(cells.direktorluk);

            rowData.setDefect_no("");

            rowData.setTalep_no("");

            rowData.setTekrar_eden("");

            rowData.setOrtam(cells.ortam);

            rowData.setDefect_tarihi("");

            rowData.setGecikme_durumu(cells.gecikmeDurumu.getText());

            rowData.setDefect_tipi(cells.defectTipi);

            rowData.setAciklama("");

            rowData.setRapor_var_mi("Evet");

            rowList.add(rowData);
        }

        Sheet sheetAll = wb.getSheetAt(0);
        wb.setSheetName(0, "ALL");
        Sheet sheetToday = wb.getSheetAt(1);
        wb.setSheetName(1, String.valueOf(year));

        for (int i = 0; i< rowList.size(); i++) {
            Row rowAll = sheetAll.createRow(i+1);
            Row rowToday = sheetToday.createRow(i+1);
            RowData all = rowList.get(i);

            rowAll.createCell(0).setCellValue(all.getTarih());
            rowToday.createCell(0).setCellValue(all.getTarih());

            rowAll.createCell(1).setCellValue(all.getAy());
            rowToday.createCell(1).setCellValue(all.getAy());

            rowAll.createCell(2).setCellValue(all.getProje_adi());
            rowToday.createCell(2).setCellValue(all.getProje_adi());

            rowAll.createCell(3).setCellValue(all.getAcilan_defectler());
            rowToday.createCell(3).setCellValue(all.getAcilan_defectler());

            rowAll.createCell(4).setCellValue(all.getDefect_seviyesi());
            rowToday.createCell(4).setCellValue(all.getDefect_seviyesi());

            rowAll.createCell(5).setCellValue(all.getEtkilenen_sistemler());
            rowToday.createCell(5).setCellValue(all.getEtkilenen_sistemler());

            rowAll.createCell(6).setCellValue(all.getDefect_detayi());
            rowToday.createCell(6).setCellValue(all.getDefect_detayi());

            rowAll.createCell(7).setCellValue(all.getDefect_durumu());
            rowToday.createCell(7).setCellValue(all.getDefect_durumu());

            rowAll.createCell(8).setCellValue(all.getDefect_aciklamasi());
            rowToday.createCell(8).setCellValue(all.getDefect_aciklamasi());

            rowAll.createCell(9).setCellValue(all.getDefect_adedi());
            rowToday.createCell(9).setCellValue(all.getDefect_adedi());

            rowAll.createCell(10).setCellValue(all.getSirket());
            rowToday.createCell(10).setCellValue(all.getSirket());

            rowAll.createCell(11).setCellValue(all.getProje_statu());
            rowToday.createCell(11).setCellValue(all.getProje_statu());

            rowAll.createCell(12).setCellValue(all.getPentest_contact());
            rowToday.createCell(12).setCellValue(all.getPentest_contact());

            rowAll.createCell(13).setCellValue(all.getDefect_sorumlusu());
            rowToday.createCell(13).setCellValue(all.getDefect_sorumlusu());

            rowAll.createCell(14).setCellValue(all.getProje_yoneticisi());
            rowToday.createCell(14).setCellValue(all.getProje_yoneticisi());

            rowAll.createCell(15).setCellValue(all.getSorumlu_direktorluk());
            rowToday.createCell(15).setCellValue(all.getSorumlu_direktorluk());

            rowAll.createCell(16).setCellValue(all.getDefect_no());
            rowToday.createCell(16).setCellValue(all.getDefect_no());

            rowAll.createCell(17).setCellValue(all.getTalep_no());
            rowToday.createCell(17).setCellValue(all.getTalep_no());

            rowAll.createCell(18).setCellValue(all.getTekrar_eden());

            rowAll.createCell(19).setCellValue(all.getOrtam());
            rowToday.createCell(18).setCellValue(all.getOrtam());

            rowAll.createCell(20).setCellValue(all.getDefect_tarihi());
            rowToday.createCell(19).setCellValue(all.getDefect_tarihi());

            rowAll.createCell(21).setCellValue(all.getGecikme_durumu());
            rowToday.createCell(20).setCellValue(all.getGecikme_durumu());

            rowAll.createCell(22).setCellValue(all.getDefect_tipi());
            rowToday.createCell(21).setCellValue(all.getDefect_tipi());

            rowAll.createCell(23).setCellValue(all.getAciklama());
            rowToday.createCell(22).setCellValue(all.getAciklama());

            rowAll.createCell(24).setCellValue(all.getRapor_var_mi());
            rowToday.createCell(23).setCellValue(all.getRapor_var_mi());
        }

        // Write the output to a file
        FileOutputStream out = new FileOutputStream(new File(rootFolder.getAbsolutePath() + "/" + cells.projeAdi + " bulgu_ozeti.xlsx"));     
        
        wb.write(out);
        out.close();
        
        updater.update("Bulgu özeti excel dosyasına yazıldı.");

        // Closing the workbook
        wb.close();
    }
}







































