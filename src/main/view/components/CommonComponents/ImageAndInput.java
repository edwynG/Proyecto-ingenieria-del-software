package main.view.components.CommonComponents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ImageAndInput extends TransparentPanel {
    private  JLabel icon;
    private JTextField input;
    
    public ImageAndInput(String image,int width, int height, JTextField input) {
        icon = new LabelWithImage(new ImageIcon(image), width, height);
        this.input = input;
        initImagenAndInput();
    }

    private void initImagenAndInput(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx =0;
        gbc.gridy=0;
        add(this.icon,gbc);
        gbc.gridx=1;
        add(this.input,gbc);
    }

    public JTextField getInput(){
        return this.input;
    }

}
