
package main.view.components.CommonComponents;


import main.view.components.AbstractComponents.AbstractInputPassword;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class InputPassword extends AbstractInputPassword {
    private String fontFamilyGlobal = "Arial";
    private int borderInputGlobal = 13;

    public InputPassword(int comluns, String placeholder) {
        super(comluns, placeholder);
        this.initInputPassword();

    }

    public void initInputPassword() {
        setConfigBorder(Components.customrBorder(this.borderInputGlobal, ColorPalette.COLOR_PRIMARY));
        setFontFamilyText(this.fontFamilyGlobal);
        setBorderColorField(ColorPalette.COLOR_FIELD);
        
    }

}