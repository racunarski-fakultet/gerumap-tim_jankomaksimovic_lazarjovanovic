package gui.swing.controller;

import core.ApplicationFramework;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.message.EventType;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AuthorAction extends AbstractGeRuMapAction{
    public AuthorAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,loadIcon("/images/Author.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_NOT_SELECTED);
            return;
        }

        if(selected.getMapNode() instanceof Project){
            String newAuthor = JOptionPane.showInputDialog("Enter author name:");
            ((Project)selected.getMapNode()).setAuthor(newAuthor);
        }


    }
}

