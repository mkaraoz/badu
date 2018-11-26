package core.reporter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Charter {

    private final File rootFolder;
    
    private Charter(File rootFolder) {
        this.rootFolder = rootFolder;
    }

    public static Charter getInstance(File rootFolder) {
        return new Charter(rootFolder);
    }

    public String createChart(List<Vulnerability> vulnerabilities, String chartName) throws IOException {

        Map<Severity, Integer> map = new TreeMap<>();
        for (Vulnerability v : vulnerabilities) {
            Severity severity = v.getSeverity();
            if (map.containsKey(severity)) {
                map.put(severity, map.get(severity) + 1);
            } else {
                map.put(severity, 1);
            }
        }

        DefaultPieDataset vulnDataSet = fillDataset(map);

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Bulgu Özeti", // chart title
                vulnDataSet, // data
                true, // include legend
                true,
                false);
        chart.getTitle().setMargin(10, 10, 10, 10);

        // sets the label format
        // https://stackoverflow.com/questions/17501750/jfreechart-customize-piechart-to-show-absolute-values-and-percentages
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(labelGenerator);
        plot.setLegendLabelToolTipGenerator(
                new StandardPieSectionLabelGenerator(
                        "Tooltip for legend item {0}"));
        plot.setSimpleLabels(true);
        plot.setInteriorGap(0.0);

        chart.getPlot().setBackgroundPaint(java.awt.Color.WHITE);
        chart.getPlot().setOutlinePaint(null);
        chart.setBorderVisible(false);
        chart.getLegend().setMargin(10, 10, 10, 10);
        chart.setPadding(new RectangleInsets(10, 10, 10, 10));

        for (Severity severity : Severity.values()) {
            plot.setSectionPaint(severity.name(), java.awt.Color.decode("#" + severity.chartColor()));
        }

        String filePath = saveChart2File(chart, chartName);

        return filePath;
    }

    private String saveChart2File(JFreeChart chart, String chartName) throws IOException {
        final String FILE_NAME = rootFolder.getAbsolutePath() + "/"+ chartName + ".png";
        
        int width = 800;
        /* Width of the image */
        int height = 600;
        /* Height of the image */
        File pieChartPng = new File(FILE_NAME);

        ChartUtilities.saveChartAsPNG(pieChartPng, chart, width, height);

        return pieChartPng.getAbsolutePath();
    }

    private DefaultPieDataset fillDataset(Map<Severity, Integer> map) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<Severity, Integer> entry : map.entrySet()) {
            dataset.setValue(entry.getKey().name(), entry.getValue());
        }
        return dataset;
    }
}
