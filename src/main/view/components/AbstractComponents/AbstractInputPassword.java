package main.view.components.AbstractComponents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AbstractInputPassword extends AbstractInputText {
    private char ch;
    private StringBuilder text;

    public AbstractInputPassword(int comluns) {
        super(comluns);
        initAbstractInputPassword();
    }
    public AbstractInputPassword(int comluns, String placeholder) {
        super(comluns, placeholder);
        initAbstractInputPassword();
    }

    private void initAbstractInputPassword() {
        this.ch = '*';
        this.text = new StringBuilder();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (ch != ' ' && ch != '\u0000') {
                    hidenPasswordEvent(e, ch);
                    return;
                }

                commonEvent(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (ch != ' ' && ch != '\u0000') {
                    setText(repeatCharacter(ch, text.length()));
                    return;
                }
                setText(text.toString());

            }
        });
    }

    private void hidenPasswordEvent(KeyEvent e, char ch) {
        boolean equals = !this.isEqualChar(e.getKeyCode(), KeyEvent.VK_DELETE)
                && !this.isEqualChar(e.getKeyCode(), KeyEvent.VK_BACK_SPACE);

        if (equals) {
            text.append(e.getKeyChar());

        } else {
            if (text.length() > 0) {
                text.deleteCharAt(text.length() - 1);

            }

        }

    }

    private void commonEvent(KeyEvent e) {
        boolean equals = !this.isEqualChar(e.getKeyCode(), KeyEvent.VK_DELETE)
                && !this.isEqualChar(e.getKeyCode(), KeyEvent.VK_BACK_SPACE);

        if (equals) {
            this.text.append(e.getKeyChar());

        } else {
            if (text.length() > 0) {
                text.deleteCharAt(text.length() - 1);

            }

        }

    }

    private boolean isEqualChar(int m, int n) {
        return m == n;
    }

    private String repeatCharacter(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String getPassword() {
        return this.text.toString();
    }

    public void setEchoChar(char c) {
        this.ch = c;
    }
    
}