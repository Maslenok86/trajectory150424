import javax.swing.*;

public class MenuBar extends JMenuBar {
    private JMenuItem defaultFramePosMenuItem;
    private JMenuItem savePosMenuItem;

    public MenuBar() {
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem openMenuItem = new JMenuItem("Открыть...");
        JMenuItem openResentMenuItem = new JMenuItem("Открыть недавние");
        JMenuItem closeMenuItem = new JMenuItem("Закрыть");
        JMenuItem closeAllMenuItem = new JMenuItem("Закрыть все");

        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(openResentMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeAllMenuItem);
        this.add(fileMenu);

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
}
