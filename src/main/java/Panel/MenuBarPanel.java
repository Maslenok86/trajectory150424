package Panel;

import Workers.FileWork;

import javax.swing.*;

public class MenuBarPanel extends JMenuBar {
    private JMenuItem defaultFramePosMenuItem;
    private JMenuItem savePosMenuItem;
    private FileWork fileWork = new FileWork();
    private JMenu closeMenuItem;

    public MenuBarPanel(CatalogPanel catalogPanel) {
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem openMenuItem = new JMenuItem("Открыть...");
        JMenu openResentMenuItem = new JMenu("Открыть недавние");
        closeMenuItem = new JMenu("Закрыть");
        JMenuItem closeAllMenuItem = new JMenuItem("Закрыть все");

        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(openResentMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeAllMenuItem);
        this.add(fileMenu);

        openMenuItem.addActionListener(e -> fileWork.addFile(catalogPanel));
        closeAllMenuItem.addActionListener(e-> {
            catalogPanel.closeAllList();

        });
        JMenu settingsMenu = new JMenu("Настройки");
        defaultFramePosMenuItem = new JMenuItem("Положение окон по умолчанию");
        savePosMenuItem = new JMenuItem("Сохранить положение окон");
        settingsMenu.add(defaultFramePosMenuItem);
        settingsMenu.addSeparator();
        settingsMenu.add(savePosMenuItem);
        this.add(settingsMenu);
    }

    public JMenuItem getDefaultFramePosMenuItem() {
        return defaultFramePosMenuItem;
    }

    public JMenuItem getSavePosMenuItem() {
        return savePosMenuItem;
    }

    public void addDeletedFile(String filePath) {
        JMenuItem item = new JMenuItem(filePath);
        closeMenuItem.add(item);
    }
}
