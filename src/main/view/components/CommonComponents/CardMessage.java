package main.view.components.commonComponents;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import javax.swing.Box;
import java.awt.GridBagLayout;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.utils.ColorPalette;


public class CardMessage extends AbstractPanelRounded {
    private TextTitle title;
    private TextSubtitle message;

    public CardMessage(String title, String message) {
        this.title = new TextTitle(title, SwingConstants.CENTER);
        this.message = new TextSubtitle(message,SwingConstants.CENTER);
        initCardMessage();
    }

    private void initCardMessage() {
        int marginBottom = 10;
        setPreferredSize(new Dimension(350, 220));
        message.setFontSize(16);
        TransparentPanel container = new TransparentPanel();
        TransparentPanel containerTitle = new TransparentPanel();
        TransparentPanel containerMessage = new TransparentPanel();

        containerTitle.add(title);
        this.title.setForeground(Color.RED);
        this.message.setForeground(ColorPalette.COLOR_SENCOD);
        containerMessage.add(message);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(containerTitle);
        container.add(Box.createVerticalStrut(marginBottom));
        container.add(containerMessage);
        setLayout(new GridBagLayout());
        add(container);
    }
}
