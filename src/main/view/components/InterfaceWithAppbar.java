package main.view.components;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import main.Env;
import main.view.Main;
import main.view.components.AbstractComponents.AbstractPanelRounded;
import main.view.components.commonComponents.AppBar;
import main.view.components.commonComponents.TransparentPanel;
import main.view.components.loginComponents.Login;
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.components.registerComponents.LegalProponent;
import main.view.components.registerComponents.NaturalProponent;
import main.view.components.registerComponents.ProponentType;
import main.view.utils.ColorPalette;
import main.view.utils.Components;
import main.view.utils.CustomVariables;

public class InterfaceWithAppbar extends AbstractPanelRounded {
    private AppBar appBar;
    public static InterfaceProponent ProponentDesing;
    private static TransparentPanel content;

    public InterfaceWithAppbar() {
        super(0);
        this.initInterfaceWithAppbar();
    }

    private void initInterfaceWithAppbar() {
        this.configInterfaceWithAppbar();

    }

    private void configInterfaceWithAppbar() {
        setLayout(new BorderLayout());
        setBackground(ColorPalette.COLOR_SENCOD);
        content = new TransparentPanel() {
            @Override
            public Insets getInsets() {
                return new Insets(30, 30, 30, 30);
            }
        };
        content.setLayout(new GridBagLayout());
        this.appBar = new AppBar() {
            @Override
            public void actionsIconLogOut() {
                Main.setContent(new InterfaceWithoutAppbar(Env.PATH_IMAGE_MAIN));
                InterfaceWithoutAppbar.setFormulation(new Login(CustomVariables.RADIO_DEFAULT_PANEL));

            }

            @Override
            public void actionsIconBackTypeProponent() {
                Main.setContent(new InterfaceWithoutAppbar(Env.PATH_IMAGE_MAIN));
                InterfaceWithoutAppbar.setFormulation(new ProponentType(CustomVariables.RADIO_DEFAULT_PANEL));
            }

            @Override
            public void actionsIconHome() {
                ProponentDesing.createMyCourseHome();
            }

            @Override
            public void actionsIconUser() {
                ProponentDesing.createProposingFile();
            }
        };

        add(appBar, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);

    }

    public void createFormulationNatural() {
        cleanContent();
        appBar.createNavRegister();
        NaturalProponent naturalPerson = new NaturalProponent(CustomVariables.RADIO_DEFAULT_PANEL);
        content.add(naturalPerson);

        int width = 1100;
        int heigth = 720;
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > width && getHeight() > heigth) {
                    naturalPerson.setRedimention(500, 600);

                } else {
                    naturalPerson.redimentionRestore();

                }
            }
        });

    }

    public void createFormulationJuridico() {
        cleanContent();
        appBar.createNavRegister();
        LegalProponent legalPerson = new LegalProponent(CustomVariables.RADIO_DEFAULT_PANEL);
        content.add(legalPerson);

        int width = 1100;
        int heigth = 720;
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > width && getHeight() > heigth) {
                    legalPerson.setRedimention(1024, 560);

                } else {
                    legalPerson.redimentionRestore();

                }
            }
        });
    }

    public void createInterfaceProponent() {
        cleanContent();
        appBar.createNavProponent();
        ProponentDesing = new InterfaceProponent(CustomVariables.RADIO_DEFAULT_PANEL);
        content.add(ProponentDesing);

        int width = 920;
        int heigth = 800;

        ProponentDesing.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > width && getHeight() > heigth) {
                    ProponentDesing.setRedimention(1024, 560);

                } else {
                    ProponentDesing.redimentionRestoreTemp();
                }
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > width && getHeight() > heigth) {
                    ProponentDesing.setRedimention(1024, 560);

                } else {
                    ProponentDesing.redimentionRestoreTemp();
                }
            }
        });

    }

    public static void cleanContent() {
        Components.removeElementAll(content);
    }

    @Override
    public Insets getInsets() {
        return new Insets(0, 0, 0, 0);
    }

}
