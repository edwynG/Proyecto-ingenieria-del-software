package main.view.components.AbstractComponents;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;

public class AbstractEffectFieldsPassword extends JPasswordField {
    private String placeholder;
    private Character ch;
    public AbstractEffectFieldsPassword(int comluns) {
        super(comluns);
        placeholder = "";
        initAbstractEffectFields();
    }

    public AbstractEffectFieldsPassword(int comluns, String placeholder) {
        super(comluns);
        this.placeholder = placeholder;
        initAbstractEffectFields();
    }

    public void initAbstractEffectFields() {
        ch = getEchoChar();
        setEchoChar('\u0000');
        setText(placeholder);
        setPreferredSize(new Dimension(100, 36));
        setOpaque(false);
        setFocusable(false);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                effectPlaceHolderFocusGained();
                
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    
        addMouseListener(new MouseAdapter() {
          @Override
          public void mouseEntered(MouseEvent e) {
              setFocusable(true);
          }
        });
    }

    private void effectPlaceHolderFocusGained() {
        if (getText().equals(placeholder)) {
            setEchoChar(ch);
            setText("");
        }
    }

    private void effectPlaceHolderfocusLost() {
        if (getText().isEmpty()) {
            setEchoChar('\u0000');
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
        setEchoChar('\u0000');
        setText(placeholder);
    }

    @Override
    public String getText() {
        return new String(getPassword());
    }
    public void setCh(Character ch) {
        this.ch = ch;
    }
}
