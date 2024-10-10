package main.view.components.proponentComponents.Components;

import main.Env;
import main.model.Proposal;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.ScrollPaneWin11;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.components.proponentComponents.Components.tableItemsComponents.ItemTableCourseWithAval;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CourseWithAval extends AbstractPanelRounded {
    private int width = 700;
    private int heigth = 500;
    private TextTitle Title;
    private TransparentPanel Table;
    private TransparentPanel TableContent;
    private TextSubtitle TableTextName;
    private TextSubtitle TableTextSchedule;
    private TextSubtitle TableTextCostos;

    private int fontsizeTableTextHeader = 20;

    public CourseWithAval() {
        initMyCourseWithAval();
    }

    public void initMyCourseWithAval() {
        setBackground(ColorPalette.TRANSPARENT);
        Components.setRedimentionComponent(this, width, heigth);
        setLayout(new BorderLayout(10, 10));
        createTitle();
        createTable();
        createButton();
    }

    private void createTitle() {
        Title = new TextTitle("Cursos con aval", SwingConstants.LEFT);
        Components.setRedimentionComponent(Title, 300, 40);
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
        TransparentPanel content = new TransparentPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(ColorPalette.BG_COLOR_WRITE);
        content.add(TableContent, BorderLayout.NORTH);
        ScrollPaneWin11 scrollTable = new ScrollPaneWin11(content);

        scrollTable.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        Table.add(scrollTable, BorderLayout.CENTER);

        TableTextName = new TextSubtitle("Nombre", SwingConstants.LEFT);
        TableTextSchedule = new TextSubtitle("Cronograma de ejecución", SwingConstants.CENTER);
        TableTextCostos = new TextSubtitle("Costos/Ingreso", SwingConstants.RIGHT);
        int width = 200;
        int height = 40;
        Components.setRedimentionComponent(TableTextName, width, height);
        Components.setRedimentionComponent(TableTextSchedule, width, height);
        Components.setRedimentionComponent(TableTextCostos, width, height);

        TableTextName.setFontSize(fontsizeTableTextHeader);
        TableTextSchedule.setFontSize(fontsizeTableTextHeader);
        TableTextCostos.setFontSize(fontsizeTableTextHeader);

        header.setLayout(new BorderLayout(10, 10));
        header.add(TableTextName, BorderLayout.WEST);
        header.add(TableTextSchedule, BorderLayout.CENTER);
        header.add(TableTextCostos, BorderLayout.EAST);
        createItemsTable();
    }

    private void createButton() {
        TransparentPanel container = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(18, 0, 5, 0);
            }
        };
        FileChooser ButtonLetterOfCommitment = new FileChooser("Carta de compromiso");
        Components.setRedimentionComponent(ButtonLetterOfCommitment, 210, 30);
        ButtonLetterOfCommitment.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        ButtonLetterOfCommitment.setFontSizeText(15);
        ButtonLetterOfCommitment.setFontWeight(Font.BOLD);
        ButtonLetterOfCommitment.configMethodDownload();
        container.setLayout(new BorderLayout());
        container.add(ButtonLetterOfCommitment, BorderLayout.WEST);
        add(container, BorderLayout.SOUTH);

        ButtonLetterOfCommitment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceProponent.actions.actionsDownload(ButtonLetterOfCommitment.getPath(),
                        Env.DOCUMENT_LETTER_OF_COMMITMENT);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }
        });

    }

    private void createItemsTable() {
        TableContent.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.ipady = 45;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        List<Proposal> porposalWithAval = Main.getProponentControl().getCourseWithAval().reversed();
        for (int i = 0; i < porposalWithAval.size(); i++) {
            gbc.gridx = 0;
            gbc.gridy = i;

            ItemTableCourseWithAval item = new ItemTableCourseWithAval(porposalWithAval.get(i).getTitle(),
                    porposalWithAval.get(i).getProposalId());
            TableContent.add(item, gbc);

        }
    }

}
