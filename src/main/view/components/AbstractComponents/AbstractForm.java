package main.view.components.AbstractComponents;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.utils.ColorPalette;
import main.view.components.CommonComponents.InputPassword;

public abstract class AbstractForm extends AbstractPanelRounded {

    private ArrayList<JTextField> inputList;
    private TransparentPanel content;
    protected int upperLimit = 450;
    protected int lowerLimit = 400;
    protected int heightLimit = 450;

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
        this.settingResize();
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
        input.revalidate();
        input.repaint();
    }

    protected void setRedimentionButton(JPanel btn, int width, int height) {
        btn.setPreferredSize(new Dimension(width, height));
        revalidate();
        repaint();
    }

    private void settingResize() {

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (getWidth() > upperLimit && getHeight() > heightLimit) {
                    configResizeLarge();

                } else {
                    configResizeMedium();

                }

                if (getWidth() > lowerLimit && getWidth() <= upperLimit) {
                    configResizeMedium();
                }

                if (getWidth() <= lowerLimit) {
                    configResizeSmall();
                }
            }
        });

    }

    protected void configDefauld() {
        setBorderColor(getBackgroundRect());
        this.content = new TransparentPanel();
        this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
        setBorderColor(ColorPalette.TRANSPARENT);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(content, gbc);
    }

    public void addContent(Component component) {
        this.content.add(component);
    }

    public void removeContent(Component component) {
        this.content.remove(component);
        this.content.revalidate();
        this.content.repaint();
    }

    public void addInputList(JTextField input) {
        this.inputList.add(input);
    }

    public ArrayList<JTextField> getInputList() {
        return this.inputList;
    }

    protected abstract void configResizeLarge();

    protected abstract void configResizeMedium();

    protected abstract void configResizeSmall();

}