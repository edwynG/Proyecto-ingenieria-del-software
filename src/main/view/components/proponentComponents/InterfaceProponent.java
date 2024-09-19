package main.view.components.proponentComponents;

import java.awt.Dimension;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import java.awt.BorderLayout;

public class InterfaceProponent extends AbstractPanelRounded {
    private static TransparentPanel content;
    private int width = 800;
    private int height = 400;

    public InterfaceProponent(int radius) {
        super(radius);
        initInterfaceProponent();
    }

    private void initInterfaceProponent() {
        setBackground(ColorPalette.BG_COLOR_WRITE);
        content = new TransparentPanel();
        restoreContent();
        restoreResize();
    }

    public void resize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        revalidate();
        repaint();
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
