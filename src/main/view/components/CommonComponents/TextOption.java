package main.view.components.CommonComponents;

import java.awt.Color;
import java.awt.Font;

import main.view.components.AbstractComponents.AbstractText;

public class TextOption extends AbstractText{
    private String fontFamilyGlobal = "Arial";
    private int fontSizeOptionPassword = 11;


    public TextOption(String string){
        super(string);
        initTextOption();
    }

    public TextOption(String string, int position){
        super(string,position);
        initTextOption();
    }

    private void initTextOption(){
        setConfig(new Font(this.fontFamilyGlobal, Font.PLAIN, this.fontSizeOptionPassword));
        addEffectHover(Color.BLUE);
    }
}
