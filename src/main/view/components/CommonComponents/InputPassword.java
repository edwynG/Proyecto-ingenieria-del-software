
package main.view.components.commonComponents;


import main.view.components.AbstractComponents.AbstractInputPassword;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class InputPassword extends AbstractInputPassword {
    private String fontFamilyGlobal = "Arial";
    private int roundedInputGlobal = 13;
    private int fontSize = 13;


    public InputPassword(int comluns, String placeholder) {
        super(comluns, placeholder);
        initInputPassword();

    }

    public void initInputPassword() {
        setConfigBorder(Components.customrBorder(roundedInputGlobal, ColorPalette.COLOR_PRIMARY));
        setFontFamilyText(fontFamilyGlobal);
        setBorderColorField(ColorPalette.COLOR_FIELD);
        setForeground(ColorPalette.COLOR_FIELD);
        setFontSizeText(fontSize);

        
    }

}