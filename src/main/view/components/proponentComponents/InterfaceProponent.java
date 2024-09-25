package main.view.components.proponentComponents;

import java.awt.Dimension;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.Components.ProposingFile;
import main.view.components.proponentComponents.Components.CourseFormulation;
import main.view.components.proponentComponents.Components.CourseWithAval;
import main.view.components.proponentComponents.Components.MyCourses;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import main.view.utils.CustomVariables;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class InterfaceProponent extends AbstractPanelRounded {
    private static TransparentPanel content;
    public static ActionsProponent actions;
    private int width = 870;
    private int height = 470;
    int widthTemp;
    int heigthTemp;

    public InterfaceProponent(int radius) {
        super(radius);
        initInterfaceProponent();
    }

    private void initInterfaceProponent() {
        setBackground(ColorPalette.BG_COLOR_WRITE);
        actions = new ActionsProponent();
        setMinimumSize(new Dimension(width, height));
        restoreContent();
        redimentionRestore();
        widthTemp = width;
        heigthTemp = height;
        System.out.println("Bienvenido proponente");
        createMyCourseHome();
    }

    public void setRedimention(int width, int height) {
        Components.setRedimentionComponent(this, width, height);
    }

    public void createMyCourseHome() {
        restoreContent();
        redimentionRestore();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        MyCourses desing = new MyCourses();
        content.add(desing, gbc);
        System.out.println("Mis cursos");

    }

    public void createCourseFormulation() {
        restoreContent();
        redimentionRestore();
        widthTemp = width;
        heigthTemp = 520;
        setRedimention(widthTemp, heigthTemp);
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        CourseFormulation desing = new CourseFormulation(CustomVariables.RADIO_DEFAULT_PANEL);
        content.add(desing, gbc);
        System.out.println("Formulación de cursos");

    }

    public void createCourseWithAval() {
        restoreContent();
        redimentionRestore();
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        CourseWithAval desing = new CourseWithAval();
        content.add(desing, gbc);
        System.out.println("Cursos con aval");

    }

    public void createProposingFile() {
        restoreContent();
        widthTemp = 870;
        heigthTemp = height;
        setRedimention(widthTemp, heigthTemp);
        content.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(25, 35, 25, 35);
        ProposingFile desing = new ProposingFile();
        content.add(desing, gbc);
        System.out.println("Expediente del proponente");

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
