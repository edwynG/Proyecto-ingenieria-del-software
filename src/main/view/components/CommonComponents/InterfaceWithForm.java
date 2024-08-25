package main.view.components.CommonComponents;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.AbstractComponents.AbstractPanelRounded;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

public class InterfaceWithForm extends AbstractPanelRounded {
    private static JPanel containerImage;
    private static JPanel containerForm;
    private static AbstractForm formulation;
    private static JLabel image; 

    public InterfaceWithForm() {
        super(0);
        initLogin();
    }

    public InterfaceWithForm(String src) {
        super(0);
        initLogin(src);
      
    }
   
    private void initLogin() {
        this.config();
        setLayout(new GridLayout(1,1));
        add(containerForm);
    }

    private void initLogin(String src) {
        this.config();
        setLayout(new GridLayout(1, 2, 0, 10));
        setImage(src);
        add(containerImage);
        add(containerForm);
        configContainerImage(containerImage);
    }

    private void config(){
        containerImage = new TransparentPanel();
        containerForm = new TransparentPanel();
        image = new JLabel();
        setBackgroundRect(ColorPalette.COLOR_SENCOD);
        setPreferredSize(new Dimension(600,500));
    }

    private void configContainerImage(JPanel container) {
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        container.add(image, gbc);
    }
   
    private static void configContainerForm(JPanel container) {
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(50, 50, 50, 50);
        container.add(formulation, gbc);

    }

    public void setImage(String path){
        ImageIcon img = new ImageIcon(path);
        image.setIcon(img);
        revalidate();
        repaint();
    }

    public static void clearContainerForm() {
      Components.removeElement(containerImage, formulation);
        
    }

    public static void clearContainerImage() {
      Components.removeElement(containerImage, image);
    }

    public static AbstractForm getForm(){
        return formulation;
    }

    public static JLabel getImage(){
        return image;
    }

    public static JPanel getContainerForm(){
        return containerForm;
    }

    public static JPanel getContainerImage(){
        return containerImage;
    }

    public static void setFormulation(AbstractForm form){
        if (formulation != null) {
            Components.removeElement(containerForm,formulation);
        }
        
        formulation = form;
        configContainerForm(containerForm);
    }

}
