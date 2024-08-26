package main.view.components.AbstractComponents;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;



public class AbstractEffectText extends JLabel {
    protected String text;
    protected Font config;

    public AbstractEffectText(String string) {
        super(string);
        initAbstractEffectText(string);
    }

    public AbstractEffectText(String string, int position){
        super(string,position);
        initAbstractEffectText(string);
    }

    private void initAbstractEffectText(String string) {
        this.text=string;
        this.config = new Font("Arial", Font.PLAIN, 15);
        setFont(config);
    }


    public void addEffectHover(Color hover){
        this.addMouseListener(new MouseAdapter() {
            private Color before = getForeground();
            private Cursor point = getCursor();
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(hover);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(before);
                setCursor(point);

            }
        });
    }
}