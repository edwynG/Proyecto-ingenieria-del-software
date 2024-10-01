package main.view.components.commonComponents;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import main.Env;
import main.view.components.AbstractComponents.AbstractFileChooser;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import main.view.utils.RoundedBorder;

public class FileChooser extends AbstractFileChooser {
    private int roundedFileChooserGlobal = 13;
    private int width = 300;
    private int height = 40;
    RoundedBorder borde;
    Color textColor;
    private String fontFamilyGlobal = "Arial";
    private int fontSizeTitle = 13;

    public FileChooser(String text) {
        super(text);
        initFileChooser();
    }

    public FileChooser(String text, int rounded) {
        super(text, rounded);
        initFileChooser();
    }

    public void initFileChooser() {
        setPreferredSize(new Dimension(this.width, this.height));
        setBackground(ColorPalette.TRANSPARENT);
        borde = Components.customrBorder(roundedFileChooserGlobal, ColorPalette.COLOR_FIELD);
        setBorder(borde);
        this.textColor = ColorPalette.COLOR_FIELD;
        setColorText(textColor);
        setRoundedBorder(this.roundedFileChooserGlobal);
        text.setFont(new Font(this.fontFamilyGlobal, Font.PLAIN, this.fontSizeTitle));
        filterExtension.put("Archivo TXT", ".txt");

    }

    @Override
    protected void ApprovateFile() {
        setBorder(borde);
        text.setForeground(textColor);
        setIcon(Env.PATH_ICON_CHECK);
    }

    @Override
    protected void DisapprovedFile() {
        setBorder(Components.customrBorder(roundedDefault,Color.red));
        text.setForeground(Color.red);
        setIcon(Env.PATH_ICON_ERROR);
    }
}