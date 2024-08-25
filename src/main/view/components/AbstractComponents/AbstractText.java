package main.view.components.AbstractComponents;

import java.awt.Font;


public class AbstractText extends AbstractEffectText{
   
    public AbstractText(String string){
        super(string);
        initAbtractText();
    }

    public AbstractText(String string, int position){
        super(string,position);
        initAbtractText();
    }

    private void initAbtractText(){
    
    }

    public void setFontSize(int size){
        setFont(new Font(config.getName(), config.getStyle(),size));
    }

    public void setFontWeight(int weight){
        setFont(new Font(config.getName(),weight,config.getSize()));
    }

    public void setFontFamlily(String family){
        setFont(new Font(family, config.getStyle(),config.getSize()));
    }

    public String getText(){
        return this.text;
    }

    public void setConfig(Font style){
        this.config=style;
    }

}
