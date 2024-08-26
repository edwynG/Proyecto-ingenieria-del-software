package main.view.components.CommonComponents;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageAndComponent extends TransparentPanel {
    private JLabel icon;
    private Component component;

    public ImageAndComponent(String image, int width, int height, Component component) {
        icon = new LabelWithImage(new ImageIcon(image), width, height);
        this.component = component;
        inputImageAndComponent();
    }

    private void inputImageAndComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(this.icon, gbc);
        gbc.gridx = 1;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.BOTH;
        add(this.component, gbc);
    }

    public Component getInput() {
        return this.component;
    }

}
