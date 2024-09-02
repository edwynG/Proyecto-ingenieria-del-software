package main.view.components.AbstractComponents;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class AbstractEffectFields extends JTextField {
    private String placeholder;

    public AbstractEffectFields(int comluns) {
        super(comluns);
        this.placeholder = "";
        initAbstractEffectFields();
    }

    public AbstractEffectFields(int comluns, String placeholder) {
        super(comluns);
        this.placeholder = placeholder;
        initAbstractEffectFields();
    }

    public void initAbstractEffectFields() {
        setText(this.placeholder);
        setPreferredSize(new Dimension(100, 36));
        setOpaque(false);
        setFocusable(false);
        
        this.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
              setFocusable(true);
          }
        });
    }

    private void effectPlaceHolderFocusGained() {
        if (getText().equals(this.placeholder)) {
            setText("");
        }
    }

    private void effectPlaceHolderfocusLost() {
        if (getText().isEmpty()) {
            setText(this.placeholder);
        }
    }

    public void addEffectPlaceHolder() {
        if (this.placeholder.isEmpty()) {
            return;
        }

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                effectPlaceHolderFocusGained();
            }

            @Override
            public void focusLost(FocusEvent e) {
                effectPlaceHolderfocusLost();
            }
        });
    }

    public String getPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(String string) {
        this.placeholder = string;
    }

}
