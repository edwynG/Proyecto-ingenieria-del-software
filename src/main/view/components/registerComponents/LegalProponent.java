package main.view.components.registerComponents;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.commonComponents.ButtonRounded;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.InputText;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.Components;
import main.view.utils.CustomVariables;

public class LegalProponent extends AbstractForm {

    private TransparentPanel containerTitle;
    private TransparentPanel formulationContentLeft;
    private TransparentPanel formulationContentRight;
    private TransparentPanel containerFormulation;
    private TextTitle title;
    private InputText inputID;

    private FileChooser fileChooserCommercialRegister;
    private FileChooser fileChooserRIF;
    private FileChooser fileChooserISLR;
    private FileChooser fileChooserCurriculum;
    private FileChooser fileChooserDegree;
    private ButtonRounded button;

    private RegisterActions actions;

    private int heightButton = 43;
    private int roundedButtonGlobal = CustomVariables.RADIO_DEFAULT_BUTTON;

    private int columnsInputDefault = 26;

    public LegalProponent(int rounded) {
        super(rounded);
        initLegalProponent();
    }

    public LegalProponent() {
        initLegalProponent();
    }

    public void initLegalProponent() {
        configLegalProponent();
        configLegalProponentLayout();
        createTitle();
        createinput();
        createFileChooser();
        createButton();

    }

    public void configLegalProponent() {
        defaultWidth = 700;
        defaultHeigth = 400;
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
        actions = new RegisterActions();

    }

    private void configLegalProponentLayout() {
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

    }

    private void createTitle() {
        title = new TextTitle("Persona jurídica");
        title.setPreferredSize(new Dimension(320,45));
        containerTitle.add(title, SwingConstants.CENTER);

    }

    private void createinput() {
        inputID = createInputText("Cédula de identidad del representante legal", columnsInputDefault);
        TransparentPanel container = new TransparentPanel();
        container.add(inputID);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        formulationContentLeft.add(container, gbc);

        inputID.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = inputID.getWidth();
                int height = inputID.getHeight();
                setRedimentionFileChoosers(width, height);
                setRedimentionPane(button, width, heightButton);

            }
        });
    }

    private void createFileChooser() {

        fileChooserCommercialRegister = createFileChoosers("Registro mercantil");
        TransparentPanel container_1 = new TransparentPanel();
        container_1.add(fileChooserCommercialRegister);

        fileChooserRIF = createFileChoosers("Registro de información fiscal (RIF)");
        TransparentPanel container_2 = new TransparentPanel();
        container_2.add(fileChooserRIF);

        fileChooserISLR = createFileChoosers("Certificado de declaración ISLR");
        TransparentPanel container_3 = new TransparentPanel();
        container_3.add(fileChooserISLR);

        fileChooserCurriculum = createFileChoosers("Resumen curricular");
        TransparentPanel container_4 = new TransparentPanel();
        container_4.add(fileChooserCurriculum);

        fileChooserDegree = createFileChoosers("Copia del título universitario");
        TransparentPanel container_5 = new TransparentPanel();
        container_5.add(fileChooserDegree);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        formulationContentLeft.add(container_1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formulationContentLeft.add(container_2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        formulationContentLeft.add(container_3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formulationContentRight.add(container_4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 16, 10);
        formulationContentRight.add(container_5, gbc);

        setRedimentionFileChoosers(inputID.getWidth(), inputID.getHeight());

    }

    private void createButton() {
        button = new ButtonRounded("Registrarse", roundedButtonGlobal);
        setRedimentionPane(button, inputID.getWidth(), heightButton);
        TransparentPanel container = new TransparentPanel();
        container.add(button);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 90, 0);
        formulationContentRight.add(container, gbc);

         button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // La lista tiene que tener la estructura de la consulta
                ArrayList<String> data = new ArrayList<>();
                data.add(inputID.getText());
                data.add(fileChooserRIF.getPath());
                data.add(fileChooserISLR.getPath());
                data.add(fileChooserCurriculum.getPath());
                data.add(fileChooserDegree.getPath());
                data.add(fileChooserCommercialRegister.getPath());
                actions.actionsTerminateRegistrationProponent(data);
            }
        });
    }

    @Override
    protected void configResizeLarge() {
        setRedimentionFields(34, 45);
        Components.repaintComponent(this);

    }

    @Override
    protected void configResizeMedium() {
        setRedimentionFields(columnsInputDefault, 40);
        Components.repaintComponent(this);
    }

    @Override
    protected void configResizeSmall() {
        
    }

}
