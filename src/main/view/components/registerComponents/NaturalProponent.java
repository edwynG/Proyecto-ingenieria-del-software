package main.view.components.registerComponents;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.SwingConstants;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.commonComponents.ButtonRounded;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.InputText;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.CustomVariables;

public class NaturalProponent extends AbstractForm {

    private TextTitle title;
    private InputText inputID;
    private FileChooser fileChooserRIF;
    private FileChooser fileChooserISLR;
    private FileChooser fileChooserCurriculum;
    private FileChooser fileChooserDegree;
    private ButtonRounded button;

    private int roundedButtonGlobal = CustomVariables.RADIO_DEFAULT_BUTTON;
    private int heightButton = 43;
    private int columnsInputDefault = 28;
    private RegisterActions actions;
    private int fontSizeTitle = 40;

    public NaturalProponent(int rounded) {
        super(rounded);
        this.initNaturalProponent();
    }

    public NaturalProponent() {
        this.initNaturalProponent();
    }

    public void initNaturalProponent() {
        this.configNaturalProponent();
        this.createTitle();
        this.createinput();
        this.createFileChooser();
        this.createButton();

    }

    private void configNaturalProponent() {
        setPreferredSize(new Dimension(this.defaultWidth, this.defaultHeigth));
        this.actions = new RegisterActions();
        defaultWidth = 380;
        defaultHeigth = 450;
    }

    private void createTitle() {
        int marginBottom = 15;
        // titulo
        this.title = new TextTitle("Persona natural", SwingConstants.CENTER);
        this.title.setPreferredSize(new Dimension(310, 55));
        TransparentPanel container = new TransparentPanel();
        container.add(this.title);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

    }

    private void createinput() {
        int marginBottom = 5;

        this.inputID = createInputText("Cédula de identidad", this.columnsInputDefault);
        TransparentPanel container = new TransparentPanel();
        container.add(this.inputID);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

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
        int marginBottom = 5;

        this.fileChooserRIF = createFileChoosers("Registro de información (RIF)");
        TransparentPanel container_1 = new TransparentPanel();
        container_1.add(this.fileChooserRIF);

        this.fileChooserISLR = createFileChoosers("Certificado de declaración ISLR");
        TransparentPanel container_2 = new TransparentPanel();
        container_2.add(this.fileChooserISLR);

        this.fileChooserCurriculum = createFileChoosers("Resumen curricular");
        TransparentPanel container_3 = new TransparentPanel();
        container_3.add(this.fileChooserCurriculum);

        this.fileChooserDegree = createFileChoosers("Copia del título universitario");
        TransparentPanel container_4 = new TransparentPanel();
        container_4.add(this.fileChooserDegree);

        addContent(container_1);
        addContent(Box.createVerticalStrut(marginBottom));
        addContent(container_2);
        addContent(Box.createVerticalStrut(marginBottom));
        addContent(container_3);
        addContent(Box.createVerticalStrut(marginBottom));
        addContent(container_4);
        addContent(Box.createVerticalStrut(marginBottom));
        addContent(Box.createVerticalStrut(marginBottom));
        setRedimentionFileChoosers(inputID.getWidth(), inputID.getHeight());

    }

    private void createButton() {
        this.button = new ButtonRounded("Registrarse", this.roundedButtonGlobal);
        setRedimentionPane(button, inputID.getWidth(), this.heightButton);
        TransparentPanel container = new TransparentPanel();
        container.add(button);
        addContent(container);

        this.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // La lista tiene que tener por la estructura de la consulta
                ArrayList<String> data=new ArrayList<>();
                data.add(inputID.getText());
                data.add(fileChooserRIF.getPath());
                data.add(fileChooserISLR.getPath());
                data.add(fileChooserCurriculum.getPath());
                data.add(fileChooserDegree.getPath());
                actions.actionsTerminateRegistrationProponent(data);
            }
        });

    }

    @Override
    protected void configResizeLarge() {
        setRedimentionFields(inputID, columnsInputDefault + 7, 45);
        this.title.setFontSize(this.fontSizeTitle + 1);
        revalidate();
        repaint();

    }

    @Override
    protected void configResizeMedium() {

    }

    @Override
    protected void configResizeSmall() {
        setRedimentionFields(inputID, columnsInputDefault, 40);
        this.title.setFontSize(this.fontSizeTitle);
        revalidate();
        repaint();
    }

}
