package main.view.components.AbstractComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import main.view.utils.RoundedBorder;

public class AbstractInputPassword extends AbstractEffectFieldsPassword {
    protected RoundedBorder configBorder;

    public AbstractInputPassword(int comluns) {
        super(comluns);
        initAbstractInputPassword();
    }

    public AbstractInputPassword(int comluns, String placeholder) {
        super(comluns, placeholder);
        initAbstractInputPassword();
    }

    private void initAbstractInputPassword() {
        configBorder = new RoundedBorder(0);
        setMinimumSize(new Dimension(200, 30));
        setPreferredSize(new Dimension(200, 40));
        setBorder(configBorder);
    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }

    public void setColorText(Color color) {
        setForeground(color);
    }

    public void setFontSizeText(int size) {
        Font font = getFont();
        setFont(new Font(font.getName(), font.getStyle(), size));
    }

    public void setFontFamilyText(String family) {
        Font font = getFont();
        setFont(new Font(family, font.getStyle(), font.getSize()));
    }

    public void setFontWeightText(int weight) {
        Font font = getFont();
        setFont(new Font(font.getName(), weight, font.getSize()));
    }

    public void setRoundedField(int radius) {
        configBorder.setBorderRounded(radius);
        setBorder(configBorder);
        revalidate();
        repaint();
    }

    public void setBorderColorField(Color color) {
        configBorder.setBorderColor(color);
        setBorder(configBorder);
        revalidate();
        repaint();
    }

    public int getBorderRounded() {
        return configBorder.getBorderRounded();
    }

    public void setConfigBorder(RoundedBorder borde) {
        configBorder = borde;
        setBorder(borde);
    }

    public Color getColorBorderField() {
        return configBorder.getBorderColor();
    }

    public String getInput() {
        return getText().equals(getPlaceholder()) ? "" : getText();
    };

}