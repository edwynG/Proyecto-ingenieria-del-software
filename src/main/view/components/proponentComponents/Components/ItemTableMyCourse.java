package main.view.components.proponentComponents.Components;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.CommonComponents.ButtonRounded;
import main.view.components.CommonComponents.TextSubtitle;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.utils.ColorPalette;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

public class ItemTableMyCourse extends AbstractPanelRounded {
    private TextSubtitle name;
    private TextSubtitle type;
    private int id;
    private ButtonRounded buttonDetails;
    GridBagConstraints gbc;

    public ItemTableMyCourse(String name, String type, int id) {
        super(0);
        this.name = new TextSubtitle(name);
        this.type = new TextSubtitle(type,SwingConstants.CENTER);
        this.id = id;
        initItemTableMyCourse();
    }

    private void initItemTableMyCourse() {
        configItemTableMyCourse();
        configText();
        createButton();
    }

    private void configItemTableMyCourse() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        setBackground(ColorPalette.TRANSPARENT);
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.fill = GridBagConstraints.BOTH;

    }

    private void configText() {
        TransparentPanel centerType = new TransparentPanel(){
            @Override
            public Insets getInsets() {
                return new Insets(0, 0, 0, 30);
            }
        };
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setForeground(ColorPalette.COLOR_HOVER);
        type.setFont(new Font("Arial", Font.BOLD, 15));
        type.setForeground(ColorPalette.COLOR_HOVER);
        centerType.add(type);
        centerType.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(name, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(centerType, gbc);
    }

    private void createButton() {
        buttonDetails = new ButtonRounded("Ver más " + id, 15);
        buttonDetails.setPreferredSize(new Dimension(100, 40));
        TransparentPanel center = new TransparentPanel();
        TransparentPanel east = new TransparentPanel();
        center.setLayout(new GridBagLayout());
        center.add(buttonDetails);
        east.setLayout(new BorderLayout());
        east.add(center,BorderLayout.EAST);
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(east, gbc);

        buttonDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceProponent.actions.ButtonViewMore();
            }
        });
    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 20, 0, 25);
    }
}
