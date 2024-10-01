package main.view.components.commonComponents;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import javax.swing.Box;
import java.awt.GridBagLayout;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class CardMessage extends AbstractPanelRounded {
    private TextTitle title;
    private TextSubtitle message;
    private Integer height;
    private Integer width;

    public CardMessage(String title, String message) {
        this.title = new TextTitle(title, SwingConstants.CENTER);
        this.message = new TextSubtitle("<html>" + message + "</html>", SwingConstants.CENTER);
        initCardMessage();
    }

    private void initCardMessage() {
        height = 220;
        width = 350;
        int marginBottom = 10;
        Components.setRedimentionComponent(this, width, height);
        message.setFontSize(16);
        TransparentPanel container = new TransparentPanel();
        TransparentPanel containerTitle = new TransparentPanel();
        TransparentPanel containerMessage = new TransparentPanel();

        containerTitle.add(title);
        title.setForeground(Color.RED);
        message.setForeground(ColorPalette.COLOR_SENCOD);
        containerMessage.add(message);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(containerTitle);
        container.add(Box.createVerticalStrut(marginBottom));
        container.add(containerMessage);
        Components.setRedimentionComponent(containerMessage, width, 50);
        setLayout(new GridBagLayout());
        add(container);
    }

    public Integer getWidthCard() {
        return width;
    }

    public Integer getHeightCard() {
        return width;
    }

    public void settWidthCard(Integer width) {
        this.width = width;
        Components.setRedimentionComponent(this, width, height);

    }

    public void setHeightCard(Integer height) {
        this.height = height;
        Components.setRedimentionComponent(this, width, height);

    }

}
