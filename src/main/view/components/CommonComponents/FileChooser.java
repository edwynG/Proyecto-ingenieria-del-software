package main.view.components.CommonComponents;

import java.awt.Dimension;
import java.awt.Font;

import main.view.components.AbstractComponents.AbstractFileChooser;
import main.view.utils.ColorPalette;
import main.view.utils.RoundedBorder;

public class FileChooser extends AbstractFileChooser {
    private int roundedFileChooserGlobal = 13;
    private int width = 300;
    private int height = 40;

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
        RoundedBorder borde = new RoundedBorder(this.roundedFileChooserGlobal);
        borde.setBorderColor(ColorPalette.COLOR_FIELD);
        setBorder(borde);
        setColorText(ColorPalette.COLOR_FIELD);
        setRoundedBorder(this.roundedFileChooserGlobal);
        text.setFont(new Font(this.fontFamilyGlobal,Font.PLAIN,this.fontSizeTitle));
    }
}