package main.view.components.administratorComponents.components.tableItemsComponents;

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
import java.util.ArrayList;

import java.awt.GridLayout;

public class ItemTableCoordination extends AbstractPanelRounded {
    private TextSubtitle course;
    private FileChooser proposal;
    private FileChooser credentials;
    private FileChooser observation;
    private Dropdown result;
    ArrayList<String> resultOptions;
    private int id;

    public ItemTableCoordination(String course, int id) {
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
        proposal = new FileChooser("Propuesta") {
            @Override
            protected void uploadDisapprovedFile() {

            }

            @Override
            protected void uploadApprovateFile() {

            }
        };
        credentials = new FileChooser("Credenciales") {
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

        credentials.NotVisibleText();
        proposal.NotVisibleText();
        credentials.configMethodDownload();
        proposal.configMethodDownload();
        observation.NotVisibleText();
        Components.setRedimentionComponent(proposal, width, height);
        Components.setRedimentionComponent(credentials, width, height);
        Components.setRedimentionComponent(observation, width, height);
        Components.setRedimentionComponent(result, width + 80, height);
        credentials.setRedimentionIcon(width, height);
        proposal.setRedimentionIcon(width, height);
        observation.setRedimentionIcon(width, height);
        credentials.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        proposal.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        observation.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));

        TransparentPanel containerProposal = new TransparentPanel();
        containerProposal.setLayout(new GridBagLayout());
        containerProposal.add(proposal);
        TransparentPanel containerCredentials = new TransparentPanel();
        containerCredentials.setLayout(new GridBagLayout());
        containerCredentials.add(credentials);
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
        containerCenter.add(containerProposal);
        containerCenter.add(containerCredentials);
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
        credentials.addMouseListener(new MouseAdapter() {
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
