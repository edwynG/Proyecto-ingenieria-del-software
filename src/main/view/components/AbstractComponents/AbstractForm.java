package main.view.components.AbstractComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JTextField;

import main.view.components.commonComponents.Dropdown;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.InputPassword;
import main.view.components.commonComponents.InputText;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.Components;

public abstract class AbstractForm extends AbstractPanelRounded {
    protected int defaultWidth = 0;
    protected int defaultHeigth = 0;

    private ArrayList<JTextField> inputList;
    private ArrayList<FileChooser> fileChoosersList;
    private ArrayList<Dropdown> dropdownList;

    protected TransparentPanel content;
    protected int upperLimit = 470;
    protected int lowerLimit = 430;
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
        setBackground(Color.white);
        inputList = new ArrayList<>();
        fileChoosersList = new ArrayList<>();
        dropdownList = new ArrayList<>();

        configDefault();
        settingResize();

    }

    protected InputText createInputText(String placeholder, int columns) {
        InputText input = new InputText(columns, placeholder);
        addInputList(input);
        input.addEffectPlaceHolder();
        return input;

    }

    protected InputPassword createInputPassword(String placeholder, int columns) {
        InputPassword input = new InputPassword(columns, placeholder);
        addInputList(input);
        input.addEffectPlaceHolder();
        return input;
    }

    protected FileChooser createFileChoosers(String str) {
        FileChooser fileChooser = new FileChooser(str);
        fileChoosersList.add(fileChooser);
        return fileChooser;
    }

    protected Dropdown createDropdown(String str, ArrayList<String> elements) {
        Dropdown dropdown = new Dropdown(str);
        dropdown.setListElements(elements);
        dropdownList.add(dropdown);
        return dropdown;
    }

    protected void setRedimentionFileChoosers(int width, int height) {
        for (FileChooser fileChooser : fileChoosersList) {
            setRedimentionPane(fileChooser, width, height);
        }
    }

    protected void setRedimentionDropdowns(int width, int height) {
        for (Dropdown drop : dropdownList) {
            setRedimentionPane(drop, width, height);
        }
    }

    public void setRedimention(int width, int height) {
        Components.setRedimentionComponent(this, width, height);
    }

    public void redimentionRestore() {
        setRedimention(defaultWidth, defaultHeigth);
    }

    protected void setRedimentionFields(int columns, int height) {

        for (JTextField input : inputList) {
            input.setColumns(columns);
            Components.setRedimentionComponent(input, columns, height);
        }
     
    }

    protected void setRedimentionPane(Component component, int width, int height) {
        if (component == null)
            return;
        component.setPreferredSize(new Dimension(width, height));
        component.revalidate();
        component.repaint();
    }

    private void settingResize() {

        addComponentListener(new ComponentAdapter() {
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

    protected void configDefault() {
        content = new TransparentPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        setLayout(new GridBagLayout());
        configDefauldLayout();
    }

    protected void configDefauldLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        add(content, gbc);
    }

    public void addContent(Component component) {
        content.add(component);
    }

    public void addContent(Component component, Object obj) {
        content.add(component, obj);
    }

    public void removeContent(Component component) {
        content.remove(component);
        content.revalidate();
        content.repaint();
    }

    public void addInputList(JTextField input) {
        inputList.add(input);
    }

    public ArrayList<JTextField> getInputList() {
        return inputList;
    }

    protected abstract void configResizeLarge();

    protected abstract void configResizeMedium();

    protected abstract void configResizeSmall();

}