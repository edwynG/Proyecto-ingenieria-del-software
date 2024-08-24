package main.view.utils;

import java.awt.Color;

import javax.swing.JComponent;

public class Components {
   
   public static void removeElement(JComponent context, JComponent container){
        context.remove(container);
        context.revalidate();
        context.repaint();
   }

   public static RoundedBorder  customrBorder( int radius, Color color){
      RoundedBorder CUSTOM_BORDER = new RoundedBorder(radius,ColorPalette.TRANSPARENT);
      CUSTOM_BORDER.setBorderColor(color);
      return CUSTOM_BORDER;
   }
}
