package Components;

import src.GUI;

import javax.swing.*;

public class GamePrompt extends JPanel {
    public void hostPrompt(String message) {
        GUI.saveMessages(message);
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field, GUI.gbc);
        add(ok, GUI.gbc);
        field.requestFocus();

        ok.addActionListener(e -> {
            GUI.setPlayerGuess(field.getText());
            remove(field);
            remove(ok);
            sync();
        });

        field.addActionListener(e -> {
            GUI.setPlayerGuess(field.getText());
            remove(field);
            remove(ok);
            sync();
        });
    }

    private void sync() {
        synchronized (GUI.gamePrompt) {
            GUI.gamePrompt.notify();
        }
    }
}
