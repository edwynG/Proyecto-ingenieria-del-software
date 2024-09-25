package main.view.components.administratorComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.ColorPalette;
import main.view.utils.Components;



public class InterfaceAdministrator extends AbstractPanelRounded{
     private static TransparentPanel content;
    public static ActionsAdministrator actions;
    private int width = 870;
    private int height = 470;
    int widthTemp;
    int heigthTemp;

    public InterfaceAdministrator(int radius) {
        super(radius);
        initInterfaceProponent();
    }

    private void initInterfaceProponent() {
        setBackground(ColorPalette.BG_COLOR_WRITE);
        actions = new ActionsAdministrator();
        setMinimumSize(new Dimension(width, height));
        restoreContent();
        redimentionRestore();
        widthTemp = width;
        heigthTemp = height;
    
    }

    public void setRedimention(int width, int height) {
        Components.setRedimentionComponent(this, width, height);
    }


    public void redimentionRestoreTemp() {
        setRedimention(widthTemp, heigthTemp);
    }

    public void redimentionRestore() {
        widthTemp = width;
        heigthTemp = height;
        setRedimention(width, height);
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
