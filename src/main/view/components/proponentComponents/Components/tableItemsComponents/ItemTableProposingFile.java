package main.view.components.proponentComponents.Components.tableItemsComponents;

import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.FileChooser;
import main.view.components.commonComponents.TextSubtitle;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

public class ItemTableProposingFile extends AbstractPanelRounded {
    private TextSubtitle name;
    private FileChooser LetterOfIntent;
    private FileChooser LetterOfCommitment;
    private TextSubtitle Status;
    private int id;

    public ItemTableProposingFile(String name, int id) {
        super(0);
        this.name = new TextSubtitle(name, SwingConstants.LEFT);
        this.id = id;
        initItemTableProposingFile();
    }

    private void initItemTableProposingFile() {
        configItemTableCourseWithAval();
        configText();
        createComponents();
    }

    private void configItemTableCourseWithAval() {
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorPalette.COLOR_PRIMARY));
        setBackground(ColorPalette.TRANSPARENT);
        setLayout(new BorderLayout());

    }

    private void configText() {
        TransparentPanel containerName = new TransparentPanel();
        containerName.setLayout(new GridBagLayout());
        containerName.add(name);
        Components.setRedimentionComponent(name, 159, 40);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setForeground(ColorPalette.COLOR_HOVER);
        add(containerName, BorderLayout.WEST);

    }

    private void createComponents() {
        int width = 40;
        int height = 40;
        LetterOfIntent = new FileChooser("Carta de inteción") {
            @Override
            protected void DisapprovedFile() {

            }

            @Override
            protected void ApprovateFile() {

            }
        };
        LetterOfCommitment = new FileChooser("Carta de compromiso") {
            @Override
            protected void DisapprovedFile() {

            }

            @Override
            protected void ApprovateFile() {

            }
        };
        LetterOfCommitment.NotVisibleText();
        LetterOfIntent.NotVisibleText();
        Components.setRedimentionComponent(LetterOfIntent, width, height);
        Components.setRedimentionComponent(LetterOfCommitment, width, height);
        LetterOfCommitment.setRedimentionIcon(width, height);
        LetterOfIntent.setRedimentionIcon(width, height);
        LetterOfCommitment.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));
        LetterOfIntent.setBorder(Components.customrBorder(0, ColorPalette.TRANSPARENT));

        TransparentPanel containerSchedule = new TransparentPanel();
        containerSchedule.setLayout(new GridBagLayout());
        containerSchedule.add(LetterOfIntent);
        TransparentPanel containerLetterOfCommitment = new TransparentPanel();
        containerLetterOfCommitment.setLayout(new GridBagLayout());
        containerLetterOfCommitment.add(LetterOfCommitment);
        Status = new TextSubtitle("Proponente", SwingConstants.CENTER);
        Status.setFontSize(15);
        Status.setFontWeight(Font.BOLD);
        Status.setForeground(ColorPalette.COLOR_FIELD);
        TransparentPanel containerStatus = new TransparentPanel();
        containerStatus.setLayout(new BorderLayout());
        containerStatus.add(Status, BorderLayout.CENTER);

        TransparentPanel containerCenter = new TransparentPanel();
        containerCenter.setLayout(new GridLayout(1, 3));
        containerCenter.add(containerStatus);
        containerCenter.add(containerSchedule);
        containerCenter.add(containerLetterOfCommitment);
        add(containerCenter, BorderLayout.CENTER);

        actionsComponents();
    }

    private void actionsComponents() {
        LetterOfIntent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);
                InterfaceProponent.actions.actionsUploadDocument();
            }
        });
        LetterOfCommitment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(id);
                InterfaceProponent.actions.actionsUploadDocument();

            }
        });

    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 20, 0, 25);
    }
}
