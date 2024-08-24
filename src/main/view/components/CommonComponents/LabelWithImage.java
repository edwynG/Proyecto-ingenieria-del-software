package main.view.components.CommonComponents;



import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelWithImage extends JLabel{
 
    private Image image;

    public LabelWithImage(ImageIcon icon, int width, int height) {
        this.image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(image));
        setPreferredSize(new Dimension(width,height));
    }

}
