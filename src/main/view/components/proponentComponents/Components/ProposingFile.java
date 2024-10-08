package main.view.components.proponentComponents.Components;

import main.Env;
import main.controller.Validator;
import main.model.Proposal;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.ScrollPaneWin11;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.Components.tableItemsComponents.ItemTableProposingFile;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

public class ProposingFile extends AbstractPanelRounded {
    private int width = 700;
    private int heigth = 500;

    private TextTitle Title;

    private TransparentPanel Table;
    private TransparentPanel TableContent;
    private TextSubtitle TableTextName;
    private TextSubtitle TableTextLetterOfIntent;
    private TextSubtitle TableTextLetterOfCommitment;
    private TextSubtitle TableTextStatus;

    private int fontsizeTableTextHeader = 20;

    public ProposingFile() {
        super(0);
        initProposingFile();
    }

    private void initProposingFile() {
        setBackground(ColorPalette.TRANSPARENT);
        setBackground(ColorPalette.TRANSPARENT);
        Components.setRedimentionComponent(this, width, heigth);
        setLayout(new BorderLayout(10, 10));
        createTitle();
        createTable();

    }

    private void createTitle() {
        Title = new TextTitle("Expediente de proponente", SwingConstants.LEFT);
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

        TableTextName = new TextSubtitle("Nombre", SwingConstants.LEFT);
        TableTextStatus = new TextSubtitle("Estatus", SwingConstants.CENTER);
        TableTextLetterOfIntent = new TextSubtitle("Carta de Inteción", SwingConstants.CENTER);
        TableTextLetterOfCommitment = new TextSubtitle("Carta de compromiso", SwingConstants.RIGHT);

        TableTextName.setFontSize(fontsizeTableTextHeader);
        TableTextLetterOfIntent.setFontSize(fontsizeTableTextHeader);
        TableTextLetterOfCommitment.setFontSize(fontsizeTableTextHeader);
        TableTextStatus.setFontSize(fontsizeTableTextHeader);
        TransparentPanel containerCenterHeader = new TransparentPanel();
        containerCenterHeader.setLayout(new GridLayout(1, 3, 10, 10));
        containerCenterHeader.add(TableTextStatus);
        containerCenterHeader.add(TableTextLetterOfIntent);
        containerCenterHeader.add(TableTextLetterOfCommitment);

        header.setLayout(new BorderLayout());
        header.add(TableTextName, BorderLayout.WEST);
        header.add(containerCenterHeader, BorderLayout.CENTER);
        Components.setRedimentionComponent(TableTextName, 140, 40);
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
        Validator validator = new Validator();
        for (int i = 0; i < Main.getProponentControl().getProposals().size(); i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            Proposal proposal = Main.getProponentControl().getProposals().reversed().get(i);
            String type = validator.isAcceptedProposal(proposal.getProposalId()) ? Env.TYPE_USER_ALIADO
                    : Env.TYPE_USER_PROPONENT;
            ItemTableProposingFile item = new ItemTableProposingFile(proposal.getTitle(), type,
                    proposal.getProposalId());
            TableContent.add(item, gbc);

        }
    }

}
