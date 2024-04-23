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

            final JTextArea fileContent = new JTextArea();
            fileContent.setEditable(false);

            try {
                fileContent.read(new FileReader(openedFile), null);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            fileContent.setFont(fileContent.getFont().deriveFont(10f));
            JScrollPane scrollPane = new JScrollPane(fileContent,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setPreferredSize(new Dimension(500, 300));

            if (JOptionPane.showConfirmDialog(null, scrollPane, "Подтвердите файл", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                String newFileName;
                while (true) {
                    newFileName = JOptionPane.showInputDialog(null, "Введите новое имя файла", openedFile.getPath());
                    System.out.println(newFileName);

                    if (catalogPanel.isFileExist(openedFile.getPath())) {
                        JOptionPane.showMessageDialog(null, "Данный файл уже добавлен.", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                        break;
                    } else if (catalogPanel.isListModelExist(newFileName)) {
                        JOptionPane.showMessageDialog(null, "Данное имя файла уже существует.", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                    } else if (newFileName != null) {
                        catalogPanel.addListModel(openedFile.getPath(), newFileName);
                        break;
                    } else if (newFileName == null) {
                        break;
                    }
                }


            }
        }
    }
    /*
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
     */
}
