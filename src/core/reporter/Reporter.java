package core.reporter;

/**
 * Created by mk on 15.09.2018.
 */

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import tt.badu.ui.master.UpdateCallback;

public class Reporter {

    private static UpdateCallback updater;
    private static String projectName;
    private static File rootFolder;

    public static void createReport(Metadata meta, List<Vulnerability> vulnarabilities, File rootFolder, UpdateCallback updater) throws IOException, InvalidFormatException {
        Reporter.updater = updater;
        Reporter.rootFolder = rootFolder;

        XWPFDocument document = new XWPFDocument(new FileInputStream("./base/master.docx"));

        projectName = meta.projectName;
        writeMetadata(document, meta);

        drawPieChart(document, vulnarabilities, projectName);

        writeSummary(document, vulnarabilities); // bulgu özeti

        addPageBreak(document);

        addTableOfContents(document);

        createSubTitle(document, "2.2 Detaylı Rapor");

        writeVulnerabilities(document, vulnarabilities);

        createDoc(document);
    }

    private static void writeVulnerabilities(XWPFDocument document, List<Vulnerability> vulnarabilities) {
        for (int i = 0; i < vulnarabilities.size(); i++) {
            XWPFParagraph paragraphHeading = Doc.createParagraph(document, ParagraphAlignment.LEFT);

            XWPFRun rBulguTitle = Doc.createRun(paragraphHeading, TTColor.BLUE, Doc.Font.CALIBRI, 13);
            Vulnerability v = vulnarabilities.get(i);
            rBulguTitle.addCarriageReturn();
            rBulguTitle.setText("Bulgu " + String.valueOf(i + 1) + ".   " + v.getTitle());
            paragraphHeading.setStyle("Heading2");

            String color = v.getSeverity().reportColor();
            XWPFRun rSeverity = Doc.createRun(paragraphHeading, color, Doc.Font.CALIBRI, 13);
            rSeverity.setText(" [" + v.getSeverity().getName() + "]");

            XWPFParagraph paragraph = Doc.createParagraph(document, ParagraphAlignment.BOTH);
            paragraph.setIndentationLeft(0);
            paragraph.setIndentationFirstLine(0);
            XWPFRun rBody = Doc.createRun(paragraph, TTColor.BLACK, Doc.Font.CALIBRI, 11);
            rBody.setText(v.getBody());
            rBody.addCarriageReturn();
            rBody.addCarriageReturn();

            XWPFRun rRecommendationTitle = Doc.createRun(paragraph, TTColor.BLUE, Doc.Font.CALIBRI_LIGHT, 12);
            rRecommendationTitle.setText("Çözüm Önerisi:");
            rRecommendationTitle.addCarriageReturn();

            XWPFRun rRecommendation = Doc.createRun(paragraph, TTColor.BLACK, Doc.Font.CALIBRI, 11);
            rRecommendation.setText(v.getRecommendation());

            paragraph.setBorderBottom(Borders.SINGLE);
            rRecommendation.addCarriageReturn();
        }
    }

    private static void createSubTitle(XWPFDocument document, String title) {
        XWPFParagraph pSubTitle = Doc.createParagraph(document, ParagraphAlignment.LEFT);
        pSubTitle.setIndentationFirstLine(0);
        pSubTitle.setIndentationLeft(0);
        XWPFRun rSubTitle = Doc.createRun(pSubTitle, TTColor.BLUE, Doc.Font.CALIBRI, 15);
        rSubTitle.setText(title);
    }

    private static void addTableOfContents(XWPFDocument document) {
        XWPFParagraph pTitle = Doc.createParagraph(document, ParagraphAlignment.LEFT);
        XWPFRun rTitle = Doc.createRun(pTitle, TTColor.BLUE, Doc.Font.CALIBRI, 15);
        rTitle.setText("İçindekiler");
        rTitle.addCarriageReturn();
        XWPFParagraph pTOC = document.createParagraph();
        CTP ctP = pTOC.getCTP();
        CTSimpleField toc = ctP.addNewFldSimple();
        toc.setInstr("TOC \\h");
        toc.setDirty(STOnOff.TRUE);
        pTOC.setPageBreak(true);
    }

    private static void addPageBreak(XWPFDocument document) {
        XWPFParagraph pSummary = Doc.createParagraph(document, ParagraphAlignment.LEFT);
        pSummary.setPageBreak(true);
    }

    private static void writeSummary(XWPFDocument document, List<Vulnerability> vulnarabilities) {
        Map<Severity, List<Vulnerability>> categorizedVulnMap = createCategorizedVulnMap(vulnarabilities);
        XWPFParagraph pSummary = Doc.createParagraph(document, ParagraphAlignment.LEFT);
        pSummary.createRun().addCarriageReturn();

        List<Vulnerability> groupedVulns;
        groupedVulns = categorizedVulnMap.get(Severity.ACIL);
        addFindingList(Severity.ACIL.getName() + " Seviye Bulgular", groupedVulns, pSummary);

        groupedVulns = categorizedVulnMap.get(Severity.KRITIK);
        addFindingList(Severity.KRITIK.getName() + " Seviye Bulgular", groupedVulns, pSummary);

        groupedVulns = categorizedVulnMap.get(Severity.YUKSEK);
        addFindingList(Severity.YUKSEK.getName() + " Seviye Bulgular", groupedVulns, pSummary);

        groupedVulns = categorizedVulnMap.get(Severity.ORTA);
        addFindingList(Severity.ORTA.getName() + " Seviye Bulgular", groupedVulns, pSummary);

        groupedVulns = categorizedVulnMap.get(Severity.DUSUK);
        addFindingList(Severity.DUSUK.getName() + " Seviye Bulgular", groupedVulns, pSummary);
    }

    private static void writeMetadata(XWPFDocument document, Metadata meta) {
        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("#AppName")) {
                        text = text.replace("#AppName", meta.projectName);
                        r.setText(text, 0);
                    } else if (text != null && text.contains("#URL")) {
                        text = text.replace("#URL", "URL: " + meta.url);
                        r.addTab();
                        r.addTab();
                        r.setText(text, 0);
                    } else if (text != null && text.contains("#Test Tarihi")) {
                        text = text.replace("#Test Tarihi", "Test Tarihi: " + meta.date);
                        r.addTab();
                        r.setText(text, 0);
                    } else if (text != null && text.contains("#Kullanıcı")) {
                        text = text.replace("#Kullanıcı", "Kullanıcı Id: " + meta.userID);
                        r.addTab();
                        r.setText(text, 0);
                    }
                }
            }
        }
        Reporter.updater.update("Meta-data yazildi.");
        System.out.println("Meta-data yazildi.");
    }

    private static void drawPieChart(XWPFDocument document, List<Vulnerability> vulnarabilities, String projectName) throws IOException, InvalidFormatException {
        Reporter.updater.update("Grafik ciziliyor, bu islem biraz zaman alabilir...");
        System.out.println("Grafik ciziliyor, bu islem biraz zaman alabilir...");
        XWPFParagraph pChartImage = document.createParagraph();
        pChartImage.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun rChartImage = pChartImage.createRun();
        // rChartImage.addCarriageReturn();
        String chartFilePath = Charter.getInstance(rootFolder).createChart(vulnarabilities, projectName);
        Path chartPath = Paths.get(chartFilePath);
        rChartImage.addPicture(Files.newInputStream(chartPath),
                XWPFDocument.PICTURE_TYPE_PNG, chartPath.getFileName().toString(),
                Units.toEMU(400), Units.toEMU(300));

        Reporter.updater.update("Grafik cizildi.");
        System.out.println("Grafik cizildi.");
    }

    private static void createDoc(XWPFDocument doc) throws IOException {
        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File(rootFolder.getAbsolutePath() + "/tt_" + projectName + "_rapor.docx"));
        doc.write(out);
        out.close();
        Reporter.updater.update(projectName + " uygulaması sızma testi raporu başarı ile üretildi.");
        System.out.println(projectName + " uygulaması sızma testi raporu başarı ile üretildi.");
    }

    private static Map<Severity, List<Vulnerability>> createCategorizedVulnMap(List<Vulnerability> vulnarabilities) {
        Map<Severity, List<Vulnerability>> map = new HashMap<>();
        for (Vulnerability v : vulnarabilities) {
            Severity s = v.getSeverity();
            if (map.get(s) != null) {
                map.get(s).add(v);
            } else {
                List<Vulnerability> list = new ArrayList<Vulnerability>();
                list.add(v);
                map.put(v.getSeverity(), list);
            }
        }

        return map;
    }

    private static void addFindingList(String title, List<Vulnerability> vulns, XWPFParagraph paragraph) {
        if (vulns == null) {
            return;
        }
        Severity severity = vulns.get(0).getSeverity();
        XWPFRun rSummary = Doc.createRun(paragraph, severity.reportColor(), Doc.Font.CALIBRI, 13);
        rSummary.setText(title);
        rSummary.addCarriageReturn();
        XWPFRun rSummaryItem = Doc.createRun(paragraph, TTColor.BLACK, Doc.Font.CALIBRI, 11);
        for (Vulnerability v : vulns) {
            rSummaryItem.setText("   - " + v.getTitle());
            rSummaryItem.addCarriageReturn();
        }
        rSummaryItem.addCarriageReturn();
    }
}
