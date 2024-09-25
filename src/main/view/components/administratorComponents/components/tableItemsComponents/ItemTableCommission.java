package main.view.components.administratorComponents.components.tableItemsComponents;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

public class ItemTableCommission extends AbstractPanelRounded {
    private TextSubtitle course;
    private TextSubtitle status;
    private FileChooser proposal;
    private FileChooser observation;
    private Dropdown result;
    ArrayList<String> resultOptions;
    private int id;

    public ItemTableCommission(String course, int id) {
        super(0);
        this.course = new TextSubtitle(course, SwingConstants.LEFT);
        this.id = id;
        initItemTableCommission();
    }

    private void initItemTableCommission() {
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
        status = new TextSubtitle("No validado", SwingConstants.CENTER);
        TransparentPanel containerName = new TransparentPanel();
        containerName.setLayout(new GridBagLayout());
        containerName.add(course);
        Components.setRedimentionComponent(course, 159, 40);
        Components.setRedimentionComponent(status, 140, 40);

        status.setFont(new Font("Arial", Font.BOLD, 15));
        status.setForeground(ColorPalette.COLOR_HOVER);
        course.setFont(new Font("Arial", Font.BOLD, 15));
        course.setForeground(ColorPalette.COLOR_HOVER);
        add(containerName, BorderLayout.WEST);

    }

    private void createComponents() {
        int width = 40;
        int height = 40;
        proposal = new FileChooser("Propuesta") {
            @Override
            protected void DisapprovedFile() {

            }

            @Override
            protected void ApprovateFile() {

            }
        };
        observation = new FileChooser("Observaciones") {
            @Override
            protected void DisapprovedFile() {

            }

            @Override
            protected void ApprovateFile() {

            }
        };
        result = new Dropdown("Evaluar");
        resultOptions = new ArrayList<>();
        resultOptions.add("Aprovado");
        resultOptions.add("Desaprovado");
        result.setListElements(resultOptions);
        proposal.NotVisibleText();
        proposal.configMethodDownload();
        observation.NotVisibleText();
        Components.setRedimentionComponent(status, width, height);
        Components.setRedimentionComponent(proposal, width, height);
        Components.setRedimentionComponent(observation, width, height);
        Components.setRedimentionComponent(result, width + 80, height);
        proposal.setRedimentionIcon(width, height);
        observation.setRedimentionIcon(width, height);
        proposal.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        status.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        observation.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));

        TransparentPanel containerStatus = new TransparentPanel();
        containerStatus.setLayout(new BorderLayout());
        containerStatus.add(status, BorderLayout.CENTER);
        TransparentPanel containerProposal = new TransparentPanel();
        containerProposal.setLayout(new GridBagLayout());
        containerProposal.add(proposal);
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
        containerCenter.add(containerStatus);
        containerCenter.add(containerProposal);
        containerCenter.add(containerObservation);
        containerCenter.add(containerResult);
        add(containerCenter, BorderLayout.CENTER);
        actionsComponents();
    }

    private void actionsComponents() {
        proposal.addMouseListener(new MouseAdapter() {
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

        result.getOptionList().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (result.getSelectElement() != null) {
                    status.setText("Validado");
                    Components.repaintComponent(status);
                    return;
                }

                if (result.getSelectElement() == null) {
                    status.setText("No validado");
                    Components.repaintComponent(status);
                    return;
                }
            };
        });

    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 20, 0, 25);
    }
}
