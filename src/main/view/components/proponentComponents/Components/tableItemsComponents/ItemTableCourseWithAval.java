package main.view.components.proponentComponents.Components.tableItemsComponents;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

public class ItemTableCourseWithAval extends AbstractPanelRounded {
    private TextSubtitle name;
    private FileChooser Schedule;
    private FileChooser Costos;
    private int id;
    GridBagConstraints gbc;

    public ItemTableCourseWithAval(String name, int id) {
        super(0);
        this.name = new TextSubtitle(name);
        this.id = id;
        initItemTableCourseWithAval();
    }

    private void initItemTableCourseWithAval() {
        configItemTableCourseWithAval();
        configText();
        createComponents();
    }

    private void configItemTableCourseWithAval() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        setBackground(ColorPalette.TRANSPARENT);
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 5, 0, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

    }

    private void configText() {
        TransparentPanel containerName = new TransparentPanel();
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setForeground(ColorPalette.COLOR_HOVER);
        Components.setRedimentionComponent(name, 170, 40);
        Components.setRedimentionComponent(containerName, 100, 40);
        containerName.setLayout(new BorderLayout());
        containerName.add(name, BorderLayout.WEST);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(containerName, gbc);

    }

    private void createComponents() {
        int width = 40;
        int height = 40;
        Schedule = new FileChooser("Cronograma de ejecución") {
            @Override
            protected void DisapprovedFile() {

            }

            @Override
            protected void ApprovateFile() {

            }
        };
        Costos = new FileChooser("Estructura de ejecución e costos") {
            @Override
            protected void DisapprovedFile() {

            }

            @Override
            protected void ApprovateFile() {

            }
        };
        Costos.NotVisibleText();
        Schedule.NotVisibleText();
        Components.setRedimentionComponent(Schedule, width, height);
        Components.setRedimentionComponent(Costos, width, height);
        Costos.setRedimentionIcon(width, height);
        Schedule.setRedimentionIcon(width, height);
        Costos.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        Schedule.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        TransparentPanel scheduleContainer = new TransparentPanel();
        TransparentPanel costosContainer = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(0, 0, 0, 40);
            }
        };
        costosContainer.setLayout(new BorderLayout());
        scheduleContainer.setLayout(new GridBagLayout());

        scheduleContainer.add(Schedule);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(scheduleContainer, gbc);
        costosContainer.add(Costos, BorderLayout.EAST);
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(costosContainer, gbc);
        actionsComponents();

    }

    private void actionsComponents() {
        Schedule.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);
                InterfaceProponent.actions.actionsUploadDocument();
            }
        });
        Costos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);
                InterfaceProponent.actions.actionsUploadDocument();

            }
        });
    }

    

    @Override
    public Insets getInsets() {
        return new Insets(0, 20, 0, 25);
    }
}
