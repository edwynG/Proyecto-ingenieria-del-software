package main.view.components.commonComponents;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultListModel;

import main.view.components.AbstractComponents.AbstractDropdown;
import main.view.utils.ColorPalette;
import main.view.utils.RoundedBorder;



public class Dropdown extends AbstractDropdown {

    private int widthDropdown = 195;
    private int heightDropdown = 40;
    private String fontFamilyGlobal = "Arial";
    private int borderInputGlobal = 13;

    public Dropdown(String text) {
        super(text);
        initDropdown();
    }

    public Dropdown(String text, DefaultListModel<String> model) {
        super(text,model);
        initDropdown();
    }

    public Dropdown(String text, int width) {
        super(text);
        widthDropdown = width;
        initDropdown();
    }

    private void initDropdown() {
        RoundedBorder borde = new RoundedBorder(borderInputGlobal);
        borde.setBorderColor(ColorPalette.COLOR_FIELD);
        setBorder(borde);
        setStyleTitle(new Font(fontFamilyGlobal, Font.PLAIN, borderInputGlobal));
        setPreferredSize(new Dimension(widthDropdown, heightDropdown));
        setColorText(ColorPalette.COLOR_FIELD);
        setBackground(ColorPalette.TRANSPARENT);
        options.setSelectionBackground(Color.LIGHT_GRAY);
        options.setSelectionForeground(Color.WHITE);

    }
}
