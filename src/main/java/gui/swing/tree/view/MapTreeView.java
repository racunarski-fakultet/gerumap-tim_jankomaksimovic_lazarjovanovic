package gui.swing.tree.view;

import gui.swing.tree.controller.MapTreeCellEditor;
import gui.swing.tree.controller.MapTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {

    public MapTreeView (DefaultTreeModel defaultTreeModel)
    {
        setModel(defaultTreeModel);

        MapTreeCellRenderer treeCellRenderer = new MapTreeCellRenderer();

        addTreeSelectionListener(new MapTreeSelectionListener());
        setCellEditor(new MapTreeCellEditor(this, treeCellRenderer));
        setCellRenderer(treeCellRenderer);
        setEditable(true);
    }
}
