package main.view.components.CommonComponents;

import main.view.components.AbstractComponents.AbstractInputText;
import main.view.utils.ColorPalette;
import main.view.utils.Components;




public class InputText extends AbstractInputText{

    public InputText(int comluns, String placeholder){
        super(comluns,placeholder);
        this.initInput();
    }

    public void initInput(){
        setBorderField(Components.customrBorder(10, ColorPalette.COLOR_PRIMARY));
        
    }


}
