package main.view.components.AbstractComponents;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.components.CommonComponents.InputPassword;

public abstract class AbstractForm extends AbstractPanelRounded {

    private ArrayList<JTextField> inputList;
    private TransparentPanel content;

    public AbstractForm(int rounded) {
        super(rounded);
        initAbstractForm();
    }

    public AbstractForm() {
        initAbstractForm();
    }

    private void initAbstractForm() {
        setPreferredSize(new Dimension(300, 400));
        this.inputList = new ArrayList<>();
        this.configDefauld();
    }

    protected InputText createInputText(String placeholder, int columns) {
        InputText input = new InputText(columns, placeholder);
        input.addEffectPlaceHolder();
        return input;

    }

    protected InputPassword createInputPassword(String placeholder, int columns) {
        InputPassword input = new InputPassword(columns, placeholder);
        input.addEffectPlaceHolder();
        return input;
    }

    protected void setRedimentionFields(JTextField input, int columns, int height) {
        input.setColumns(columns);
        input.setPreferredSize(new Dimension(input.getWidth(), height));
        revalidate();
        repaint();
    }

    protected void setRedimentionButton(JPanel btn, int width, int height){
        btn.setPreferredSize(new Dimension(width,height));
        revalidate();
        repaint();
    }

    protected void configDefauld() {
        setBorderColor(getBackgroundRect());
        this.content = new TransparentPanel();
        this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
        setBorderColor(getBackgroundRect());
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(content, gbc);
    }
    
    public void addContent(Component component){
        this.content.add(component);
    }

    public void removeContent(Component component){
        this.content.remove(component);
        this.content.revalidate();
        this.content.repaint();
    }
    
    public void addInputList(JTextField input){
        this.inputList.add(input);
    }

    public ArrayList<JTextField> getInputList(){
        return this.inputList;
    }

    protected abstract void customInput(AbstractInputText input);

}