package Panel;

import javax.swing.*;
import java.awt.*;

public class CatalogPanel extends JPanel {
    private JLabel catalogLabel = new JLabel("Каталог");
    private JList<String> trajectoryList;

    public CatalogPanel() {
        this.setLayout(new GridBagLayout());
        this.add(catalogLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        String[] trajectoryArray = {"Траектория 1", "Траектория 2", "Траектория 3", "Траектория 4", "Траектория 000"};
        trajectoryList = new JList<String>(trajectoryArray);

        this.add(new JScrollPane(trajectoryList,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),
                new GridBagConstraints(0, 1, 1, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
    }

}
