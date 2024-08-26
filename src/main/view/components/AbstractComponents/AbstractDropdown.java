package main.view.components.AbstractComponents;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;


public abstract class AbstractDropdown extends AbstractPanelRounded {
    protected JList<String> options;
    protected DefaultListModel<String> elements;
    protected String title;
    protected JLabel text;
    protected JLabel imagen;

    public AbstractDropdown(String text) {
        this.options = new JList<>();
        this.elements = new DefaultListModel<>();
        this.title = text;
        initAbstractDropdown();
    }

    public AbstractDropdown(String text, int rounded) {
        super(rounded);
        this.options = new JList<>();
        this.elements = new DefaultListModel<>();
        this.title = text;
        initAbstractDropdown();

    }


    private void initAbstractDropdown() {
        this.text = new JLabel(this.title);
        this.imagen = new JLabel();
        this.imagen.setIcon(createIcon());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout());
        add(this.text, BorderLayout.CENTER);
        add(this.imagen, BorderLayout.EAST);

    }

    private ImageIcon createIcon() {
        ImageIcon src = new ImageIcon("src/assets/icon_dropdown.png");
        Image img = src.getImage().getScaledInstance(12, 11, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    
    public void addElement(String element) {
        this.elements.addElement(element);
        this.options.setModel(elements);
        this.reload(this.options);

    }

    public String getSelectElement() {
        return this.options.getSelectedValue();
    }

    public void removeElement(String element) {
        this.elements.removeElement(element);
        this.options.setModel(elements);
        this.reload(this.options);
    }

    protected void reload(Component component) {
        component.revalidate();
        component.repaint();
    }

    public void setStyleTitle(Font font){
        this.text.setFont(font);
    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }

}
