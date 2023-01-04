package gui.swing.controller;

import core.ApplicationFramework;
import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.message.EventType;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class DeleteAction extends AbstractGeRuMapAction {
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON,loadIcon("/images/Delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if (selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_NOT_SELECTED);
            return;
        }

        if (selected.getMapNode() instanceof ProjectExplorer) {

            ApplicationFramework.getInstance().
                    getMessageGenerator().generateMessage(EventType.CANNOT_DELETE_PROJECT_EXPLORER);
            return;
        }
        MainFrame.getInstance().getMapTree().delete(selected);
    }
}
