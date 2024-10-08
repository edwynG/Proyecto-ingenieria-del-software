package main.view.components.registerComponents;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.SwingConstants;

import main.Env;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.commonComponents.ButtonRounded;

import main.view.components.commonComponents.Dropdown;
import main.view.components.commonComponents.ImageAndComponent;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.Components;
import main.view.utils.CustomVariables;

public class ProponentType extends AbstractForm {

    private TextTitle title;
    private TextSubtitle subTitle;

    private Dropdown dropdown;
    private ButtonRounded buttonBefore;
    private ButtonRounded buttonNext;
    TransparentPanel containerbuttons = new TransparentPanel();

    private int widthDropdown = 250;
    private int heightDropdown = 40;
    private int fontSizeTitle = 40;
    private int fontSizeSubtitle = 12;
    private int gapBetweenButtons = 0;
    private int roundedButtonGlobal = CustomVariables.RADIO_DEFAULT_BUTTON;
    private int minWidthFormulation = 380;
    private int minHeightFormulation = 410;
    private RegisterActions actions;

    public ProponentType() {
        initProponentType();
    }

    public ProponentType(int rounded) {
        super(rounded);
        initProponentType();
    }

    private void initProponentType() {
        configProponentType();
        createTitle();
        createDropdown();
        createButtons();
    }

    private void configProponentType() {
        actions = new RegisterActions();
        defaultWidth = minWidthFormulation;
        defaultHeigth = minHeightFormulation;
        redimentionRestore();
    }

    private void createTitle() {
        int marginBottom = 7;
        int gap = 5;
        // Titula
        title = new TextTitle("Proponente", SwingConstants.CENTER);

        // sub-Titulo
        subTitle = new TextSubtitle("<html>¡<b>Registrate</b> con nosotros y propón tu curso!</html>",
                SwingConstants.CENTER);

        // contenedor
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridLayout(2, 1, gap, gap));
        container.add(title);
        container.add(subTitle);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));// margin vertical
    }

    private void createDropdown() {
        int height = 41;
        int width = 41;
        int marginBottom = 20;
        ArrayList<String> options = new ArrayList<>();
        options.add(Env.TYPE_USER_PROPONENT_NATURAL);
        options.add(Env.TYPE_USER_PROPONENT_LEGAL);
        dropdown = createDropdown("Tipo de persona", options);
        dropdown.setListElements(options);
        ImageAndComponent container = new ImageAndComponent(Env.PATH_ICON_USER, width, height, dropdown);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

    }

    private void createButtons() {
        buttonBefore = new ButtonRounded("Anterior", roundedButtonGlobal);
        buttonNext = new ButtonRounded("Siguente", roundedButtonGlobal);
        containerbuttons = new TransparentPanel();
        containerbuttons.setLayout(new GridLayout(1, 2, gapBetweenButtons, gapBetweenButtons));

        // configuracion de botones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 0, 0);

        // Contenedor button before
        TransparentPanel container_1 = new TransparentPanel();
        container_1.setLayout(new GridBagLayout());
        container_1.add(buttonBefore, gbc);

        // Contenedor boton next
        TransparentPanel container_2 = new TransparentPanel();
        container_2.setLayout(new GridBagLayout());
        container_2.add(buttonNext, gbc);

        // añade contendores
        containerbuttons.add(container_1);
        containerbuttons.add(container_2);

        addContent(containerbuttons);
        resizeButtonSm();
        buttonBefore.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actions.actionsButtonBefore();
            }
        });

        buttonNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actions.actionsButtonNext(dropdown.getSelectElement());
            }
        });
    }


    private void resizeButtonLg() {
        Components.setRedimentionComponent(buttonBefore, 150, 40);
        Components.setRedimentionComponent(buttonNext, 150, 40);

    }

    private void resizeButtonSm() {
        Components.setRedimentionComponent(buttonBefore, 100, 40);
        Components.setRedimentionComponent(buttonNext, 100, 40);

    }

    @Override
    protected void configResizeLarge() {
        title.setFontSize(55);
        setRedimentionDropdowns(375, heightDropdown + 5);
        subTitle.setFontSize(14);
        resizeButtonLg();

    }

    @Override
    protected void configResizeMedium() {
        title.setFontSize(fontSizeTitle);
        subTitle.setFontSize(fontSizeSubtitle);
        setRedimentionDropdowns(265, heightDropdown + 3);
        if (getWidth() > lowerLimit + 150 && getWidth() <= upperLimit) {
            resizeButtonLg();
        } else {
            resizeButtonSm();

        }
    }

    @Override
    protected void configResizeSmall() {
        title.setFontSize(fontSizeTitle);
        setRedimentionDropdowns(widthDropdown, heightDropdown);
        resizeButtonSm();
        subTitle.setFontSize(fontSizeSubtitle);
    }

}
