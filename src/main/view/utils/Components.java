package main.view.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Components {

   public static void removeElement(JComponent context, JComponent component) {
      context.remove(component);
      repaintComponent(context);
   }

   public static void removeElementAll(JComponent context) {
      context.removeAll();
      repaintComponent(context);
   }

   public static void setRedimentionComponent(JComponent context, int width, int height) {
      context.setPreferredSize(new Dimension(width, height));
      repaintComponent(context);
   }

   public static RoundedBorder customrBorder(int radius, Color color) {
      RoundedBorder CUSTOM_BORDER = new RoundedBorder(radius, ColorPalette.TRANSPARENT);
      CUSTOM_BORDER.setBorderColor(color);
      return CUSTOM_BORDER;
   }

   public static void repaintComponent(JComponent component) {
      component.revalidate();
      component.repaint();
   }

   public static Image getClassImage(Component env,String path){
       InputStream is = env.getClass().getResourceAsStream(path);
        if (is != null) {
           try {
                BufferedImage image = ImageIO.read(is);
                ImageIcon icon = new ImageIcon(image);
                return icon.getImage();
            } catch (IOException e) {
                System.out.println("Error al cargar la imagen: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo encontrar la imagen.");
        }
        return null;
   }
}
