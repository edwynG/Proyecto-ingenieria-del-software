package main.view.components.registerComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import main.view.components.AbstractComponents.AbstractForm;
import main.view.components.CommonComponents.TransparentPanel;

public class LegalProponent extends AbstractForm {
    private int defaultWidth = 650;
    private int defaultHeigth = 400;

    private TransparentPanel containerTitle;
    private TransparentPanel formulationContentLeft;
    private TransparentPanel formulationContentRight;
    private TransparentPanel containerFormulation;

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
        setPreferredSize(new Dimension(defaultWidth, defaultHeigth));
        this.containerTitle = new TransparentPanel();
        this.formulationContentLeft = new TransparentPanel();
        this.formulationContentRight = new TransparentPanel();
        this.containerFormulation = new TransparentPanel();
    }

    private void configLegalProponentLayout() {
        content.setLayout(new BorderLayout());
        addContent(this.containerTitle, BorderLayout.NORTH);
        addContent(this.containerFormulation, BorderLayout.CENTER);
        this.containerFormulation.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        this.containerFormulation.add(formulationContentLeft, gbc);
        containerTitle.setBackgroundRect(Color.red);
        formulationContentLeft.setBackgroundRect(Color.BLUE);
        formulationContentRight.setBackgroundRect(Color.CYAN);

    }

    private void createTitle() {

    }

    private void createinput() {

    }

    private void createFileChooser() {

    }

    private void createButton() {

    }

    @Override
    protected void configResizeLarge() {

    }

    @Override
    protected void configResizeMedium() {

    }

    @Override
    protected void configResizeSmall() {

    }

    @Override
    protected void configDefauldLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(content, gbc);
    }
}
