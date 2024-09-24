package main.view.components.AbstractComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.util.HashMap;
import java.awt.GridBagLayout;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import main.Env;
import main.view.Main;
import main.view.utils.Components;

public class AbstractFileChooser extends AbstractPanelRounded {
    protected String title;
    protected JLabel text;
    protected JLabel imagen;
    protected final int WIDTH_ICON = 25;
    protected final int HEIGHT_ICON = 25;
    protected  int width_icon = 25;    
    protected  int height_icon = 25;
    protected HashMap<String, String> filterExtension;
    private String path = "";
    protected final String ICON_DEFAULD = Env.PATH_ICON_UPLOAD;
    protected String icon = Env.PATH_ICON_UPLOAD;
    private String option = "Upload";
    private String optionDownload = "Donwload";
    private String optionUpload = "Upload";

    public AbstractFileChooser(String text) {
        this.title = text;
        initAbstractFileChooser();
    }

    public AbstractFileChooser(String text, int rounded) {
        super(rounded);
        this.title = text;
        initAbstractFileChooser();

    }

    private void initAbstractFileChooser() {
        this.text = new JLabel(this.title);
        this.imagen = new JLabel();
        this.imagen.setIcon(createIcon(WIDTH_ICON,HEIGHT_ICON));
        this.filterExtension = new HashMap<>();
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new BorderLayout());
        add(this.text, BorderLayout.CENTER);
        add(this.imagen, BorderLayout.EAST);
        this.actionsAbstractFileChooser();
    }

    private ImageIcon createIcon(int width,int height) {
        ImageIcon src = new ImageIcon(this.getIcon());
        Image img = src.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private void actionsAbstractFileChooser() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (optionUpload.equals(getOptionFilechooser())) {
                    methodUpload();
                    return;
                }
                methodDownload();
            }
        });
    }

    private void methodDownload() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setApproveButtonText("Seleccionar");
        int value = fileChooser.showOpenDialog(Main.WINDOW);

        if (value == JFileChooser.APPROVE_OPTION) {
            File selection = fileChooser.getSelectedFile();
            path = selection.getAbsolutePath();
            text.revalidate();
            text.repaint();
            return;
        }

    }

    private void methodUpload() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        for (String filter : filterExtension.keySet()) {
            fileChooser
                    .addChoosableFileFilter(new FileNameExtensionFilter(filter, filterExtension.get(filter)));
        }
        fileChooser.setApproveButtonText("Seleccionar");
        int value = fileChooser.showOpenDialog(Main.WINDOW);

        if (value == JFileChooser.APPROVE_OPTION) {
            File selection = fileChooser.getSelectedFile();
            text.setText(selection.getName());
            if (isFileExtensionValid(selection)) {
                ApprovateFile();
                path = selection.getAbsolutePath();
                text.revalidate();
                text.repaint();
                return;
            }

            DisapprovedFile();

        }
    }

    private boolean isFileExtensionValid(File selection) {
        if (this.filterExtension.isEmpty())
            return true;

        for (String element : filterExtension.values()) {
            if (selection.getName().contains(element)) {
                return true;
            }
        }
        return false;
    }

    protected void ApprovateFile() {
        return;
    }

    protected void DisapprovedFile() {
        return;
    }

    public void setListFilerExtension(HashMap<String, String> filter) {
        this.filterExtension = filter;
    }

    public void setIcon(String src) {
        this.icon = src;
        this.imagen.setIcon(this.createIcon(width_icon,height_icon));
        this.imagen.revalidate();
        this.imagen.repaint();
    }

    public void setRedimentionIcon(int width, int height){
        width_icon = width;
        height_icon = height;
        setIcon(icon);
    }

    public void setColorText(Color color) {
        this.text.setForeground(color);
    }

    public void setFontSizeText(int size) {
        Font font = this.text.getFont();
        this.text.setFont(new Font(font.getName(), font.getStyle(), size));
    }

    public void setFontFamilyText(String family) {
        Font font = this.text.getFont();
        this.text.setFont(new Font(family, font.getStyle(), font.getSize()));
    }

    public void setFontWeight(int weight) {
        Font font = this.text.getFont();
        this.text.setFont(new Font(font.getName(), weight, font.getSize()));
    }

    public String getIcon() {
        return icon;
    }

    public String getIconDefauld() {
        return ICON_DEFAULD;
    }

    public String getPath() {
        return this.path;
    }

    public String getOptionFilechooser() {
        return option;
    }

    public void configMethodDownload() {
        option = optionDownload;
        setIcon(Env.PATH_ICON_DOWNLOAD);
    };

    public void configMethodUpload() {
        option = optionUpload;
        setIcon(Env.PATH_ICON_UPLOAD);
    };

    public void NotVisibleText() {
        Components.removeElementAll(this);
        setLayout(new GridBagLayout());
        add(this.imagen);

    };

    public void NotVisibleIcon() {
        Components.removeElementAll(this);
        setLayout(new GridBagLayout());
        add(this.text);
    };

    public void visibleComponents() {
        Components.removeElementAll(this);
        setLayout(new BorderLayout());
        add(this.text, BorderLayout.CENTER);
        add(this.imagen, BorderLayout.EAST);
    };

    @Override
    public Insets getInsets() {
        return new Insets(0, 10, 0, 10);
    }

}
