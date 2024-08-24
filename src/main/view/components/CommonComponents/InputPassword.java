
package main.view.components.CommonComponents;


import main.view.components.AbstractComponents.AbstractInputPassword;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class InputPassword extends AbstractInputPassword {

    public InputPassword(int comluns, String placeholder) {
        super(comluns, placeholder);
        this.initInputPassword();

    }

    public void initInputPassword() {
        setBorderField(Components.customrBorder(10, ColorPalette.COLOR_PRIMARY));

        
    }

}