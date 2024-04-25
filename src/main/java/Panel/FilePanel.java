package Panel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePanel extends JPanel {
    private JLabel fileLabel = new JLabel("Файл");
    private JLabel filePathLabel = new JLabel();
    private JTextArea fileText = new JTextArea();

    public FilePanel() {
        this.setLayout(new GridBagLayout());
        this.add(fileLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        this.add(filePathLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        fileText.setEditable(false);
        fileText.setFont(fileText.getFont().deriveFont(10f));

        this.add(new JScrollPane(fileText,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),
                new GridBagConstraints(0, 2, 1, 1, 1, 1,
                        GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
    }

    public void setFileText(String path) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            fileText.setText(content);
            setFilePathLabel(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFilePathLabel(String path){
        filePathLabel.setText(path);
    }

    public JTextArea getTextArea() {
        return fileText;
    }

    public void clearTextArea(){
        fileText.setText("");
    }
}
