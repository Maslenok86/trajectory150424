package Panel;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private JLabel tableLabel = new JLabel("Таблица");
    private JTable trajectoryTable;

    public TablePanel() {
        this.setLayout(new GridBagLayout());

        this.add(tableLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        Object[][] rowTrajectory = new String[][]{
                {"2.000", "1976091.0", "3974537.2", "4564998.2", "1.671", "4.251", "4.931"},
                {"3.000", "1976106.2", "3974538.9", "4565022.1", "3.707", "6.415", "7.780"},
                {"4.000", "1976141.1", "3974530.0", "4565022.4", "4.244", "9.116", "10.318"},
                {"5.000", "1976148.1", "3974530.9", "4565030.2", "6.209", "11.678", "13.072"},
                {"6.000", "1976060.7", "3974622.9", "4565015.4", "6.970", "13.928", "16.196"},
                {"7.000", "1976117.6", "3974596.9", "4565109.3", "8.188", "16.455", "18.861"},
                {"8.000", "1976110.0", "3974639.2", "4565129.4", "10.102", "18.708", "21.844"},
                {"9.000", "1976109.7", "3974633.1", "4565147.3", "11.134", "21.199", "24.728"}};
        Object[] columnNames = new String[]{"T,c", "X,м", "Y,м", "Z,м", "Vx,м/с", "Vy,м/с", "Vz, м/с"};

        trajectoryTable = new JTable(rowTrajectory, columnNames);

        this.add(new JScrollPane(trajectoryTable), new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
    }
}
