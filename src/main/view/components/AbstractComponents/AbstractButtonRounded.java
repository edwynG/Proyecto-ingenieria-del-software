package main.view.components.AbstractComponents;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.view.utils.ColorPalette;
import main.view.utils.Components;

public abstract class AbstractButtonRounded extends AbstractPanelRounded {
    private JLabel text;

    public AbstractButtonRounded(String string) {
        super(0);
        initButtonRounded(string);
    }
    public AbstractButtonRounded(String string, int radius) {
        super(radius);
        initButtonRounded(string);
    }

    private void initButtonRounded(String string) {
        setBackground(ColorPalette.COLOR_PRIMARY);
        setPreferredSize(new Dimension(200, 40));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        text = new JLabel(string, SwingConstants.CENTER);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        text.setOpaque(false); // Hacer que el JLabel sea opaco
        text.setBackground(ColorPalette.TRANSPARENT); //
        add(text, gbc);
    }

    public void setColorText(Color color) {
        text.setForeground(color);
    }

    public void setFontSizeText(int size) {
        Font font = text.getFont();
        text.setFont(new Font(font.getName(), font.getStyle(), size));
    }

    public void setFontFamilyText(String family) {
        Font font = text.getFont();
        text.setFont(new Font(family, font.getStyle(), font.getSize()));
    }

    public void setFontWeightText(int weight) {
        Font font = text.getFont();
        text.setFont(new Font(font.getName(), weight, font.getSize()));
    }

    public void setText(String str){
        text.setText(str);
        Components.repaintComponent(text);
    }
    
}
