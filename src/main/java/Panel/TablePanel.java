package Panel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TablePanel extends JPanel {
    private JLabel tableLabel = new JLabel("Таблица");
    private JTable trajectoryTable;
    private DefaultTableModel model;
    private Object[] columnNames = new String[]{"T,c", "X,м", "Y,м", "Z,м", "Vx,м/с", "Vy,м/с", "Vz, м/с"};

    public TablePanel() {
        this.setLayout(new GridBagLayout());

        this.add(tableLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        model = new DefaultTableModel();
        trajectoryTable = new JTable(model);

        this.add(new JScrollPane(trajectoryTable), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
    }

    public void setTrajectoryTable(String filePath) {
        model.setDataVector(parseTxtFile(filePath), columnNames);
    }

    public Object[][] parseTxtFile(String filePath) {
        String[][] tableRows = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rows = 0;
            int cols = 0;

            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split("\\s+");
                if (values.length > cols) {
                    cols = values.length;
                }
                rows++;
            }
            tableRows = new String[rows][cols];
            BufferedReader brr = new BufferedReader(new FileReader(filePath));
            int row = 0;

            while ((line = brr.readLine()) != null) {
                String[] values = line.trim().split("\\s+");
                for (int col = 0; col < values.length; col++) {
                    tableRows[row][col] = values[col];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableRows;
    }

    public void clearTable(){
        model.setRowCount(0);
        model.setColumnCount(0);
    }
}
