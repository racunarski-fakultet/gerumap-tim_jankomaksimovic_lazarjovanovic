package gui.swing.tree;

import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.tree.view.MapTreeView;

import java.awt.*;
import java.io.IOException;

public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);

     void add(MapTreeItem parent) throws IOException;
     void delete(MapTreeItem child);
     MapTreeItem getSelectedNode();

    Component getTreeView();
}
