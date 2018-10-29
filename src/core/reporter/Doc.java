package core.reporter;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Doc {

    public enum Font
    {
        CALIBRI("Calibri"),
        CALIBRI_LIGHT("Calibri Light");

        private final String name;
        Font(String name) {
            this.name = name;
        }

        public String fontName() {
            return name;
        }
    }

    public static XWPFParagraph createParagraph(XWPFDocument document, ParagraphAlignment pa)
    {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(pa);
        return paragraph;
    }

    public static XWPFRun createRun(XWPFParagraph paragraph, String color, Font font, int fontSize)
    {
        XWPFRun run = paragraph.createRun();
        run.setColor(color);
        run.setFontFamily(font.fontName());
        run.setFontSize(fontSize);

        return run;
    }

    public static XWPFRun createRunSubTitle(XWPFParagraph paragraph)
    {
        return createRun(paragraph, TTColor.BLUE, Font.CALIBRI, 13);
    }

    public static XWPFRun createRunRegular(XWPFParagraph paragraph)
    {
        return createRun(paragraph, TTColor.BLACK, Font.CALIBRI, 11);
    }

    public static XWPFRun createRunSubSubTitle(XWPFParagraph paragraph) {
        return createRun(paragraph, TTColor.BLUE, Font.CALIBRI, 12);
    }
}
