package main.view.components.administratorComponents.components;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.administratorComponents.components.tableItemsComponents.ItemTableCommission;
import main.view.components.commonComponents.ScrollPaneWin11;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;

public class ExtensionCommission extends AbstractPanelRounded {
    private int width = 700;
    private int heigth = 500;

    private TextTitle Title;

    private TransparentPanel Table;
    private TransparentPanel TableContent;
    private TextSubtitle TableTextCourse;
    private TextSubtitle TableTextProposaol;
    private TextSubtitle TableTextResult;
    private TextSubtitle TableTextStatus;
    private TextSubtitle TableTextObservation;

    private int fontsizeTableTextHeader = 20;

    public ExtensionCommission() {
        super(0);
        initExtensionCommission();
    }

    private void initExtensionCommission() {
        setBackground(ColorPalette.TRANSPARENT);
        setBackground(ColorPalette.TRANSPARENT);
        Components.setRedimentionComponent(this, width, heigth);
        setLayout(new BorderLayout(10, 10));
        createTitle();
        createTable();

    }

    private void createTitle() {
        Title = new TextTitle("Cursos propuestos", SwingConstants.LEFT);
        Components.setRedimentionComponent(Title, 300, 45);
        TransparentPanel container = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(5, 0, 10, 0);
            }
        };
        container.setLayout(new BorderLayout());
        container.add(Title, BorderLayout.CENTER);
        add(container, BorderLayout.NORTH);
    }

    private void createTable() {
        Table = new TransparentPanel();
        add(Table, BorderLayout.CENTER);
        Table.setLayout(new BorderLayout());
        TransparentPanel header = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(0, 25, 0, 32);
            }
        };
        Table.add(header, BorderLayout.NORTH);
        TableContent = new TransparentPanel();
        TransparentPanel containerContent = new TransparentPanel();
        containerContent.setLayout(new BorderLayout());
        containerContent.setBackground(ColorPalette.BG_COLOR_WRITE);
        containerContent.add(TableContent, BorderLayout.NORTH);
        ScrollPaneWin11 scrollTable = new ScrollPaneWin11(containerContent);

        scrollTable.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        Table.add(scrollTable, BorderLayout.CENTER);

        TableTextCourse = new TextSubtitle("Curso", SwingConstants.LEFT);
        TableTextStatus = new TextSubtitle("Estado", SwingConstants.CENTER);
        TableTextProposaol = new TextSubtitle("Propuesta", SwingConstants.CENTER);
        TableTextObservation = new TextSubtitle("Observaciones", SwingConstants.CENTER);
        TableTextResult = new TextSubtitle("Resultado", SwingConstants.RIGHT);

        TableTextCourse.setFontSize(fontsizeTableTextHeader);
        TableTextProposaol.setFontSize(fontsizeTableTextHeader);
        TableTextResult.setFontSize(fontsizeTableTextHeader);
        TableTextStatus.setFontSize(fontsizeTableTextHeader);
        TableTextObservation.setFontSize(fontsizeTableTextHeader);
        TransparentPanel containerCenterHeader = new TransparentPanel();
        containerCenterHeader.setLayout(new GridLayout(1, 4, 10, 10));
        containerCenterHeader.add(TableTextStatus);
        containerCenterHeader.add(TableTextProposaol);
        containerCenterHeader.add(TableTextObservation);
        containerCenterHeader.add(TableTextResult);

        header.setLayout(new BorderLayout());
        header.add(TableTextCourse, BorderLayout.WEST);
        header.add(containerCenterHeader, BorderLayout.CENTER);
        Components.setRedimentionComponent(TableTextCourse, 140, 40);
        TransparentPanel margin = new TransparentPanel();
        Components.setRedimentionComponent(margin, 200, 44);
        add(margin, BorderLayout.SOUTH);
        createItemsTable();
    }

    private void createItemsTable() {
        TableContent.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.ipady = 46;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        for (int i = 0; i < 4; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            ItemTableCommission item = new ItemTableCommission(
                    "<html>" + "Fundamentos de java" + "</html>", i);
            TableContent.add(item, gbc);

        }
    }
}
