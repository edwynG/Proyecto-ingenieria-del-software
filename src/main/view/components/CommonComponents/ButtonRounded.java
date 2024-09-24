package main.view.components.commonComponents;

import java.awt.Color;
import java.awt.Font;

import main.view.components.AbstractComponents.AbstractButtonRounded;

public class ButtonRounded extends AbstractButtonRounded {
    private int fontsizetext = 14;
    private String fontFamilyGlobal = "Arial";

    public ButtonRounded(String string) {
        super(string);
        initButtonRounded();

    }

    public ButtonRounded(String string, int radius) {
        super(string, radius);
        initButtonRounded();
    }

    private void initButtonRounded() {
        setFontWeightText(Font.BOLD);
        setFontSizeText(fontsizetext);
        setColorText(Color.WHITE);
        setFontFamilyText(this.fontFamilyGlobal);
    }
}
