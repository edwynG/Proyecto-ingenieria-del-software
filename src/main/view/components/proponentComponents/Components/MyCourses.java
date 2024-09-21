package main.view.components.proponentComponents.Components;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.CommonComponents.ButtonRounded;
import main.view.components.CommonComponents.ScrollPaneWin11;
import main.view.components.CommonComponents.TextSubtitle;
import main.view.components.CommonComponents.TextTitle;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.utils.ColorPalette;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyCourses extends AbstractPanelRounded {
    private int width = 700;
    private int heigth = 500;

    private TextTitle Title;
    private ButtonRounded buttonCourseWithAval;
    private ButtonRounded buttonProposeCourse;

    private TransparentPanel Table;
    private TransparentPanel TableContent;

    private TextSubtitle TableTextName;
    private TextSubtitle TableTextType;
    private TextSubtitle TableTextStatus;

    private int roundedButtonGlobal = 15;
    private int fontsizeTableTextHeader = 25;

    public MyCourses() {
        initMyCourse();
    }

    public void initMyCourse() {
        setBackground(ColorPalette.TRANSPARENT);
        setPreferredSize(new Dimension(width, heigth));
        setLayout(new BorderLayout(10, 10));
        createTitle();
        createTable();
        createButtons();
    }

    private void createTitle() {
        Title = new TextTitle("Mis cursos", SwingConstants.LEFT);
        Title.setPreferredSize(new Dimension(300, 31));
        TransparentPanel container = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(5, 0, 20, 0);
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
                return new Insets(0, 25, 0, 25);
            }
        };
        Table.add(header, BorderLayout.NORTH);
        TableContent = new TransparentPanel();
        TransparentPanel content = new TransparentPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(ColorPalette.BG_COLOR_WRITE);
        content.add(TableContent, BorderLayout.NORTH);
        ScrollPaneWin11 scrollTable = new ScrollPaneWin11(content);

        scrollTable.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        Table.add(scrollTable, BorderLayout.CENTER);

        TableTextName = new TextSubtitle("Nombre", SwingConstants.LEFT);
        TableTextType = new TextSubtitle("Tipo", SwingConstants.CENTER);
        TableTextStatus = new TextSubtitle("Estado", SwingConstants.RIGHT);

        TableTextName.setFontSize(fontsizeTableTextHeader);
        TableTextType.setFontSize(fontsizeTableTextHeader);
        TableTextStatus.setFontSize(fontsizeTableTextHeader);

        header.setLayout(new BorderLayout(10, 10));
        header.add(TableTextName, BorderLayout.WEST);
        header.add(TableTextType, BorderLayout.CENTER);
        header.add(TableTextStatus, BorderLayout.EAST);
        createItemsTable();
    }

    private void createButtons() {
        buttonProposeCourse = new ButtonRounded("Proponer cursos", roundedButtonGlobal);
        buttonCourseWithAval = new ButtonRounded("Cursos con aval", roundedButtonGlobal);
        TransparentPanel container = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(10, 0, 2, 0);
            }
        };
        container.setLayout(new BorderLayout(20, 20));
        container.add(buttonProposeCourse, BorderLayout.WEST);
        container.add(buttonCourseWithAval, BorderLayout.EAST);
        add(container, BorderLayout.SOUTH);

        buttonProposeCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceProponent.actions.actionsButtonProposeCourse();
            }
        });

        buttonCourseWithAval.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceProponent.actions.actionsButtonCourseWithAval();
            }
        });

    }

    private void createItemsTable() {
        TableContent.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.ipady = 52;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        for (int i = 0; i < 4; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            ItemTableMyCourse item = new ItemTableMyCourse("Fundamentos de java", "Diplomado", i);
            TableContent.add(item, gbc);

        }
    }
}
