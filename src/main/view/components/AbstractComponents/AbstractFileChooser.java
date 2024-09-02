package main.view.components.AbstractComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Env;

public class AbstractFileChooser extends AbstractPanelRounded {
    protected String title;
    protected JLabel text;
    protected JLabel imagen;
    private String icon = Env.PATH_ICON_UPLOAD;

    public AbstractFileChooser(String text) {
        this.title = text;
        initAbstractFileChooser();
    }

    public AbstractFileChooser(String text, int rounded) {
        super(rounded);
        this.title = text;
        initAbstractFileChooser();

    }

    private void initAbstractFileChooser() {
        this.text = new JLabel(this.title);
        this.imagen = new JLabel();
        this.imagen.setIcon(createIcon());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout());
        add(this.text, BorderLayout.CENTER);
        add(this.imagen, BorderLayout.EAST);

    }

    
    public void setColorText(Color color) {
        this.text.setForeground(color);
    }

    public void setFontSizeText(int size) {
        Font font = this.text.getFont();
        this.text.setFont(new Font(font.getName(), font.getStyle(), size));
    }

    public void setFontFamilyText(String family) {
        Font font = this.text.getFont();
        this.text.setFont(new Font(family, font.getStyle(), font.getSize()));
    }

    private ImageIcon createIcon() {
        ImageIcon src = new ImageIcon(this.getIcon());
        Image img = src.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }

}
