package main.view.components.AbstractComponents;

import java.awt.Font;

public abstract class AbstractText extends AbstractEffectText {

    public AbstractText(String string) {
        super(string);
        initAbtractText();
    }

    public AbstractText(String string, int position) {
        super(string, position);
        initAbtractText();
    }

    private void initAbtractText() {

    }

    public void setFontSize(int size) {
        config = new Font(config.getName(), config.getStyle(), size);
        setFont(config);
    }

    public void setFontWeight(int weight) {
        config = new Font(config.getName(), weight, config.getSize());
        setFont(config);
    }

    public void setFontFamlily(String family) {
        config = new Font(family, config.getStyle(), config.getSize());
        setFont(config);
    }

    public String getText() {
        return this.text;
    }

    public void setConfig(Font style) {
        this.config = style;
        setFont(style);
    }

}
