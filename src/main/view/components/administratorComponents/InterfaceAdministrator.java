package main.view.components.administratorComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.administratorComponents.components.ExtensionAddress;
import main.view.components.administratorComponents.components.ExtensionCommission;
import main.view.components.administratorComponents.components.FacultyCouncil;
import main.view.components.administratorComponents.components.OutreachCoordination;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class InterfaceAdministrator extends AbstractPanelRounded {
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
        System.out.println("Bienvenido administrador!!");
        createFacultyCouncil();

    }

    public void createOutreachCoordination() {
        restoreContent();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        OutreachCoordination desing = new OutreachCoordination();
        content.add(desing, gbc);
        System.out.println("Coordinación de extensión");
    }

    public void createExtensionAddress() {
        restoreContent();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        ExtensionAddress desing = new ExtensionAddress();
        content.add(desing, gbc);
        System.out.println("Dirección de extensión");

    }

    public void createExtensionCommission() {
        restoreContent();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        ExtensionCommission desing = new ExtensionCommission();
        content.add(desing, gbc);
        System.out.println("Comisión de extensión");

    }

    public void createFacultyCouncil() {
        restoreContent();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        FacultyCouncil desing = new FacultyCouncil();
        content.add(desing, gbc);
        System.out.println("Consejo de facultad");
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
