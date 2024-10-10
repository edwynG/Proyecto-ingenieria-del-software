package main.view.components.commonComponents;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.utils.ColorPalette;

public class TransparentPanel extends AbstractPanelRounded{
    
    public TransparentPanel(){
        super(0);
        setBackground(ColorPalette.TRANSPARENT);
  
    }
}
