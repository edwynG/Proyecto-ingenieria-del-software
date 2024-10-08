package main.view.components.proponentComponents.Components.tableItemsComponents;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.ButtonRounded;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import main.view.utils.CustomVariables;
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
    private int proposalID;
    private ButtonRounded buttonDetails;
    GridBagConstraints gbc;

    public ItemTableMyCourse(String name, String type, int proposalID) {
        super(0);
        this.name = new TextSubtitle("<html>"+name+"</html>");
        this.type = new TextSubtitle(type, SwingConstants.CENTER);
        this.proposalID = proposalID;
        initItemTableMyCourse();
    }

    private void initItemTableMyCourse() {
        configItemTableMyCourse();
        configText();
        createComponents();
    }

    private void configItemTableMyCourse() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        setBackground(ColorPalette.TRANSPARENT);
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

    }

    private void configText() {
        TransparentPanel centerType = new TransparentPanel();
        TransparentPanel containerName = new TransparentPanel();
        containerName.setLayout(new BorderLayout());
        containerName.add(name, BorderLayout.WEST);
        Components.setRedimentionComponent(name, 170, 40);
        Components.setRedimentionComponent(containerName, 100, 40);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setForeground(ColorPalette.COLOR_HOVER);
        type.setFont(new Font("Arial", Font.BOLD, 15));
        type.setForeground(ColorPalette.COLOR_HOVER);
        centerType.setLayout(new BorderLayout());

        centerType.add(type, BorderLayout.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(containerName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(centerType, gbc);
    }

    private void createComponents() {
        buttonDetails = new ButtonRounded("Ver más", CustomVariables.RADIO_DEFAULT_BUTTON);
        Components.setRedimentionComponent(buttonDetails, 100, 40);
        TransparentPanel center = new TransparentPanel();
        TransparentPanel east = new TransparentPanel();
        center.setLayout(new GridBagLayout());
        center.add(buttonDetails);
        east.setLayout(new BorderLayout());
        east.add(center, BorderLayout.EAST);
        gbc.gridx = 3;
        gbc.gridy = 0;
        add(east, gbc);
        actionsComponents();

    }

    private void actionsComponents() {

        buttonDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceProponent.actions.actionsButtonViewMore(proposalID);
            }
        });

    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 20, 0, 25);
    }
}
