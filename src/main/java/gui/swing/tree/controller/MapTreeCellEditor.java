package gui.swing.tree.controller;

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
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements  ActionListener{

    private Object clicked = null;
    private JTextField edit = null;

    public MapTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent(JTree tree, Object clicked, boolean agr1, boolean agr2, boolean agr3, int agr4)
    {
        this.clicked = clicked;
        this.edit = new JTextField(clicked.toString());
        this.edit.addActionListener(this);

        return edit;
    }

    public boolean isCellEditable(EventObject arg)
    {
        if(arg instanceof MouseEvent)
        {
            if(((MouseEvent)arg).getClickCount() == 3)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(!(clicked instanceof MapTreeItem) || ((MapTreeItem) clicked).getMapNode() instanceof ProjectExplorer)
        return;
        MapTreeItem clickedOn=(MapTreeItem) clicked;
        if (e.getActionCommand().isEmpty()) {
        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
        return;
    }

        String newName = e.getActionCommand();
        for (MapNode child: clickedOn.getMapNode().getParent(1).getChildren()){
            if (child.getName().equals(newName) && !child.equals(clickedOn)) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.NODE_ALREADY_EXISTS);
                return;
            }
        }

        try {
            clickedOn.setName(newName);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if(clickedOn.getMapNode() instanceof Project){
            MainFrame.getInstance().getProjectView().reloadTabs((MapNodeComposite) clickedOn.getMapNode());
        }

        if(clickedOn.getMapNode() instanceof MindMap){
            MainFrame.getInstance().getProjectView().reloadTabs((MapNodeComposite) clickedOn.getMapNode().getParent());
        }
    }



    }

