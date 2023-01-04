package gui.swing.controller;

import core.ApplicationFramework;
import gui.swing.mapRepository.implementation.Element;
import gui.swing.message.EventType;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class NewAction extends AbstractGeRuMapAction{

    public NewAction()
    {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/NewProject.png"));
        putValue(NAME,"New Project");
        putValue(SHORT_DESCRIPTION,"New Project");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        MapTreeItem selected;
        selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();

        if (selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_NOT_SELECTED);
            return;
        }

        if (selected.getMapNode() instanceof Element){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.CANNOT_ADD_CHILD);
            return;
        }

        try {
            MainFrame.getInstance().getMapTree().add(selected);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
