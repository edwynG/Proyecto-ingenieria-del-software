package main.view.components.commonComponents;


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
        setConfig(new Font(fontFamilyGlobal, Font.BOLD, fontSizeTitle));
        setForeground(ColorPalette.COLOR_TITLE);
        
    }
}
