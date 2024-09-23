package main.view.components.registerComponents;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.CommonComponents.ButtonRounded;
import main.view.components.CommonComponents.FileChooser;
import main.view.components.CommonComponents.InputText;
import main.view.components.CommonComponents.TextTitle;
import main.view.components.CommonComponents.TransparentPanel;

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
    private int roundedButtonGlobal = 15;

    private int columnsInputDefault = 26;

    public LegalProponent(int rounded) {
        super(rounded);
        this.initLegalProponent();
    }

    public LegalProponent() {
        this.initLegalProponent();
    }

    public void initLegalProponent() {
        this.configLegalProponent();
        this.configLegalProponentLayout();
        this.createTitle();
        this.createinput();
        this.createFileChooser();
        this.createButton();

    }

    public void configLegalProponent() {
        defaultWidth = 700;
        defaultHeigth = 400;
        setPreferredSize(new Dimension(defaultWidth, defaultHeigth));
        this.containerTitle = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(0, 0, 18, 0);
            }
        };
        this.formulationContentLeft = new TransparentPanel();
        this.formulationContentRight = new TransparentPanel();
        this.containerFormulation = new TransparentPanel();
        this.actions = new RegisterActions();

    }

    private void configLegalProponentLayout() {
        addContent(this.containerTitle);
        addContent(this.containerFormulation);
        this.containerFormulation.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.containerFormulation.add(formulationContentLeft, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.containerFormulation.add(this.formulationContentRight, gbc);
        formulationContentLeft.setLayout(new GridBagLayout());
        formulationContentRight.setLayout(new GridBagLayout());

    }

    private void createTitle() {
        this.title = new TextTitle("Persona jurídica");
        title.setPreferredSize(new Dimension(320,45));
        this.containerTitle.add(this.title, SwingConstants.CENTER);

    }

    private void createinput() {
        this.inputID = createInputText("Cédula de identidad del representante legal", this.columnsInputDefault);
        TransparentPanel container = new TransparentPanel();
        container.add(this.inputID);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.formulationContentLeft.add(container, gbc);

        this.inputID.addComponentListener(new ComponentAdapter() {
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

        this.fileChooserCommercialRegister = createFileChoosers("Registro mercantil");
        TransparentPanel container_1 = new TransparentPanel();
        container_1.add(this.fileChooserCommercialRegister);

        this.fileChooserRIF = createFileChoosers("Registro de información fiscal (RIF)");
        TransparentPanel container_2 = new TransparentPanel();
        container_2.add(this.fileChooserRIF);

        this.fileChooserISLR = createFileChoosers("Certificado de declaración ISLR");
        TransparentPanel container_3 = new TransparentPanel();
        container_3.add(this.fileChooserISLR);

        this.fileChooserCurriculum = createFileChoosers("Resumen curricular");
        TransparentPanel container_4 = new TransparentPanel();
        container_4.add(this.fileChooserCurriculum);

        this.fileChooserDegree = createFileChoosers("Copia del título universitario");
        TransparentPanel container_5 = new TransparentPanel();
        container_5.add(this.fileChooserDegree);

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
        this.button = new ButtonRounded("Registrarse", this.roundedButtonGlobal);
        setRedimentionPane(button, inputID.getWidth(), this.heightButton);
        TransparentPanel container = new TransparentPanel();
        container.add(this.button);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 90, 0);
        formulationContentRight.add(container, gbc);

         this.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actions.actionsButtonFinishRegister();
            }
        });
    }

    @Override
    protected void configResizeLarge() {
        setRedimentionFields(inputID, 34, 45);
        revalidate();
        repaint();
    }

    @Override
    protected void configResizeMedium() {
        setRedimentionFields(inputID, columnsInputDefault, 40);
        revalidate();
        repaint();
    }

    @Override
    protected void configResizeSmall() {
        
    }

}
