package main.view.components.CommonComponents;

import java.awt.Font;

import main.view.components.AbstractComponents.AbstractText;
import main.view.utils.ColorPalette;

public class TextTitle extends AbstractText {

    private String fontFamilyGlobal = "Arial";
    private int fontSizeTitle = 40;

    public TextTitle(String string) {
        super(string);
        initJText();
    }

    public TextTitle(String string, int position) {
        super(string, position);
        initJText();
    }

    private void initJText() {
        setConfig(new Font(this.fontFamilyGlobal, Font.BOLD, this.fontSizeTitle));
        setForeground(ColorPalette.COLOR_TITLE);
    }
}
