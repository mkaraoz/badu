
package tt.badu.ui.manuel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import core.reporter.enums.Severity;
import core.reporter.Vulnerability;
import core.db.Database;
import core.reporter.enums.Category;
import core.reporter.enums.Domain;
import tt.badu.ui.master.MasterCallback;
import tt.badu.ui.master.UpdateCallback;

/**
 *
 * @author mk
 */
public class AddManuelBug extends javax.swing.JDialog {

    private final MasterCallback callback;
    private final UpdateCallback updater;

    /**
     * Creates new form AddManuelBug
     */
    public AddManuelBug(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        callback = (MasterCallback) parent;
        updater = (UpdateCallback) parent;

        setLocationRelativeTo(parent);
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbSeverity = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taBody = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taSolution = new javax.swing.JTextArea();
        jbOkButton = new javax.swing.JButton();
        jbCancelButton = new javax.swing.JButton();
        cbCatalaog = new javax.swing.JCheckBox();
        cbDomain = new javax.swing.JComboBox<>();
        cbCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manuel Bug");
        setResizable(false);

        jLabel1.setText("Bug");

        jLabel2.setText("Seviye");

        jLabel3.setText("Açıklama");

        taBody.setColumns(20);
        taBody.setLineWrap(true);
        taBody.setRows(5);
        taBody.setWrapStyleWord(true);
        taBody.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taBodyKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(taBody);

        jLabel4.setText("Çözüm");

        taSolution.setColumns(20);
        taSolution.setLineWrap(true);
        taSolution.setRows(5);
        taSolution.setWrapStyleWord(true);
        taSolution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taSolutionKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(taSolution);

        jbOkButton.setText("OK");
        jbOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkButtonActionPerformed(evt);
            }
        });

        jbCancelButton.setText("CANCEL");
        jbCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelButtonActionPerformed(evt);
            }
        });

        cbCatalaog.setText("Kataloğa kaydet");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSeverity, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbCatalaog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                        .addComponent(jbCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbSeverity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbOkButton)
                    .addComponent(jbCancelButton)
                    .addComponent(cbCatalaog))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelButtonActionPerformed
        updater.update("Manuel zafiyet ekleme işlemei iptal edildi.");
        this.dispose();
    }//GEN-LAST:event_jbCancelButtonActionPerformed

    private void jbOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkButtonActionPerformed
        addManuelBug();
    }//GEN-LAST:event_jbOkButtonActionPerformed

    private void taBodyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taBodyKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (evt.getModifiers() > 0) {
                taBody.transferFocusBackward();
            } else {
                taBody.transferFocus();
            }
            evt.consume();
        }
    }//GEN-LAST:event_taBodyKeyPressed

    private void taSolutionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taSolutionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (evt.getModifiers() > 0) {
                taSolution.transferFocusBackward();
            } else {
                taSolution.transferFocus();
            }
            evt.consume();
        }
    }//GEN-LAST:event_taSolutionKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbCatalaog;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbDomain;
    private javax.swing.JComboBox<String> cbSeverity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCancelButton;
    private javax.swing.JButton jbOkButton;
    private javax.swing.JTextArea taBody;
    private javax.swing.JTextArea taSolution;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

    private void addManuelBug() {
        String title = tfTitle.getText();
        Severity severity = Severity.get(cbSeverity.getSelectedItem().toString());
        String body = taBody.getText();
        String recommend = taSolution.getText();
        Domain d = Domain.get(cbDomain.getSelectedItem().toString());
        Category c = Category.get(cbCategory.getSelectedItem().toString());

        Vulnerability v = new Vulnerability(title, severity, body, recommend, d, c);
        if (cbCatalaog.isSelected()) {
            Database.init().insert(v);
            updater.update("Manuel zafitey tanımı kataloğa eklendi: " + v.getTitle());
        }
        List<Vulnerability> vList = new ArrayList<>(1);
        vList.add(v);
        callback.updateVulnerabilities(vList);
        updater.update("Manuel zafiyet eklendi: " + v.getTitle());
        this.dispose();
    }
    
    private void init() {
        Severity severityVals[] = Severity.values();
        String severityTitles[] = new String[severityVals.length];
        for (int i = 0; i < severityVals.length; i++) {
            severityTitles[i] = severityVals[i].getName();
        }
        cbSeverity.setModel(new javax.swing.DefaultComboBoxModel<>(severityTitles));

        Domain domainVals[] = Domain.values();
        String domainTitles[] = new String[domainVals.length];
        for (int i = 0; i < domainVals.length; i++) {
            domainTitles[i] = domainVals[i].getName();
        }
        cbDomain.setModel(new javax.swing.DefaultComboBoxModel<>(domainTitles));

        Category categoryVals[] = Category.values();
        String catTitles[] = new String[categoryVals.length];
        for (int i = 0; i < categoryVals.length; i++) {
            catTitles[i] = categoryVals[i].getName();
        }
        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(catTitles));
    }
}
