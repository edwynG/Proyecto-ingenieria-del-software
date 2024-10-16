package main.view.components.administratorComponents.components.tableItemsComponents;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Env;
import main.controller.Validator;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.administratorComponents.InterfaceAdministrator;
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
    private String probityFileBase64;
    private String informationFileBase64;
    private Dropdown result;
    private String resultText="Evaluar";
    ArrayList<String> resultOptions;
    private Integer id;

    public ItemTableAddress(String course, int id) {
        super(0);
        this.course = new TextSubtitle("<html>" + course + "</html>", SwingConstants.LEFT);
        this.id = id;
        initItemTableCoodination();
    }

    private void initItemTableCoodination() {
        configItemTableCourseWithAval();
        configText();
        createComponents();
        configFilesDownload();
        configResultEvaluation();
    }

    private void configFilesDownload() {
        probityFileBase64 = Main.getAdminControl().getFileProbityBase64(id);
        informationFileBase64 = Main.getAdminControl().getFileProposalBase64(id);

    }

    private void configResultEvaluation() {
        Validator validator = new Validator();
        if (!validator.existResultProposal(id)) {
            return;
        }
        String str = Main.getAdminControl().getResultProposal(id);
        if (str == null) {
            return;
        }
        result.setText(str);

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
        result = new Dropdown(resultText);
        resultOptions = new ArrayList<>();
        resultOptions.add(Env.ACCEPT);
        resultOptions.add(Env.REFUSED);
        resultOptions.add(Env.WAIT);
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
                InterfaceAdministrator.actions.actionsDownload(probity.getPath(), probityFileBase64);

            }
        });
        information.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceAdministrator.actions.actionsDownload(information.getPath(), informationFileBase64);

            }
        });

        observation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceAdministrator.actions.actionsUploadDocument(id, observation.getPath(),
                        Env.TYPE_UPLOAD_OBSERVATIONS);

            }
        });

        result.getOptionList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                InterfaceAdministrator.actions.evaluateProposal(id, result.getSelectElement());
            }
        });

    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 20, 0, 25);
    }
}
