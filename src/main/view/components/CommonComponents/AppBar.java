package main.view.components.commonComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import main.Env;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.utils.ColorPalette;
import main.view.utils.Components;

public class AppBar extends AbstractPanelRounded {
    private TransparentPanel leftContent;
    private TransparentPanel rightContent;
    private static TransparentPanel navContent;
    private int height = 84;
    private int widthRightContent = 195;

    public AppBar() {
        super(0);
        initAppbar();
    }

    private void initAppbar() {
        configAppBar();
        createHeader();
        createNav();
  
    }

    private void configAppBar() {
        setLayout(new BorderLayout());
        setBackground(ColorPalette.COLOR_PRIMARY);
        setPreferredSize(new Dimension(getWidth(), height));
        leftContent = new TransparentPanel();
        rightContent = new TransparentPanel();
        add(leftContent, BorderLayout.WEST);
        add(rightContent, BorderLayout.EAST);
        rightContent.setLayout(new GridBagLayout());
        rightContent.setPreferredSize(new Dimension(widthRightContent, getHeight()));
      
    }

    public void createHeader() {
        TextTitle title = new TextTitle("Course Stack");
        title.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(260,50));
        ImageAndComponent header = new ImageAndComponent(Env.PATH_IMAGE_APPBAR, 70, 70, title) {
            @Override
            public Insets getGapIcon() {
                return new Insets(0, 0, 0, 15);
            }
        };

        leftContent.add(header);

    }

    private void createNav() {
        if (navContent != null) {
            Components.removeElement(rightContent, navContent);
        }
        navContent = new TransparentPanel();

        rightContent.add(navContent);
    }

    public void createNavProponent() {
        cleanNavContent();
        createNav();
        int iconHeight = 40;
        int iconWidth = 40;
        int size = 5;

        TransparentPanel homeContent = new TransparentPanel();
        LabelWithImage home = new LabelWithImage(new ImageIcon(Env.PATH_ICON_HOME), iconWidth, iconHeight);
        homeContent.add(home);
        aplicateCursorHand(home);

        TransparentPanel userContent = new TransparentPanel();
        LabelWithImage user = new LabelWithImage(new ImageIcon(Env.PATH_ICON_USER), iconWidth + size,
                iconHeight + size);
        userContent.add(user);
        aplicateCursorHand(user);

        TransparentPanel backContent = new TransparentPanel();
        LabelWithImage back = new LabelWithImage(new ImageIcon(Env.PATH_ICON_BACK), iconWidth, iconHeight);
        backContent.add(back);
        aplicateCursorHand(back);

        navContent.add(homeContent);

        navContent.add(userContent);

        navContent.add(backContent);

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actionsIconHome();
            }
        });

        user.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actionsIconUser();
            }
        });

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actionsIconLogOut();
            }
        });

    }

    public void createNavAdministrator() {
        cleanNavContent();
        createNav();

        int iconHeight = 40;
        int iconWidth = 40;
        TransparentPanel backContent = new TransparentPanel();
        LabelWithImage back = new LabelWithImage(new ImageIcon(Env.PATH_ICON_BACK), iconWidth, iconHeight);

        backContent.add(back);
        aplicateCursorHand(back);
        GridBagConstraints gbc = new GridBagConstraints();
        navContent.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.EAST;
        navContent.add(backContent, gbc);
        navContent.setPreferredSize(new Dimension(widthRightContent-15, 60));

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actionsIconLogOut();
            }
        });

    }

    public void createNavRegister(){
        cleanNavContent();
        createNav();

        int iconHeight = 40;
        int iconWidth = 40;
        TransparentPanel backContent = new TransparentPanel();
        LabelWithImage back = new LabelWithImage(new ImageIcon(Env.PATH_ICON_BACK), iconWidth, iconHeight);

        backContent.add(back);
        aplicateCursorHand(back);
        GridBagConstraints gbc = new GridBagConstraints();
        navContent.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.EAST;
        navContent.add(backContent, gbc);
        navContent.setPreferredSize(new Dimension(widthRightContent-15, 60));

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                actionsIconBackTypeProponent();
            }
        });


    }

    private void aplicateCursorHand(JComponent component) {
        component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void cleanNavContent() {
        Components.removeElementAll(navContent);

    }

    public void actionsIconHome() {

    }

    public void actionsIconUser() {

    }

    public void actionsIconLogOut() {

    }

    public void actionsIconBackTypeProponent() {

    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 10, 0, 1);
    }

}
