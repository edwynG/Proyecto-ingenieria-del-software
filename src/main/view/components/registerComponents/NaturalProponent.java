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
import main.view.utils.Components;
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
        initNaturalProponent();
    }

    public NaturalProponent() {
        initNaturalProponent();
    }

    public void initNaturalProponent() {
        configNaturalProponent();
        createTitle();
        createinput();
        createFileChooser();
        createButton();

    }

    private void configNaturalProponent() {
        setPreferredSize(new Dimension(defaultWidth, defaultHeigth));
        actions = new RegisterActions();
        defaultWidth = 380;
        defaultHeigth = 450;
    }

    private void createTitle() {
        int marginBottom = 15;
        // titulo
        title = new TextTitle("Persona natural", SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(310, 55));
        TransparentPanel container = new TransparentPanel();
        container.add(title);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

    }

    private void createinput() {
        int marginBottom = 5;

        inputID = createInputText("Cédula de identidad", columnsInputDefault);
        TransparentPanel container = new TransparentPanel();
        container.add(inputID);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

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
        int marginBottom = 5;

        fileChooserRIF = createFileChoosers("Registro de información (RIF)");
        TransparentPanel container_1 = new TransparentPanel();
        container_1.add(fileChooserRIF);

        fileChooserISLR = createFileChoosers("Certificado de declaración ISLR");
        TransparentPanel container_2 = new TransparentPanel();
        container_2.add(fileChooserISLR);

        fileChooserCurriculum = createFileChoosers("Resumen curricular");
        TransparentPanel container_3 = new TransparentPanel();
        container_3.add(fileChooserCurriculum);

        fileChooserDegree = createFileChoosers("Copia del título universitario");
        TransparentPanel container_4 = new TransparentPanel();
        container_4.add(fileChooserDegree);

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
        button = new ButtonRounded("Registrarse", roundedButtonGlobal);
        setRedimentionPane(button, inputID.getWidth(), heightButton);
        TransparentPanel container = new TransparentPanel();
        container.add(button);
        addContent(container);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // La lista tiene que tener la estructura de la consulta
                ArrayList<String> data = new ArrayList<>();
                data.add(inputID.getText().trim());
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
        setRedimentionFields(columnsInputDefault + 7, 45);
        title.setFontSize(fontSizeTitle + 1);
        Components.repaintComponent(this);


    }

    @Override
    protected void configResizeMedium() {

    }

    @Override
    protected void configResizeSmall() {
        setRedimentionFields(columnsInputDefault, 40);
        title.setFontSize(fontSizeTitle);
        Components.repaintComponent(this);

    }

}
