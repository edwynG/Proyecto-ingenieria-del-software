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
        setBorderColor(ColorPalette.TRANSPARENT);
        setBackgroundRect(ColorPalette.COLOR_PRIMARY);
        setPreferredSize(new Dimension(200, 40));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        text = new JLabel(string, SwingConstants.CENTER);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        text.setOpaque(true); // Hacer que el JLabel sea opaco
        text.setBackground(ColorPalette.TRANSPARENT); //
        add(text, gbc);
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

    public void setFontWeightText(int weight) {
        Font font = this.text.getFont();
        this.text.setFont(new Font(font.getName(), weight, font.getSize()));
    }

}
