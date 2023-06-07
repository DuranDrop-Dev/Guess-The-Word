package Components;

import src.GUI;
import src.Phrases;

import javax.swing.*;

public class HostPrompt extends JPanel {
    public void HostFirstName(String firstName, String lastName, String phrase) {
        GUI.saveMessages(firstName);
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field);
        add(ok);
        field.requestFocus();

        ok.addActionListener(e -> {
            GUI.host.setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            HostLastName(lastName, phrase);
        });
        field.addActionListener(e -> {
            GUI.host.setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            HostLastName(lastName, phrase);
        });
    }

    public void HostLastName(String lastName, String phrase) {
        GUI.saveMessages(lastName);
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field);
        add(ok);
        field.requestFocus();

        ok.addActionListener(e -> {
            GUI.host.setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            GUI.hostName.setText(GUI.host.toString());
            HostPhrase(phrase);
        });
        field.addActionListener(e -> {
            GUI.host.setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            GUI.hostName.setText(GUI.host.toString());
            HostPhrase(phrase);
        });
    }

    public void HostPhrase(String phrase) {
        GUI.saveMessages(phrase);
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field);
        add(ok);
        field.requestFocus();

        ok.addActionListener(e -> {
            GUI.host.hostSetPhrase(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Phrases.setPlayingPhrase(Phrases.gamePhrase);
            GUI.playingPhrase.setText(Phrases.playingPhrase);
            GUI.hostIsSet = true;
            GUI.addStartButton();
            synchronized (GUI.gamePrompt) {
                GUI.gamePrompt.notify();
            }
        });
        field.addActionListener(e -> {
            GUI.host.hostSetPhrase(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Phrases.setPlayingPhrase(Phrases.gamePhrase);
            GUI.playingPhrase.setText(Phrases.playingPhrase);
            GUI.hostIsSet = true;
            GUI.addStartButton();
            synchronized (GUI.gamePrompt) {
                GUI.gamePrompt.notify();
            }
        });
    }
}
