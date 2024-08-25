package main.view.components.AbstractComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import main.view.utils.RoundedBorder;

public class AbstractInputText extends AbstractEffectFields {
    protected RoundedBorder configBorder;
    
    public AbstractInputText(int comluns) {
        super(comluns);
        initAbstractInputText();
    }
    public AbstractInputText(int comluns, String placeholder) {
        super(comluns,placeholder);
        initAbstractInputText();

    }

    public void initAbstractInputText() {
        this.configBorder = new RoundedBorder(0);
        setMinimumSize(new Dimension(200,30));
        setBorder(this.configBorder);
    
    }

    public void setColorText(Color color) {
        setForeground(color);
    }

    public void setFontSizeText(int size) {
        Font font = this.getFont();
        setFont(new Font(font.getName(), font.getStyle(), size));
    }

    public void setFontFamilyText(String family) {
        Font font = this.getFont();
        setFont(new Font(family, font.getStyle(), font.getSize()));
    }

    public void setFontWeightText(int weight) {
        Font font = this.getFont();
        setFont(new Font(font.getName(), weight, font.getSize()));
    }

    public void setRoundedField(int radius) {
        this.configBorder.setBorderRounded(radius);
        setBorder(new RoundedBorder(this.configBorder.getBorderRounded(), getBackground()));
        revalidate();
        repaint();
    }

    public void setBorderColorField(Color color) {
        this.configBorder.setBorderColor(color);
        setBorder(new RoundedBorder(this.configBorder.getBorderRounded(), configBorder.getBackgroundRect(),
                configBorder.getBorderColor()));
        revalidate();
        repaint();
    }

    public int getBorderRounded() {
        return this.configBorder.getBorderRounded();
    }

    public void setBorderField(RoundedBorder borde) {
        this.configBorder = borde;
        setBorder(borde);
    }

    public Color getColorBorderField() {
        return this.configBorder.getBorderColor();
    }


}