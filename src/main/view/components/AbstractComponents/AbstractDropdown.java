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
import main.view.components.commonComponents.ScrollPaneWin11;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
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
        options = new JList<>();
        elements = new DefaultListModel<>();
        title = text;

        initAbstractDropdown();
    }

    public AbstractDropdown(String text, DefaultListModel<String> elements) {
        options = new JList<>(elements);
        this.elements = elements;
        title = text;
        initAbstractDropdown();

    }

    private void initAbstractDropdown() {
        text = new JLabel(title);
        imagen = new JLabel();
        imagen.setIcon(createIcon());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout());
        RoundedBorder borde = new RoundedBorder(10);
        borde.setBorderColor(Color.black);
        setBorder(borde);
        add(text, BorderLayout.CENTER);
        add(imagen, BorderLayout.EAST);
        createPopupPanel();

        addMouseListener(new MouseAdapter() {
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
        panel = new AbstractPanelRounded(radius) {
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
                GlassPanePopup.closePopup(0);
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
        elements.removeAllElements();
        for (String element : arr) {
            elements.addElement(element);
        }
        options.setModel(elements);
        Components.repaintComponent(options);
    }

    public void addElement(String element) {
        elements.addElement(element);
        options.setModel(elements);
        reload(options);

    }

    public String getSelectElement() {
        return options.getSelectedValue();
    }

    public void removeElement(String element) {
        elements.removeElement(element);
        options.setModel(elements);
        reload(options);
    }

    protected void reload(Component component) {
        component.revalidate();
        component.repaint();
    }

    public void setStyleTitle(Font font) {
        text.setFont(font);
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

    public void setPreferentPanel(int width, int height) {
        panel.setPreferredSize(new Dimension(width, height));

    }

    public JList<String> getOptionList() {
        return options;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 10);
    }

    public void setText(String text) {
        this.text.setText(text);
    }

}
