package main.view.components.AbstractComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Env;
import main.view.components.CommonComponents.ScrollPaneWin11;
import main.view.utils.ColorPalette;
import main.view.utils.RoundedBorder;
import raven.glasspanepopup.GlassPanePopup;

public abstract class AbstractDropdown extends AbstractPanelRounded {
    protected JList<String> options;
    protected AbstractPanelRounded panel;
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

    public AbstractDropdown(String text, DefaultListModel<String> elements) {
        this.options = new JList<>(elements);
        this.elements = elements;
        this.title = text;
        initAbstractDropdown();

    }

    private void initAbstractDropdown() {
        this.text = new JLabel(this.title);
        this.imagen = new JLabel();
        this.imagen.setIcon(createIcon());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout());
        RoundedBorder borde = new RoundedBorder(10);
        borde.setBorderColor(Color.black);
        setBorder(borde);
        add(this.text, BorderLayout.CENTER);
        add(this.imagen, BorderLayout.EAST);
        createPopupPanel();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GlassPanePopup.showPopup(panel);

            }
        });

    }

    private void createPopupPanel() {
        int radius = 15;
        int height = 120;
        int width = 320;
        this.panel = new AbstractPanelRounded(radius) {
            @Override
            public Insets insets() {
                return new Insets(2, 2, 2, 2);
            }
        };
        panel.setLayout(new BorderLayout());
        setPreferentPanel(width, height);
        AbstractPanelRounded content = new AbstractPanelRounded(radius) {
        };
        content.setBackground(ColorPalette.TRANSPARENT);
        content.setLayout(new BorderLayout());

        ScrollPaneWin11 scroll = new ScrollPaneWin11(content);
        scroll.setForeground(ColorPalette.TRANSPARENT);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        panel.add(scroll, BorderLayout.CENTER);

        options.setBorder(new RoundedBorder(radius, ColorPalette.TRANSPARENT, ColorPalette.TRANSPARENT));
        content.add(options, BorderLayout.CENTER);
        options.setFixedCellHeight((height / 2) - 3);
        options.setFont(new Font("Arial", Font.BOLD, 30));

        options.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                text.setText(options.getSelectedValue());
                GlassPanePopup.closePopupLast();
            }
        });

        options.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                int index = options.locationToIndex(e.getPoint());
                if (index >= 0) {
                    options.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                } else {
                    options.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                }
            }
        });
    }

    private ImageIcon createIcon() {
        ImageIcon src = new ImageIcon(Env.PATH_ICON_DROPDOWN);
        Image img = src.getImage().getScaledInstance(12, 11, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void setListElements(ArrayList<String> arr) {
        this.elements.removeAllElements();
        for (String element : arr) {
            this.elements.addElement(element);
        }
        this.options.setModel(this.elements);
        options.revalidate();
        options.repaint();
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

    public void setStyleTitle(Font font) {
        this.text.setFont(font);
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

    public void setPreferentPanel(int width, int height) {
        panel.setPreferredSize(new Dimension(width, height));

    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }

}
