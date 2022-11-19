package gui.swing.tree;

import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.tree.view.MapTreeView;

public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);

     void add(MapTreeItem parent);
     void delete(MapTreeItem child);
     MapTreeItem getSelectedNode();

}
