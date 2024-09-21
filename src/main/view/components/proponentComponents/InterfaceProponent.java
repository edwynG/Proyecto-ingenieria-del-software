package main.view.components.proponentComponents;

import java.awt.Dimension;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.components.proponentComponents.Components.ActionsProponent;
import main.view.components.proponentComponents.Components.MyCourses;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class InterfaceProponent extends AbstractPanelRounded {
    private static TransparentPanel content;
    public static ActionsProponent actions;
    private int width = 800;
    private int height = 470;

    public InterfaceProponent(int radius) {
        super(radius);
        initInterfaceProponent();
    }

    private void initInterfaceProponent() {
        setBackground(ColorPalette.BG_COLOR_WRITE);
        actions = new ActionsProponent();
        setMinimumSize(new Dimension(width,height));
        restoreContent();
        restoreResize();
        createMyCourseHome();
    }

    public void resize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        revalidate();
        repaint();
    }

    public void createMyCourseHome() {
        restoreContent();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        MyCourses desing = new MyCourses();
        content.add(desing,gbc);

    }

    public void restoreResize() {
        resize(width, height);
    }

    public void restoreContent() {
        setLayout(new BorderLayout());
        if (content != null) {
            Components.removeElement(this, content);
        }
        content = new TransparentPanel();
        add(content, BorderLayout.CENTER);
    }
}
