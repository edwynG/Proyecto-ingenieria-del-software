package main.view.utils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;

public class Components {

   public static void removeElement(JComponent context, JComponent component) {
      context.remove(component);
      context.revalidate();
      context.repaint();
   }

   public static void removeElementAll(JComponent context) {
      context.removeAll();
      context.revalidate();
      context.repaint();
   }

   public static void setRedimentionComponent(JComponent context, int width, int height) {
      context.setPreferredSize(new Dimension(width, height));
      context.revalidate();
      context.repaint();
   }

   public static RoundedBorder customrBorder(int radius, Color color) {
      RoundedBorder CUSTOM_BORDER = new RoundedBorder(radius, ColorPalette.TRANSPARENT);
      CUSTOM_BORDER.setBorderColor(color);
      return CUSTOM_BORDER;
   }

}
