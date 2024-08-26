package main.view.components.CommonComponents;

import main.view.components.AbstractComponents.AbstractInputText;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class InputText extends AbstractInputText {

    private String fontFamilyGlobal = "Arial";
    private int borderInputGlobal = 13;

    public InputText(int comluns, String placeholder) {
        super(comluns, placeholder);
        this.initInput();
    }

    public void initInput() {
        setConfigBorder(Components.customrBorder(this.borderInputGlobal, ColorPalette.COLOR_PRIMARY));
        setFontFamilyText(this.fontFamilyGlobal);
        setBorderColorField(ColorPalette.COLOR_FIELD);

    }

}
