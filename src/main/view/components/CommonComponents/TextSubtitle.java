package main.view.components.CommonComponents;

import java.awt.Font;

import main.view.components.AbstractComponents.AbstractText;

public class TextSubtitle extends AbstractText {

    private String fontFamilyGlobal = "Arial";
    private int fontSizeSubTitle = 12;


    public TextSubtitle(String string) {
        super(string);
        initTextSubtitle();
    }

    public TextSubtitle(String string, int position) {
        super(string, position);
        initTextSubtitle();
    }

    private void initTextSubtitle() {

        setConfig(new Font(this.fontFamilyGlobal, Font.PLAIN, this.fontSizeSubTitle));

    }
}
