package main.view.components.proponentComponents.Components.viewMorePanelComponents;

import java.awt.Insets;

import main.Env;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TextTitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import main.view.utils.CustomVariables;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ViewMorePanel extends AbstractPanelRounded {
    private Integer proposalID;
    private TextTitle title;
    private String titleContent = "Curso";
    private String evaluation = "Unidad resposanble";
    private String result = "En espera";
    private String statusText = Env.STATUS_PROPONENT;
    private String fileBase64 = null;
    private TransparentPanel registers;
    private FileChooser button;
    private int width = 600;
    private int height = 400;

    public ViewMorePanel(Integer proposalId) {
        super(CustomVariables.RADIO_DEFAULT_PANEL);
        this.proposalID = proposalId;
        initViewMorePanel();

    }

    private void initViewMorePanel() {
        Components.setRedimentionComponent(this, width, height);
        setBackground(ColorPalette.BG_COLOR_WRITE);
        setLayout(new BorderLayout());
        configInfoPanel();
        createTitle();
        createTable();
        createbutton();
    }

    private void configInfoPanel() {
        String name = Main.getProponentControl().getNameCourse(proposalID);
        String denom = Main.getProponentControl().getDenomCourse(proposalID);
        titleContent = name != null && denom != null ? denom + " de " + name : titleContent;
        String respUnit = Main.getProponentControl().getRespUnittCourse(proposalID);
        evaluation = respUnit != null ? respUnit : evaluation;
        ArrayList<String> proposalDetails = Main.getProponentControl().getDetailsResultProposal(proposalID);
        if (proposalDetails == null || proposalDetails.isEmpty()) {
            return;
        }
        // Este codigo es en base al orden en la base de datos
        fileBase64 = proposalDetails.get(proposalDetails.size() - 2);
        if (proposalDetails.getLast() == null) {
            return;
        }
        if (proposalDetails.getLast().equals(Env.ACCEPT)) {
            statusText = Env.STATUS_PROPONENTS_ACCEPTED;
            result = Env.ACCEPT;
            return;

        }

        if (proposalDetails.getLast().equals(Env.REFUSED)) {
            statusText = Env.STATUS_PROPONENT;
            result = Env.REFUSED;
            return;
        }

        if (proposalDetails.getLast().equals(Env.WAIT)) {
            statusText = Env.STATUS_PROPONENT;
            result = Env.WAIT;
            return;
        }

    }

    private void createTitle() {
        title = new TextTitle(titleContent, SwingConstants.CENTER);
        TransparentPanel container = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(0, 10, 10, 10);
            }
        };
        container.setLayout(new BorderLayout());
        container.add(title, BorderLayout.CENTER);
        title.setFontSize(16);
        title.setFontWeight(Font.BOLD);
        container.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.COLOR_FIELD));
        add(container, BorderLayout.NORTH);
    }

    private void createTable() {
        int fontsize = 20;
        TextSubtitle textEvalutation = new TextSubtitle("Evaluador");
        TextSubtitle textResult = new TextSubtitle("Resultado", SwingConstants.CENTER);
        TextSubtitle textStatus = new TextSubtitle("Estatus");
        textEvalutation.setFontSize(fontsize);
        textResult.setFontSize(fontsize);
        textStatus.setFontSize(fontsize);
        TransparentPanel table = new TransparentPanel();
        TransparentPanel containerTableFields = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(20, 0, 20, 0);
            }
        };
        TransparentPanel containerTableRegisters = new TransparentPanel();
        registers = new TransparentPanel();

        add(table, BorderLayout.CENTER);
        table.setLayout(new BorderLayout());
        table.add(containerTableFields, BorderLayout.NORTH);
        table.add(containerTableRegisters, BorderLayout.CENTER);
        containerTableRegisters.setLayout(new BorderLayout());
        containerTableRegisters.add(registers, BorderLayout.NORTH);

        containerTableFields.setLayout(new BorderLayout(10, 10));
        containerTableFields.add(textEvalutation, BorderLayout.WEST);
        containerTableFields.add(textResult, BorderLayout.CENTER);
        containerTableFields.add(textStatus, BorderLayout.EAST);
        containerTableFields.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.COLOR_FIELD));
        createTableregister();
    }

    private void createTableregister() {
        TextSubtitle Evalutation = new TextSubtitle("<html>" + evaluation + "</html>");
        TextSubtitle Result = new TextSubtitle(result, SwingConstants.LEFT);
        TextSubtitle Status = new TextSubtitle(statusText);
        int fontsize = 18;
        Evalutation.setFontSize(fontsize);
        Result.setFontSize(fontsize);
        Status.setFontSize(fontsize);
        TransparentPanel container = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(10, 0, 10, 0);
            }
        };
        Components.setRedimentionComponent(Evalutation, 200, 50);
        container.setLayout(new BorderLayout(10, 10));
        container.add(Evalutation, BorderLayout.WEST);
        container.add(Result, BorderLayout.CENTER);
        container.add(Status, BorderLayout.EAST);
        registers.setLayout(new BorderLayout());
        registers.add(container, BorderLayout.CENTER);
    };

    private void createbutton() {
        TransparentPanel container = new TransparentPanel();
        button = new FileChooser("Observaciones");
        button.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        button.configMethodDownload();
        button.setFontSizeText(15);
        button.setFontWeight(Font.BOLD);
        Components.setRedimentionComponent(button, 165, 40);
        container.setLayout(new GridBagLayout());
        container.add(button);
        add(container, BorderLayout.SOUTH);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                InterfaceProponent.actions.actionsDownload(button.getPath(), fileBase64);
            }
        });
    };

    @Override
    public Insets getInsets() {
        return new Insets(20, 40, 20, 40);
    }
}
