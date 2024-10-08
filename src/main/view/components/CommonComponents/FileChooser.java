package main.view.components.commonComponents;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import main.Env;
import main.view.components.AbstractComponents.AbstractFileChooser;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import main.view.utils.RoundedBorder;
import raven.glasspanepopup.GlassPanePopup;

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
        setPreferredSize(new Dimension(width, height));
        setBackground(ColorPalette.TRANSPARENT);
        borde = Components.customrBorder(roundedFileChooserGlobal, ColorPalette.COLOR_FIELD);
        setBorder(borde);
        textColor = ColorPalette.COLOR_FIELD;
        setColorText(textColor);
        setRoundedBorder(roundedFileChooserGlobal);
        text.setFont(new Font(fontFamilyGlobal, Font.PLAIN, fontSizeTitle));
        for (int i = 0; i < Env.EXTESIONS_NAMES.length; i++) {
            filterExtension.put(Env.EXTESIONS_NAMES[i], Env.EXTESIONS_EXT[i]);
        }

    }

    @Override
    protected void uploadApprovateFile() {
        setBorder(borde);
        text.setForeground(textColor);
        setIcon(Env.PATH_ICON_CHECK);
    }

    @Override
    protected void uploadDisapprovedFile() {
        setBorder(Components.customrBorder(roundedDefault,Color.red));
        text.setForeground(Color.red);
        setIcon(Env.PATH_ICON_ERROR);
    }

    @Override
    protected void downloadDisapprovedFile() {
        GlassPanePopup.showPopup(new CardMessage("Formato no valido","El archivo no es valido."));
    }
}