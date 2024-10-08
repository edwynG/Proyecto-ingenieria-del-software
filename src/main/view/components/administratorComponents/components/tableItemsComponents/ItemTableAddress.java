package main.view.components.administratorComponents.components.tableItemsComponents;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.Dropdown;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.GridLayout;

public class ItemTableAddress extends AbstractPanelRounded {
    private TextSubtitle course;
    private FileChooser probity;
    private FileChooser information;
    private FileChooser observation;
    private Dropdown result;
    ArrayList<String> resultOptions;
    private int id;

    public ItemTableAddress(String course, int id) {
        super(0);
        this.course = new TextSubtitle(course, SwingConstants.LEFT);
        this.id = id;
        initItemTableCoodination();
    }

    private void initItemTableCoodination() {
        configItemTableCourseWithAval();
        configText();
        createComponents();
    }

    private void configItemTableCourseWithAval() {
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        setBackground(ColorPalette.TRANSPARENT);
        setLayout(new BorderLayout());

    }

    private void configText() {

        TransparentPanel containerName = new TransparentPanel();
        containerName.setLayout(new GridBagLayout());
        containerName.add(course);
        Components.setRedimentionComponent(course, 159, 40);

        course.setFont(new Font("Arial", Font.BOLD, 15));
        course.setForeground(ColorPalette.COLOR_HOVER);
        add(containerName, BorderLayout.WEST);

    }

    private void createComponents() {
        int width = 40;
        int height = 40;
        probity = new FileChooser("Probidad") {
            @Override
            protected void uploadDisapprovedFile() {

            }

            @Override
            protected void uploadApprovateFile() {

            }
        };
        information = new FileChooser("Información") {
            @Override
            protected void uploadDisapprovedFile() {

            }

            @Override
            protected void uploadApprovateFile() {

            }
        };
        observation = new FileChooser("Observaciones") {
            @Override
            protected void uploadDisapprovedFile() {

            }

            @Override
            protected void uploadApprovateFile() {

            }
        };
        result = new Dropdown("Evaluar");
        resultOptions = new ArrayList<>();
        resultOptions.add("Aprovado");
        resultOptions.add("Desaprovado");
        result.setListElements(resultOptions);

        information.NotVisibleText();
        probity.NotVisibleText();
        information.configMethodDownload();
        probity.configMethodDownload();
        observation.NotVisibleText();
        Components.setRedimentionComponent(probity, width, height);
        Components.setRedimentionComponent(information, width, height);
        Components.setRedimentionComponent(observation, width, height);
        Components.setRedimentionComponent(result, width + 80, height);
        information.setRedimentionIcon(width, height);
        probity.setRedimentionIcon(width, height);
        observation.setRedimentionIcon(width, height);
        information.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        probity.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        observation.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));

        TransparentPanel containerProbity = new TransparentPanel();
        containerProbity.setLayout(new GridBagLayout());
        containerProbity.add(probity);
        TransparentPanel containerinformation = new TransparentPanel();
        containerinformation.setLayout(new GridBagLayout());
        containerinformation.add(information);
        TransparentPanel containerObservation = new TransparentPanel();
        containerObservation.setLayout(new GridBagLayout());
        containerObservation.add(observation);

        TransparentPanel containerResult = new TransparentPanel();
        TransparentPanel containerTemporal = new TransparentPanel();
        containerTemporal.setLayout(new BorderLayout());
        containerTemporal.add(result, BorderLayout.EAST);
        containerResult.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        containerResult.add(containerTemporal, gbc);

        TransparentPanel containerCenter = new TransparentPanel();
        containerCenter.setLayout(new GridLayout(1, 4));
        containerCenter.add(containerProbity);
        containerCenter.add(containerinformation);
        containerCenter.add(containerObservation);
        containerCenter.add(containerResult);
        add(containerCenter, BorderLayout.CENTER);
        actionsComponents();
    }

    private void actionsComponents() {
        probity.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);

            }
        });
        information.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);

            }
        });

        observation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);

            }
        });

        result.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);

            }
        });

    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 20, 0, 25);
    }
}
