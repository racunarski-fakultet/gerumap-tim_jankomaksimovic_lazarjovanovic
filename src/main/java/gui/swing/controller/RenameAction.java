package gui.swing.controller;

import core.ApplicationFramework;
import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.message.EventType;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RenameAction extends AbstractGeRuMapAction{
    public RenameAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/rename.png"));
        putValue(NAME,"Rename");
        putValue(SHORT_DESCRIPTION,"Rename");
    }

    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_NOT_SELECTED);
            return;
        }
        String newName = JOptionPane.showInputDialog(MainFrame.getInstance(), "New name:\n", JOptionPane.QUESTION_MESSAGE);
        if (newName==null){
            return;
        } else if (newName.equals(" ") || newName.isEmpty()) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
            return;
        }
        for (MapNode child: selected.getMapNode().getParent(1).getChildren()){
            if (child.getName().equals(newName) && !(child.equals(selected))) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_ALREADY_EXISTS);
                return;
            }
        }
        try {
            selected.setName(newName);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if(selected.getMapNode() instanceof Project){
            MainFrame.getInstance().getProjectView().reloadTabs((MapNodeComposite) selected.getMapNode());
        }

        if(selected.getMapNode() instanceof MindMap){
            MainFrame.getInstance().getProjectView().reloadTabs((MapNodeComposite) selected.getMapNode().getParent());
        }
    }

}