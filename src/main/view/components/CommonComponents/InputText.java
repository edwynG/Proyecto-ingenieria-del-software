package main.view.components.CommonComponents;

import main.view.components.AbstractComponents.AbstractInputText;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class InputText extends AbstractInputText {

    private String fontFamilyGlobal = "Arial";
    private int roundedInputGlobal = 13;
    private int fontSize = 13;


    public InputText(int comluns, String placeholder) {
        super(comluns, placeholder);
        this.initInput();
    }

    public void initInput() {
        setConfigBorder(Components.customrBorder(this.roundedInputGlobal, ColorPalette.COLOR_PRIMARY));
        setFontFamilyText(this.fontFamilyGlobal);
        setBorderColorField(ColorPalette.COLOR_FIELD);
        setForeground(ColorPalette.COLOR_FIELD);
        setFontSizeText(this.fontSize);
       
    }

}
