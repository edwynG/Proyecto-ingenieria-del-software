package main.view.components.proponentComponents.Components;

import main.Env;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.commonComponents.ButtonRounded;
import main.view.components.commonComponents.Dropdown;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.InputText;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.utils.Components;
import main.view.utils.CustomVariables;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class CourseFormulation extends AbstractForm {
    private TransparentPanel containerTitle;
    private TransparentPanel formulationContentLeft;
    private TransparentPanel formulationContentRight;
    private TransparentPanel containerFormulation;
    private TextTitle title;
    private InputText inputTitle;
    private Dropdown denomination;
    private FileChooser fileChooserObjectivesandFoundations;
    private FileChooser fileChooserAdmissionAndGraduationProfile;
    private FileChooser fileChooserTeachingProfile;
    private FileChooser fileChooserCurriculumStructureByCompetencies;
    private FileChooser fileChooserStrategiesAndEvaluation;
    private FileChooser fileChooserRequirementsInSubjects;
    private FileChooser fileChooserCostStructure;
    private FileChooser fileChooserExecutionSchedule;
    private Dropdown ResponsibleUnit;
    private ButtonRounded button;
    private int roundedButtonGlobal = CustomVariables.RADIO_DEFAULT_BUTTON;
    private int inputwidthMid = 300;
    private int inputheigthMid = 42;
    private int inputwidthLarge = 360;
    private int inputheigthLarge = 45;
    private int columnsInputStandard = 28;
    private int columnsInputLarge = 34;

    public CourseFormulation(int rounded) {
        super(rounded);
        initCourseFormulation();
    }

    public void initCourseFormulation() {
        configCourseFormulation();
        configCourseFormulationLayout();
        createTitle();
        createFileChooserAndDropdown();
        createButton();

    }

    public void configCourseFormulation() {
        defaultWidth = 700;
        defaultHeigth = 600;
        setPreferredSize(new Dimension(defaultWidth, defaultHeigth));
        containerTitle = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(0, 0, 18, 0);
            }
        };
        formulationContentLeft = new TransparentPanel();
        formulationContentRight = new TransparentPanel();
        containerFormulation = new TransparentPanel();
    }

    private void configCourseFormulationLayout() {
        addContent(containerTitle);
        addContent(containerFormulation);
        containerFormulation.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        containerFormulation.add(formulationContentLeft, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        containerFormulation.add(formulationContentRight, gbc);
        formulationContentLeft.setLayout(new GridBagLayout());
        formulationContentRight.setLayout(new GridBagLayout());
        upperLimit = 800;
        lowerLimit = 550;
        heightLimit = 550;

    }

    private void createTitle() {
        title = new TextTitle("Formulación del curso");
        title.setPreferredSize(new Dimension(450, 45));
        containerTitle.add(title, SwingConstants.CENTER);

    }

    private void createFileChooserAndDropdown() {
        inputTitle = createInputText("Titulo del curso", 18);
        TransparentPanel container = new TransparentPanel();
        container.add(inputTitle);

        ArrayList<String> deno = new ArrayList<>();
        deno.add("Taller");
        deno.add("Diplomado");
        denomination = createDropdown("Denominación", deno);

        TransparentPanel container_0 = new TransparentPanel();
        container_0.add(denomination);

        fileChooserObjectivesandFoundations = createFileChoosers("Objetivos y fundamentación");
        TransparentPanel container_1 = new TransparentPanel();
        container_1.add(fileChooserObjectivesandFoundations);

        fileChooserAdmissionAndGraduationProfile = createFileChoosers("Perfil de ingreso y egreso");
        TransparentPanel container_2 = new TransparentPanel();
        container_2.add(fileChooserAdmissionAndGraduationProfile);

        fileChooserTeachingProfile = createFileChoosers("Perfil docente");
        TransparentPanel container_3 = new TransparentPanel();
        container_3.add(fileChooserTeachingProfile);

        fileChooserCurriculumStructureByCompetencies = createFileChoosers("Estructura currcular por competencias");
        TransparentPanel container_4 = new TransparentPanel();
        container_4.add(fileChooserCurriculumStructureByCompetencies);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        formulationContentLeft.add(container, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        // gbc.anchor = GridBagConstraints.NORTH;
        formulationContentLeft.add(container_0, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formulationContentLeft.add(container_1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        formulationContentLeft.add(container_2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formulationContentLeft.add(container_3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        formulationContentLeft.add(container_4, gbc);

        fileChooserStrategiesAndEvaluation = createFileChoosers("Estrategias de evaluación y duración");
        TransparentPanel container_5 = new TransparentPanel();
        container_5.add(fileChooserStrategiesAndEvaluation);

        fileChooserRequirementsInSubjects = createFileChoosers("Exigencias en materiales y servicios");
        TransparentPanel container_6 = new TransparentPanel();
        container_6.add(fileChooserRequirementsInSubjects);

        fileChooserCostStructure = createFileChoosers("Estructura de costos");
        TransparentPanel container_7 = new TransparentPanel();
        container_7.add(fileChooserCostStructure);

        fileChooserExecutionSchedule = createFileChoosers("Cronograma de ejecución anual");
        TransparentPanel container_8 = new TransparentPanel();
        container_8.add(fileChooserExecutionSchedule);

        ArrayList<String> resp = new ArrayList<>();
        resp.add(Env.OUTREACH_COORDINATION);
        resp.add(Env.OUTREACH_DIRECTORATE);
        resp.add(Env.OUTREACH_COMMITTEE);
        resp.add(Env.FACULTY_COUNCIL);

        ResponsibleUnit = createDropdown("Unidad responsable", resp);
        ResponsibleUnit.setPreferentPanel(420, 185);
        TransparentPanel container_9 = new TransparentPanel();
        container_9.add(ResponsibleUnit);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formulationContentRight.add(container_5, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formulationContentRight.add(container_6, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formulationContentRight.add(container_7, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formulationContentRight.add(container_8, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formulationContentRight.add(container_9, gbc);

        setRedimentionFileChoosers(inputwidthMid, inputheigthMid);
        setRedimentionDropdowns(inputwidthMid, inputheigthMid);
        setRedimentionFields(columnsInputStandard, inputheigthMid);

    }

    private void createButton() {
        button = new ButtonRounded("Enviar", roundedButtonGlobal);

        TransparentPanel container = new TransparentPanel();
        container.add(button);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 5, 5, 5);

        formulationContentRight.add(container, gbc);
        setRedimentionPane(button, inputwidthMid, inputheigthMid);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // La lista tiene que tener por la estructura de la consulta
                ArrayList<String> data = new ArrayList<>();
                data.add(Integer.toString(Main.getProponentControl().getUser().getId()));
                data.add(inputTitle.getText());
                data.add(denomination.getSelectElement());
                data.add(fileChooserObjectivesandFoundations.getPath());
                data.add(fileChooserAdmissionAndGraduationProfile.getPath());
                data.add(fileChooserTeachingProfile.getPath());
                data.add(fileChooserCurriculumStructureByCompetencies.getPath());
                data.add(fileChooserStrategiesAndEvaluation.getPath());
                data.add(fileChooserRequirementsInSubjects.getPath());
                data.add(fileChooserCostStructure.getPath());
                data.add(fileChooserExecutionSchedule.getPath());
                data.add(ResponsibleUnit.getSelectElement());
                InterfaceProponent.actions.actionsSubmitProposal(data);
            }
        });
    }

    @Override
    protected void configResizeLarge() {
        setRedimentionFileChoosers(inputwidthLarge, inputheigthLarge);
        setRedimentionDropdowns(inputwidthLarge, inputheigthLarge);
        setRedimentionPane(button, inputwidthLarge, inputheigthLarge);
        setRedimentionFields(columnsInputLarge, inputheigthLarge);

        Components.repaintComponent(this);

    }

    @Override
    protected void configResizeMedium() {
        setRedimentionFileChoosers(inputwidthMid, inputheigthMid);
        setRedimentionDropdowns(inputwidthMid, inputheigthMid);
        setRedimentionPane(button, inputwidthMid, inputheigthMid);
        setRedimentionFields(columnsInputStandard, inputheigthMid);
        Components.repaintComponent(this);

    }

    @Override
    protected void configResizeSmall() {

    }
}
