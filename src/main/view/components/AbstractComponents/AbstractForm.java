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
        this.inputList = new ArrayList<>();
        this.fileChoosersList = new ArrayList<>();
        this.dropdownList = new ArrayList<>();

        this.configDefault();
        this.settingResize();

    }

    protected InputText createInputText(String placeholder, int columns) {
        InputText input = new InputText(columns, placeholder);
        this.addInputList(input);
        input.addEffectPlaceHolder();
        return input;

    }

    protected InputPassword createInputPassword(String placeholder, int columns) {
        InputPassword input = new InputPassword(columns, placeholder);
        this.addInputList(input);
        input.addEffectPlaceHolder();
        return input;
    }

    protected FileChooser createFileChoosers(String str) {
        FileChooser fileChooser = new FileChooser(str);
        this.fileChoosersList.add(fileChooser);
        return fileChooser;
    }

    protected Dropdown createDropdown(String str, ArrayList<String> elements) {
        Dropdown dropdown = new Dropdown(str);
        dropdown.setListElements(elements);
        this.dropdownList.add(dropdown);
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
        setPreferredSize(new Dimension(width, height));
        revalidate();
        repaint();
    }

    public void redimentionRestore() {
        setRedimention(this.defaultWidth, this.defaultHeigth);
    }

    protected void setRedimentionFields(JTextField input, int columns, int height) {
        input.setColumns(columns);
        input.setPreferredSize(new Dimension(input.getWidth(), height));
        input.revalidate();
        input.repaint();
    }

    protected void setRedimentionPane(Component component, int width, int height) {
        if (component == null)
            return;
        component.setPreferredSize(new Dimension(width, height));
        component.revalidate();
        component.repaint();
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

    protected void configDefault() {
        this.content = new TransparentPanel();
        this.content.setLayout(new BoxLayout(this.content, BoxLayout.Y_AXIS));
        setLayout(new GridBagLayout());
        this.configDefauldLayout();
    }

    protected void configDefauldLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        this.add(content, gbc);
    }

    public void addContent(Component component) {
        this.content.add(component);
    }

    public void addContent(Component component, Object obj) {
        this.content.add(component, obj);
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