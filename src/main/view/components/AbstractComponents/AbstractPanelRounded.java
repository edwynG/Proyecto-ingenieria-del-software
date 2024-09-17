package main.view.components.AbstractComponents;

import main.view.utils.RoundedBorder;
import java.awt.Color;

import javax.swing.JPanel;

public abstract class AbstractPanelRounded extends JPanel {

    private RoundedBorder configBorder;

    public AbstractPanelRounded() {
        this.configBorder = new RoundedBorder(12, getBackground(),getBackground());
        initAbstractPanelRounded();
    }

    public AbstractPanelRounded(int rounded) {
        this.configBorder = new RoundedBorder(rounded, getBackground(),getBackground());
        initAbstractPanelRounded();

    }

    private void initAbstractPanelRounded() {
        setOpaque(false);
        setBorder(this.configBorder);
    }

    public void setBorderColor(Color color) {
        this.configBorder.setBorderColor(color);
        setBorder(this.configBorder);
    }

    public Color getBorderColor() {
        return this.configBorder.getBorderColor();
        
    }

    public void setBackgroundRect(Color color) {
        this.configBorder.setBackgroundRect(color);
        setBorder(this.configBorder);
    }

    public Color getBackgroundRect() {
        return this.configBorder.getBackgroundRect();

    }

    public void setBorderRounded(Integer rounded) {
        this.configBorder.setBorderRounded(rounded);
        setBorder(this.configBorder);
    }

    public int getBorderRounded() {
        return this.configBorder.getBorderRounded();
    }

    public void setConfigBorder(RoundedBorder borde) {
        this.configBorder = borde;
        setBorder(borde);
    }

}
