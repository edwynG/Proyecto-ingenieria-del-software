package main.view.components.CommonComponents;



import java.awt.FlowLayout;

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
        setLayout(new FlowLayout());
        add(this.icon);
        add(this.input);
    }

    public JTextField getInput(){
        return this.input;
    }

}
