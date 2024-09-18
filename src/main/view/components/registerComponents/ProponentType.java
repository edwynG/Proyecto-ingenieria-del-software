package main.view.components.registerComponents;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.SwingConstants;

import main.Env;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.CommonComponents.ButtonRounded;
import main.view.components.CommonComponents.Dropdown;
import main.view.components.CommonComponents.ImageAndComponent;
import main.view.components.CommonComponents.TextSubtitle;
import main.view.components.CommonComponents.TextTitle;
import main.view.components.CommonComponents.TransparentPanel;

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
    private int roundedButtonGlobal = 15;

    private RegisterActions actions;

    public ProponentType() {
        initProponentType();
    }

    public ProponentType(int rounded) {
        super(rounded);
        initProponentType();
    }

    private void initProponentType() {
        this.configProponentType();
        this.createTitle();
        this.createDropdown();
        this.createButtons();
    }

    private void configProponentType() {
        this.actions = new RegisterActions();
    }

    private void createTitle() {
        int marginBottom = 7;
        int gap = 5;
        // Titula
        this.title = new TextTitle("Proponente", SwingConstants.CENTER);

        // sub-Titulo
        this.subTitle = new TextSubtitle("<html>¡<b>Registrate</b> con nosotros y propón tu curso!</html>",
                SwingConstants.CENTER);

        // contenedor
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridLayout(2, 1, gap, gap));
        container.add(this.title);
        container.add(this.subTitle);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));// margin vertical
    }

    private void createDropdown() {
        int height = 41;
        int width = 41;
        int marginBottom = 20;
        this.dropdown = new Dropdown(Main.WINDOW,"Tipo de persona");
        ImageAndComponent container = new ImageAndComponent(Env.PATH_ICON_USER, width, height, dropdown);
        addContent(container);
        addContent(Box.createVerticalStrut(marginBottom));

    }

    private void createButtons() {
        this.buttonBefore = new ButtonRounded("Anterior", this.roundedButtonGlobal);
        this.buttonNext = new ButtonRounded("Siguente", this.roundedButtonGlobal);
        containerbuttons = new TransparentPanel();
        containerbuttons.setLayout(new GridLayout(1, 2, this.gapBetweenButtons, this.gapBetweenButtons));

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
        container_1.add(this.buttonBefore, gbc);

        // Contenedor boton next
        TransparentPanel container_2 = new TransparentPanel();
        container_2.setLayout(new GridBagLayout());
        container_2.add(this.buttonNext, gbc);

        // añade contendores
        containerbuttons.add(container_1);
        containerbuttons.add(container_2);

        addContent(containerbuttons);
        resizeButtonSm();
        this.buttonBefore.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actions.eventButtonBefore();
            }
        });

        this.buttonNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actions.eventButtonNext();
            }
        });
    }

    private void resizeDropdown(int width, int height) {
        this.dropdown.setPreferredSize(new Dimension(width, height));
        this.dropdown.revalidate();
        this.dropdown.repaint();
    }

    private void resizeButtonLg() {
        buttonBefore.setPreferredSize(new Dimension(150, 40));
        buttonNext.setPreferredSize(new Dimension(150, 40));
    }

    private void resizeButtonSm() {
        buttonBefore.setPreferredSize(new Dimension(100, 40));
        buttonNext.setPreferredSize(new Dimension(100, 40));

    }

    @Override
    protected void configResizeLarge() {
        title.setFontSize(55);
        resizeDropdown(375, heightDropdown);
        subTitle.setFontSize(14);
        resizeButtonLg();

    }

    @Override
    protected void configResizeMedium() {
        title.setFontSize(fontSizeTitle);
        subTitle.setFontSize(fontSizeSubtitle);
        resizeDropdown(265, heightDropdown);
        if (getWidth() > this.lowerLimit + 150 && getWidth() <= this.upperLimit) {
            resizeButtonLg();
        } else {
            resizeButtonSm();

        }
    }

    @Override
    protected void configResizeSmall() {
        title.setFontSize(fontSizeTitle);
        resizeDropdown(widthDropdown, heightDropdown);
        resizeButtonSm();
        subTitle.setFontSize(fontSizeSubtitle);
    }

}
