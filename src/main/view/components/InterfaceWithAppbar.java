package main.view.components;

import java.awt.BorderLayout;
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
import main.view.components.proponentComponents.InterfaceProponent;
import main.view.components.registerComponents.LegalProponent;
import main.view.components.registerComponents.NaturalProponent;
import main.view.components.registerComponents.ProponentType;
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
        createInterfaceProponent();
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
            public void eventIconLogOut() {
                Main.setContent(new InterfaceWithoutAppbar(Env.PATH_IMAGE_MAIN));
                InterfaceWithoutAppbar.setFormulation(new Login(25));

            }

            @Override
            public void eventIconBackTypeProponent() {
                Main.setContent(new InterfaceWithoutAppbar(Env.PATH_IMAGE_MAIN));
                InterfaceWithoutAppbar.setFormulation(new ProponentType(25));
            }
        };

        add(appBar, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);

    }

    public void createFormulationNatural() {
        cleanContent();
        appBar.createNavRegister();
        NaturalProponent naturalPerson = new NaturalProponent(25);
        content.add(naturalPerson);

        int width = 1100;
        int heigth = 720;
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > width && getHeight() > heigth) {
                    naturalPerson.resize(500, 600);

                } else {
                    naturalPerson.resizeRestore();

                }
            }
        });

    }

    public void createFormulationJuridico() {
        cleanContent();
        appBar.createNavRegister();
        LegalProponent legalPerson = new LegalProponent(25);
        content.add(legalPerson);

        int width = 1100;
        int heigth = 720;
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > width && getHeight() > heigth) {
                    legalPerson.resize(900, 530);

                } else {
                    legalPerson.resizeRestore();

                }
            }
        });
    }

    public void createInterfaceProponent() {
        cleanContent();
        appBar.createNavProponent();
        InterfaceProponent desing = new InterfaceProponent(25);
        content.add(desing);

        int width = 600;
        int heigth = 600;

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (getWidth() > width && getHeight() > heigth) {
                    desing.resize(getWidth() - 400, getHeight() - 260);

                } else {
                    desing.restoreResize(); 
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
