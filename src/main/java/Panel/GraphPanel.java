package Panel;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private JLabel graphLabel = new JLabel("График");
    private JLabel coordLabel = new JLabel("Координаты:");
    private JLabel speedLabel = new JLabel("Проекции скорости:");
    private JCheckBox coordXCheckBox = new JCheckBox("X,м");
    private JCheckBox coordYCheckBox = new JCheckBox("Y,м");
    private JCheckBox coordZCheckBox = new JCheckBox("Z,м");
    private JCheckBox speedVxCheckBox = new JCheckBox("Vx,м/с");
    private JCheckBox speedVyCheckBox = new JCheckBox("Vy,м/с");
    private JCheckBox speedVzCheckBox = new JCheckBox("Vz,м/с");
    private JButton searchButton = new JButton("Найти...");
    private JButton deleteButton = new JButton("Удалить...");

    public GraphPanel() {
        this.setLayout(new GridBagLayout());

        this.add(graphLabel, new GridBagConstraints(0, 0, 8, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(coordLabel, new GridBagConstraints(0, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(coordXCheckBox, new GridBagConstraints(1, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(coordYCheckBox, new GridBagConstraints(2, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(coordZCheckBox, new GridBagConstraints(3, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(speedLabel, new GridBagConstraints(4, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(speedVxCheckBox, new GridBagConstraints(5, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(speedVyCheckBox, new GridBagConstraints(6, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(speedVzCheckBox, new GridBagConstraints(7, 1, 1, 1, 1, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

        JPanel imgPanel = new JPanel();
        JLabel label = new JLabel();
        label.setSize(900, 200);

        ImageIcon picture = new ImageIcon(this.getClass().getResource("/graph.png"));
        Image newImage = picture.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon newPic = new ImageIcon(newImage);

        label.setIcon(newPic);

        imgPanel.add(label);

        this.add(imgPanel, new GridBagConstraints(0, 2, 8, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));


        JPanel graphBtnsPanel = new JPanel();
        graphBtnsPanel.setLayout(new GridBagLayout());

        graphBtnsPanel.add(searchButton, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        graphBtnsPanel.add(deleteButton, new GridBagConstraints(1, 0, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        this.add(graphBtnsPanel, new GridBagConstraints(0, 3, 8, 1, 1, 0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
    }
}
