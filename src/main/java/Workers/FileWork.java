package Workers;

import Panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.*;

public class FileWork {
    private JFileChooser fileChooser = new JFileChooser();
    private File openedFile;

    public void addFile(CatalogPanel catalogPanel) {
        fileChooser.setDialogTitle("Выберите файл");
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            openedFile = fileChooser.getSelectedFile();

            final JFrame fileFrame = new JFrame();
            fileFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fileFrame.setBounds(500, 300, 300, 350);
            fileFrame.setLayout(new GridLayout(3, 1));
            final JTextArea fileContent = new JTextArea();
            fileContent.setEditable(false);

            try {
                fileContent.read(new FileReader(openedFile), null);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            fileFrame.add(new JScrollPane(fileContent,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS));

            JButton saveFile = new JButton("Добавить в список");
            JButton cancel = new JButton("Отмена");

            saveFile.addActionListener(e -> {
                catalogPanel.addListModel(openedFile.getPath());
                fileFrame.dispatchEvent(new WindowEvent(fileFrame, WindowEvent.WINDOW_CLOSING));
            });

            cancel.addActionListener(e -> {
                fileFrame.dispatchEvent(new WindowEvent(fileFrame, WindowEvent.WINDOW_CLOSING));
            });
            fileFrame.add(saveFile);
            fileFrame.add(cancel);
            fileFrame.setVisible(true);
        }
    }

    public void changeFileText() {
        if (openedFile != null) {
            final JFrame fileFrame = new JFrame();
            fileFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fileFrame.setBounds(500, 300, 300, 350);
            fileFrame.setLayout(new GridLayout(3, 1));
            final JTextArea fileContent = new JTextArea();
            fileContent.setEditable(true);

            try {
                fileContent.read(new FileReader(openedFile), null);
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            fileFrame.add(new JScrollPane(fileContent,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS));
            JButton save = new JButton("Сохранить");
            JButton close = new JButton("Закрыть");

            save.addActionListener(e -> {
                try {
                    fileContent.write(new FileWriter(openedFile));
                    fileFrame.dispatchEvent(new WindowEvent(fileFrame, WindowEvent.WINDOW_CLOSING));
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

                fileFrame.dispatchEvent(new WindowEvent(fileFrame, WindowEvent.WINDOW_CLOSING));
            });

            close.addActionListener(e ->
                    fileFrame.dispatchEvent(new WindowEvent(fileFrame, WindowEvent.WINDOW_CLOSING)));

            fileFrame.add(save);
            fileFrame.add(close);
            fileFrame.setVisible(true);
        } else
            System.out.println("Выберите файл");
    }
}
