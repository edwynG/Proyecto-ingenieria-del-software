package main.view.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

 public class RoundedBorder implements Border {
    private Integer radius;
    private Color backgroundColor;
    private Color borderColor;

    
    public RoundedBorder(int radius) {
        this.radius = radius;
        this.backgroundColor = ColorPalette.TRANSPARENT;
        this.borderColor = Color.BLACK;
    
    }
    

    public RoundedBorder(int radius, Color bgColor) {
        this.radius = radius;
        this.backgroundColor = bgColor;
        this.borderColor = Color.BLACK;
    
    }

    public RoundedBorder(int radius, Color bgColor, Color borderColor) {
        this.radius = radius;
        this.backgroundColor = bgColor;
        this.borderColor = borderColor;
    
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // Pintar el fondo
        g.setColor(backgroundColor);
        g.fillRoundRect(x, y, width - 1, height - 1, this.radius, this.radius);

        // Pintar el borde
        g.setColor(this.borderColor); // Color del borde
        g.drawRoundRect(x, y, width - 1, height - 1, this.radius, this.radius);
    }

    public void setBorderColor( Color color){
        this.borderColor = color;
    }

    public Color getBorderColor(){
        return this.borderColor;
    }

    public void setBorderRounded( Integer rounded){
        this.radius = rounded;
    }

    
    public Integer getBorderRounded(){
        return this.radius;
    }

    public void setBackgroundRect(Color color){
        this.backgroundColor = color;
    }

    public Color getBackgroundRect(){
        return this.backgroundColor;
    }

}
