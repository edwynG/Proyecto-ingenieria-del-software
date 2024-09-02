package main.view.components;

import main.view.utils.ColorPalette;
import main.view.utils.Components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.CommonComponents.TransparentPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class InterfaceWithoutAppbar extends AbstractPanelRounded {
    private static TransparentPanel containerImage;
    private static TransparentPanel containerForm;
    private static TransparentPanel contentForm;
    public static int maxWidthFormulation = 520;
    public static int maxHeightFormulation = 550;
    public static int minWidthFormulation = 460;
    public static int minHeightFormulation = 480;

    public static int minWidthInterface = 900;
    public static int minHeightInterface = 530;

    private static AbstractForm formulation;
    private static JLabel image;

    public InterfaceWithoutAppbar(String src) {
        super(0);
        initInterfaceWithoutAppbar(src);

    }

    private void initInterfaceWithoutAppbar(String src) {
        this.configInterfaceWithoutAppbar();
        this.setImage(src);
        this.configLayoutDefault();
        this.configContainerImage(containerImage);

    }

    private void configLayoutDefault() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(containerImage, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(containerForm, gbc);
    }

    private void configInterfaceWithoutAppbar() {
        containerImage = new TransparentPanel();
        containerForm = new TransparentPanel();
        image = new JLabel();
        setBackgroundRect(ColorPalette.COLOR_SENCOD);
        setPreferredSize(new Dimension(minWidthInterface, minHeightInterface));
    }

    private void configContainerImage(TransparentPanel container) {
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        container.add(image, gbc);
    }

    private static void configContainerForm(TransparentPanel container) {
        contentForm = new TransparentPanel();
        container.setLayout(new GridBagLayout());
        contentForm.setLayout(new GridBagLayout());

        // configuracion para el container
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(50, 55, 50, 55);
        container.add(contentForm, gbc);

        // Configuracion container
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BASELINE;

        contentForm.add(formulation, gbc);
        formulation.setPreferredSize(new Dimension(maxWidthFormulation, maxHeightFormulation));
        formulation.setMinimumSize(new Dimension(minWidthFormulation, minHeightFormulation));

    }

    public static void clearContainerForm() {
        Components.removeElement(containerForm, contentForm);

    }

    public static AbstractForm getFormulation() {
        return formulation;
    }

    public void setImage(String path) {
        ImageIcon img = new ImageIcon(path);
        image.setIcon(img);
        revalidate();
        repaint();
    }

    public static void setFormulation(AbstractForm form) {
        if (formulation != null) {
            Components.removeElement(contentForm, formulation);
        }
        formulation = form;
        configContainerForm(containerForm);
    }

}
