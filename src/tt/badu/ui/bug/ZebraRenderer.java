/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tt.badu.ui.bug;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author tt
 */
public class ZebraRenderer implements TableCellRenderer {

    private static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
    private static final Color ODD_ROW_COLOR = Color.decode("#F8F8F8");
    private static final Color EVEN_ROW_COLOR = Color.WHITE;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Apply zebra style on table rows
        Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            if (row % 2 == 0) {
                c.setBackground(EVEN_ROW_COLOR);
            } else {
                c.setBackground(ODD_ROW_COLOR);
            }
        }
        return c;
    }
}
