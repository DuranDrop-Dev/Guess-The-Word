package Components;

import src.GUI;
import src.Players;

import javax.swing.*;
import java.awt.*;

public class PlayerPrompt extends JPanel {
    public static Players[] currentPlayers = new Players[3];

    public void Player1FirstName(String a1, String a2, String b1, String b2, String c1, String c2) {
        currentPlayers[0] = new Players();
        GUI.saveMessages(a1 + "\n");
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field, BorderLayout.CENTER);
        add(ok, BorderLayout.CENTER);
        field.requestFocus();

        ok.addActionListener(e -> {
            currentPlayers[0].setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player1LastName(a2, b1, b2, c1, c2);
        });
        field.addActionListener(e -> {
            currentPlayers[0].setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player1LastName(a2, b1, b2, c1, c2);
        });
    }

    public void Player1LastName(String a2, String b1, String b2, String c1, String c2) {
        GUI.saveMessages(a2 + "\n");
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field, BorderLayout.CENTER);
        add(ok, BorderLayout.CENTER);
        field.requestFocus();

        ok.addActionListener(e -> {
            currentPlayers[0].setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player2FirstName(b1, b2, c1, c2);
        });
        field.addActionListener(e -> {
            currentPlayers[0].setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player2FirstName(b1, b2, c1, c2);
        });
    }

    public void Player2FirstName(String b1, String b2, String c1, String c2) {
        currentPlayers[1] = new Players();
        GUI.saveMessages(b1 + "\n");
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field, BorderLayout.CENTER);
        add(ok, BorderLayout.CENTER);
        field.requestFocus();

        ok.addActionListener(e -> {
            currentPlayers[1].setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player2LastName(b2, c1, c2);
        });
        field.addActionListener(e -> {
            currentPlayers[1].setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player2LastName(b2, c1, c2);
        });
    }

    public void Player2LastName(String b2, String c1, String c2) {
        GUI.saveMessages(b2 + "\n");
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field, BorderLayout.CENTER);
        add(ok, BorderLayout.CENTER);
        field.requestFocus();

        ok.addActionListener(e -> {
            currentPlayers[1].setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player3FirstName(c1, c2);
        });
        field.addActionListener(e -> {
            currentPlayers[1].setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player3FirstName(c1, c2);
        });
    }

    public void Player3FirstName(String c1, String c2) {
        currentPlayers[2] = new Players();
        GUI.saveMessages(c1 + "\n");
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field, BorderLayout.CENTER);
        add(ok, BorderLayout.CENTER);
        field.requestFocus();

        ok.addActionListener(e -> {
            currentPlayers[2].setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player3LastName(c2);
        });
        field.addActionListener(e -> {
            currentPlayers[2].setFirstName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            Player3LastName(c2);
        });
    }

    public void Player3LastName(String c2) {
        GUI.saveMessages(c2 + "\n");
        JTextField field = new JTextField("", 15);
        JButton ok = new JButton("OK");

        add(field, BorderLayout.CENTER);
        add(ok, BorderLayout.CENTER);
        field.requestFocus();

        ok.addActionListener(e -> {
            currentPlayers[2].setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            GUI.updatePlayerScoreBoard();
            GUI.playerIsSet = true;
            GUI.addStartButton();
        });
        field.addActionListener(e -> {
            currentPlayers[2].setLastName(field.getText());
            remove(field);
            remove(ok);
            revalidate();
            GUI.updatePlayerScoreBoard();
            GUI.playerIsSet = true;
            GUI.addStartButton();
        });
    }
}
