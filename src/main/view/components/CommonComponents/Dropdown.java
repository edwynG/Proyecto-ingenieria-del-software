package main.view.components.CommonComponents;

import java.awt.Dimension;
import java.awt.Font;

import main.view.components.AbstractComponents.AbstractDropdown;
import main.view.utils.ColorPalette;

public class Dropdown extends AbstractDropdown {

    private int widthDropdown = 195;
    private int heightDropdown = 40;
    private String fontFamilyGlobal = "Arial";
    private int borderInputGlobal = 13;

    public Dropdown(String text) {
        super(text);
        initDropdown();
    }
    public Dropdown(String text, int width) {
        super(text);
        this.widthDropdown = width;
        initDropdown();
    }

    private void initDropdown() {
        setBorderColor(ColorPalette.COLOR_FIELD);
        setStyleTitle(new Font(this.fontFamilyGlobal, Font.PLAIN, this.borderInputGlobal));
        setPreferredSize(new Dimension(this.widthDropdown, this.heightDropdown));
        setColorText(ColorPalette.COLOR_FIELD);
    }
}
