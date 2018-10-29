/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tt.badu.ui.bug;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import core.reporter.Vulnerability;
import tt.badu.db.Database;

/**
 *
 * @author mk
 */
public class MyTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Seçim",
        "Zafiyet",
        "Seviye"};

    private final List<Vulnerability> mVulnerabilites = Database.init().selectAll();
    private Object[][] data;

    public MyTableModel() {
        data = new Object[mVulnerabilites.size()][3];

        for (int i = 0; i < mVulnerabilites.size(); i++) {
            data[i][0] = Boolean.FALSE;
            data[i][1] = mVulnerabilites.get(i).getTitle();
            data[i][2] = mVulnerabilites.get(i).getSeverity();
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
         * Don't need to implement this method unless your table's
         * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
         * Don't need to implement this method unless your table's
         * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
