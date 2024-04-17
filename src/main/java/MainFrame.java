import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

import Panel.*;

public class MainFrame extends JFrame {
    private JLabel appTitleLabel = new JLabel("Траектории - Траектория 1");
    private JSplitPane verticalSplitPane;
    private JSplitPane leftHorizontalSplitPane;
    private JSplitPane rightHorizontalSplitPane;

    private Preferences preferences = Preferences.userRoot().node("Trajectory");

    public MainFrame() {
        this.setTitle("Trajectory");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.setBounds(400, 200, 1300, 750);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());

        topPanel.add(appTitleLabel, new GridBagConstraints(0, 0, 2, 1, 1, 0,
                GridBagConstraints.NORTH, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 0), 0, 0));

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(new Color(91, 155, 213));

        MenuBar menuBar = new MenuBar();

        menuBar.getDefaultFramePosMenuItem().addActionListener(e -> defaultFramePosAction());
        menuBar.getSavePosMenuItem().addActionListener(e -> savePosAction());

        menuPanel.add(menuBar, new GridBagConstraints(0, 0, 1, 1, 1, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        topPanel.add(menuPanel, new GridBagConstraints(0, 1, 1, 1, 1, 0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        this.add(topPanel, BorderLayout.NORTH);

        leftHorizontalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        leftHorizontalSplitPane.setDividerLocation(preferences.getInt("leftHorizSplitPane", 325));
        leftHorizontalSplitPane.setContinuousLayout(true);
        leftHorizontalSplitPane.setTopComponent(new CatalogPanel());
        leftHorizontalSplitPane.setRightComponent(new FilePanel());

        rightHorizontalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        rightHorizontalSplitPane.setDividerLocation(preferences.getInt("rightHorizSplitPane", 325));
        rightHorizontalSplitPane.setContinuousLayout(true);
        rightHorizontalSplitPane.setTopComponent(new TablePanel());
        rightHorizontalSplitPane.setRightComponent(new GraphPanel());

        verticalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        verticalSplitPane.setDividerLocation(preferences.getInt("vertSplitPane", 400));
        verticalSplitPane.setContinuousLayout(true);
        verticalSplitPane.setLeftComponent(leftHorizontalSplitPane);
        verticalSplitPane.setRightComponent(rightHorizontalSplitPane);
        this.add(verticalSplitPane);
    }

    public void defaultFramePosAction() {
        preferences.putInt("vertSplitPane", 400);
        preferences.putInt("leftHorizSplitPane", 325);
        preferences.putInt("rightHorizSplitPane", 325);

        verticalSplitPane.setDividerLocation(400);
        leftHorizontalSplitPane.setDividerLocation(325);
        rightHorizontalSplitPane.setDividerLocation(325);
    }

    public void savePosAction() {
        preferences.putInt("vertSplitPane", verticalSplitPane.getDividerLocation());
        preferences.putInt("leftHorizSplitPane", leftHorizontalSplitPane.getDividerLocation());
        preferences.putInt("rightHorizSplitPane", rightHorizontalSplitPane.getDividerLocation());
    }
}
