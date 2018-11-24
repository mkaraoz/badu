package tt.badu.ui.master;

import core.reporter.Metadata;
import core.reporter.Reporter;
import core.reporter.SeveritySorter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import tt.badu.base.ExceptionHandler;
import core.reporter.Vulnerability;
import core.reporter.excel.CommonCells;
import core.reporter.excel.Excel;
import core.reporter.excel.enums.DefectDetay;
import core.reporter.excel.enums.DefectDurumu;
import core.reporter.excel.enums.GecikmeDurumu;
import core.reporter.excel.enums.ProjeStatus;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import tt.badu.ui.bug.BugListDialog;
import tt.badu.ui.excel.BulguOzetForm;
import tt.badu.ui.excel.DynamicRowData;
import tt.badu.ui.manuel.AddManuelBug;
import tt.badu.ui.vulcat.Catalog;

/**
 *
 * @author mk
 */
public class Master extends javax.swing.JFrame implements MasterCallback, ExceptionHandler.ExceptionCallback, UpdateCallback, RowDataCallback {

    private DynamicRowData drd = null;

    /**
     * Creates new form Master
     */
    public Master() {
        initComponents();
        ExceptionHandler.registerExceptionHandler(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlBugList = new javax.swing.JList<>(new DefaultListModel<Vulnerability>());
        jLabel1 = new javax.swing.JLabel();
        tfProjectName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfUrl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        tfUser = new javax.swing.JTextField();
        jbAddBug = new javax.swing.JButton();
        jbDeleteBug = new javax.swing.JButton();
        jbManuelBug = new javax.swing.JButton();
        jbGenerate = new javax.swing.JButton();
        jbCatalog = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taLogBox = new javax.swing.JTextArea();
        jbExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BADU");
        setResizable(false);

        jScrollPane1.setViewportView(jlBugList);

        jLabel1.setText("Proje Adı");

        tfProjectName.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tfProjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProjectNameActionPerformed(evt);
            }
        });

        jLabel2.setText("URL");

        tfUrl.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jLabel3.setText("Tarih");

        jLabel4.setText("Kullanıcı");

        tfDate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        tfUser.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jbAddBug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt/badu/image/Bug-Add-32.png"))); // NOI18N
        jbAddBug.setText("Add Bug");
        jbAddBug.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAddBug.setMaximumSize(new java.awt.Dimension(91, 65));
        jbAddBug.setMinimumSize(new java.awt.Dimension(91, 65));
        jbAddBug.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAddBug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddBugActionPerformed(evt);
            }
        });

        jbDeleteBug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt/badu/image/Bug-Delete-32.png"))); // NOI18N
        jbDeleteBug.setText("Delete Bug");
        jbDeleteBug.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbDeleteBug.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbDeleteBug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteBugActionPerformed(evt);
            }
        });

        jbManuelBug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt/badu/image/Bug-Edit-32.png"))); // NOI18N
        jbManuelBug.setText("Manuel Bug");
        jbManuelBug.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbManuelBug.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbManuelBug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbManuelBugActionPerformed(evt);
            }
        });

        jbGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt/badu/image/Cog-Go-32.png"))); // NOI18N
        jbGenerate.setText("Generate");
        jbGenerate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbGenerate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerateActionPerformed(evt);
            }
        });

        jbCatalog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt/badu/image/Application-View-List-32.png"))); // NOI18N
        jbCatalog.setText("Catalog");
        jbCatalog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCatalog.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCatalogActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt/badu/image/badu.png"))); // NOI18N

        taLogBox.setEditable(false);
        taLogBox.setBackground(new java.awt.Color(4, 3, 2));
        taLogBox.setColumns(20);
        taLogBox.setForeground(new java.awt.Color(254, 254, 254));
        taLogBox.setLineWrap(true);
        taLogBox.setRows(5);
        taLogBox.setText("> Basic Automated Document Util - BADU");
        taLogBox.setWrapStyleWord(true);
        taLogBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(taLogBox);

        jbExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tt/badu/image/Export-Excel-32.png"))); // NOI18N
        jbExcel.setText("Excel Data");
        jbExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAddBug, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeleteBug, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbManuelBug, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDate)
                            .addComponent(tfUrl)
                            .addComponent(tfUser)
                            .addComponent(tfProjectName, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbDeleteBug)
                    .addComponent(jbAddBug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbManuelBug)
                    .addComponent(jbExcel)
                    .addComponent(jbCatalog)
                    .addComponent(jbGenerate)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCatalogActionPerformed
        log("Catalaog penceresi açıldı.");

        Catalog catalog = new Catalog(this);
        catalog.setVisible(true);
    }//GEN-LAST:event_jbCatalogActionPerformed

    private void jbAddBugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddBugActionPerformed
        log("Bug listesi açıldı");

        BugListDialog vulcat = new BugListDialog(this, true);
        vulcat.setVisible(true);
    }//GEN-LAST:event_jbAddBugActionPerformed

    private void jbDeleteBugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteBugActionPerformed
        DefaultListModel model = (DefaultListModel) jlBugList.getModel();
        int index = jlBugList.getSelectedIndex();
        if (index >= 0) {
            log("Zafiyet silindi: " + model.get(index));
            model.remove(index);
        }
    }//GEN-LAST:event_jbDeleteBugActionPerformed

    private void jbManuelBugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbManuelBugActionPerformed
        AddManuelBug manuel = new AddManuelBug(this, true);
        manuel.setVisible(true);
    }//GEN-LAST:event_jbManuelBugActionPerformed

    private void jbGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerateActionPerformed
        log("Rapor üretiliyor.");

        final Metadata meta = new Metadata();
        meta.projectName = tfProjectName.getText();
        meta.type = "Web Uygulaması";
        meta.url = tfUrl.getText();
        meta.date = tfDate.getText();
        meta.userID = tfUser.getText();

        List<Vulnerability> vulnarabilities = new ArrayList<>();
        for (int i = 0; i < jlBugList.getModel().getSize(); i++) {
            vulnarabilities.add(jlBugList.getModel().getElementAt(i));
        }

        try {
            SeveritySorter.stupidSort(vulnarabilities);

            File rootFolder = new File(meta.projectName);
            rootFolder.mkdir();

            Reporter.createReport(meta, vulnarabilities, rootFolder, Master.this);

            if (drd != null) {
                CommonCells cells = new CommonCells(meta.projectName,
                        drd.getEtkilenenSistem(), // etkilenen sistem
                        DefectDetay.TEST_DEFECT,
                        DefectDurumu.ACIK,
                        ProjeStatus.ACIK,
                        drd.getTester(), // pentest contact
                        drd.getDefectSorumlusu(), // defect sorumlusu
                        drd.getProjeYoneticisi(), // project manager
                        drd.getDirektorluk(), // direktorluk
                        drd.getOrtam(), // test ortamı
                        GecikmeDurumu.YOK,
                        drd.getDefectTipi()); // defect type
                Excel.createExcelSummary(cells, vulnarabilities, rootFolder, Master.this);
            }

        } catch (IOException | InvalidFormatException ex) {
            call(ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbGenerateActionPerformed

    private void jbExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcelActionPerformed
        BulguOzetForm bulguForm = new BulguOzetForm(this, true);
        bulguForm.setVisible(true);
    }//GEN-LAST:event_jbExcelActionPerformed

    private void tfProjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProjectNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Master().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAddBug;
    private javax.swing.JButton jbCatalog;
    private javax.swing.JButton jbDeleteBug;
    private javax.swing.JButton jbExcel;
    private javax.swing.JButton jbGenerate;
    private javax.swing.JButton jbManuelBug;
    private javax.swing.JList<Vulnerability> jlBugList;
    private javax.swing.JTextArea taLogBox;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfProjectName;
    private javax.swing.JTextField tfUrl;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateVulnerabilities(List<Vulnerability> selectedVulnerabilities) {
        for (Vulnerability v : selectedVulnerabilities) {
            addToList(v);
            log("BUG: " + v.getTitle() + " - listeye eklendi.");
        }
    }

    private void addToList(Vulnerability v) {
        DefaultListModel model = (DefaultListModel) jlBugList.getModel();
        model.addElement(v);
    }

    private void log(String log) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                taLogBox.append("\n" + "> " + log);
            }
        });
    }

    @Override
    public void call(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        String sStackTrace = sw.toString(); // stack trace as a string 
        taLogBox.append(sStackTrace + "\n");
    }

    @Override
    public void update(String update) {
        log(update);
    }

    @Override
    public void setDynamicRowData(DynamicRowData drd) {
        this.drd = drd;
    }
}
