package main.view.components.CommonComponents;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;

import main.view.components.AbstractComponents.AbstractDropdown;
import main.view.utils.ColorPalette;
import main.view.utils.RoundedBorder;

public class Dropdown extends AbstractDropdown {

    private int widthDropdown = 195;
    private int heightDropdown = 40;
    private String fontFamilyGlobal = "Arial";
    private int borderInputGlobal = 13;

    public Dropdown(JComponent context, String text) {
        super(context, text);
        initDropdown();
    }

    public Dropdown(JComponent context, String text, int width) {
        super(context,text);
        this.widthDropdown = width;
        initDropdown();
    }

    private void initDropdown() {
        RoundedBorder borde = new RoundedBorder(borderInputGlobal);
        borde.setBorderColor(ColorPalette.COLOR_FIELD);
        setBorder(borde);
        setStyleTitle(new Font(this.fontFamilyGlobal, Font.PLAIN, this.borderInputGlobal));
        setPreferredSize(new Dimension(this.widthDropdown, this.heightDropdown));
        setColorText(ColorPalette.COLOR_FIELD);
        setBackground(ColorPalette.TRANSPARENT);

    }
}
