package main.view.components.CommonComponents;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageAndComponent extends TransparentPanel {
    private JLabel icon;
    private Component component;

    public ImageAndComponent(String image, int width, int height, Component component) {
        icon = new LabelWithImage(new ImageIcon(image), width, height);
        this.component = component;
        initImageAndComponent();
    }

    private void initImageAndComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = this.getGapIcon();
        add(this.icon, gbc);
        gbc.insets = this.getGapComponent();
        gbc.gridx = 1;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.BOTH;
        add(this.component, gbc);
    }

    public Component getInput() {
        return this.component;
    }

    public Insets getGapIcon(){
        return new Insets(0,0,0,0);
    }

    public Insets getGapComponent(){
        return new Insets(0,0,0,0);
    }

}
