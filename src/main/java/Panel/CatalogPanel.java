package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;


public class CatalogPanel extends JPanel {
    private JLabel catalogLabel = new JLabel("Каталог");
    DefaultListModel<String> listModel = new DefaultListModel();
    private JList<String> trajectoryList;
    private HashMap<String, String> addedFilesInfo = new HashMap<>(); //changedFileName, FilePath

    public CatalogPanel(FilePanel filePanel) {
        this.setLayout(new GridBagLayout());
        this.add(catalogLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        trajectoryList = new JList<>(listModel);
        trajectoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        trajectoryList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selected = trajectoryList.getSelectedIndex();
                    String changedFileName = listModel.getElementAt(selected);

                    filePanel.setFileText(getFilePath(changedFileName));
                }
            }
        });

        this.add(new JScrollPane(trajectoryList,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),
                new GridBagConstraints(0, 1, 1, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
    }

    public void addListModel(String newFilePath, String newFileName) {
        listModel.addElement(newFileName);
        addedFilesInfo.put(newFileName, newFilePath);
    }

    public String getFilePath(String key) {
        return addedFilesInfo.get(key);
    }

    public boolean isFileExist(String filePath) {
        return addedFilesInfo.containsValue(filePath);
    }

    public boolean isListModelExist(String fileName) {
        return addedFilesInfo.containsKey(fileName);
    }
}
