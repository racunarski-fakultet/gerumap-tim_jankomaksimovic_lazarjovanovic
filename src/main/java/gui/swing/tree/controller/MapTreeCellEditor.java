package gui.swing.tree.controller;

import gui.swing.tree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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
        if(!(this.clicked instanceof MapTreeItem))
        {
            return;
        }
        MapTreeItem click = (MapTreeItem) clicked;
        click.setName(e.getActionCommand());

    }
}
