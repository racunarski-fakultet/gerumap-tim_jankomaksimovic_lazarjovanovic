package gui.swing.controller;

import gui.swing.view.MainFrame;
import gui.swing.view.MyInfoDialog;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javax.swing.Action.*;

public class InfoAction extends AbstractGeRuMapAction{

    public InfoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }


    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e) {
       MyInfoDialog info = new MyInfoDialog(MainFrame.getInstance(), "Info");
    }
}