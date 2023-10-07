package me.crud;

import java.awt.EventQueue;
import me.crud.form.MainForm;


public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MainForm().setVisible(true);
        });
    }
}
