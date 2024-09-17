package main.view.components;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import main.Env;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.CommonComponents.AppBar;
import main.view.components.CommonComponents.TransparentPanel;
import main.view.components.loginComponents.Login;
import main.view.components.registerComponents.LegalProponent;
import main.view.components.registerComponents.NaturalProponent;
import main.view.utils.ColorPalette;

public class InterfaceWithAppbar extends AbstractPanelRounded {
    private AppBar appBar;
    private static TransparentPanel content;

    public InterfaceWithAppbar() {
        super(0);
        this.initInterfaceWithAppbar();
    }

    private void initInterfaceWithAppbar() {
        this.configInterfaceWithAppbar();
        this.createFormulationJuridico();
    }

    private void configInterfaceWithAppbar() {
        setLayout(new BorderLayout());
        setBackgroundRect(ColorPalette.COLOR_SENCOD);
        content = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(30, 30, 30, 30);
            }
        };
        content.setLayout(new GridBagLayout());
        this.appBar = new AppBar() {
            @Override
            public void eventIconBack() {
                Main.setContent(new InterfaceWithoutAppbar(Env.PATH_IMAGE_MAIN));
                InterfaceWithoutAppbar.setFormulation(new Login());

            }
        };

        add(appBar, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);

    }

    public void createFormulationNatural() {
        cleanContent();
        int lg = 780;
        int heightLg = 780;
        TransparentPanel container = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(0, 0, 0, 0);
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 100, 0, 100);
        content.add(container, gbc);

        // Configuracion container
        container.setLayout(new GridBagLayout());
        gbc.insets = new Insets(0, 00, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BASELINE;
        NaturalProponent naturalPerson = new NaturalProponent(25);
        container.add(naturalPerson, gbc);

        container.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > lg && getHeight() > heightLg) {
                    naturalPerson.resize(500, 600);

                } else {
                    naturalPerson.resizeRestore();

                }
            }
        });

    }

    public void createFormulationJuridico() {
        cleanContent();
        TransparentPanel container = new TransparentPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(17, 50, 17, 50);
        content.add(container, gbc);

        LegalProponent legalPerson = new LegalProponent(25);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.BASELINE;
        gbc.anchor = GridBagConstraints.CENTER;
        container.add(legalPerson, gbc);

        int lg = 720;
        int heightLg = 720;
        container.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > lg && getHeight() > heightLg) {
                    legalPerson.resize(900, 530);
             
                } else {
                    legalPerson.resizeRestore();

                }
            }
        });
    }

    public static void cleanContent() {
        content.removeAll();
        content.revalidate();
        content.repaint();
    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 0, 0, 0);
    }

}
