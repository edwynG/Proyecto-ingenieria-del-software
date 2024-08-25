package main.view.components.CommonComponents;

import main.view.components.AbstractComponents.AbstractButtonRounded;

public class ButtonRounded extends AbstractButtonRounded{
    
    public ButtonRounded(String string) {
        super(string);
        initButtonRounded();

       
    }
    public ButtonRounded(String string, int radius) {
        super(string,radius);
        initButtonRounded();
    }

    private void initButtonRounded(){

    }
}
