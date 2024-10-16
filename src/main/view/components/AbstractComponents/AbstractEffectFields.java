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
        placeholder = "";
        initAbstractEffectFields();
    }

    public AbstractEffectFields(int comluns, String placeholder) {
        super(comluns);
        this.placeholder = placeholder;
        initAbstractEffectFields();
    }

    public void initAbstractEffectFields() {
        setText(placeholder);
        setPreferredSize(new Dimension(100, 36));
        setOpaque(false);
        setFocusable(false);
        
        addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
              setFocusable(true);
          }
        });
    }

    private void effectPlaceHolderFocusGained() {
        if (getText().equals(placeholder)) {
            setText("");
        }
    }

    private void effectPlaceHolderfocusLost() {
        if (getText().isEmpty()) {
            setText(placeholder);
        }
    }

    public void addEffectPlaceHolder() {
        if (placeholder.isEmpty()) {
            return;
        }

        addFocusListener(new FocusListener() {
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
        return placeholder;
    }

    public void setPlaceholder(String string) {
        placeholder = string;
    }

}
