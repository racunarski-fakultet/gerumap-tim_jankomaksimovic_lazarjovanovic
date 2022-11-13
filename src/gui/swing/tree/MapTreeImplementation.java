package gui.swing.tree;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.tree.view.MapTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeImplementation implements MapTree{

    private MapTreeView mapTreeView;
    private DefaultTreeModel treeModel;
    private static int i = 0;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {

        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        mapTreeView = new MapTreeView(treeModel);

        return mapTreeView;
    }

    @Override
    public void add(MapTreeItem parent) {

        if(!((parent.getMapNode()) instanceof MapNodeComposite))
        {
            return;
        }

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));

        ((MapNodeComposite)parent.getMapNode()).add(child);
        mapTreeView.expandPath(mapTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(mapTreeView);

    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) mapTreeView.getLastSelectedPathComponent();
    }

    private MapNode createChild(MapNode parent)
    {
        if(parent instanceof ProjectExplorer)
            return new Project("Project" + i++, parent);

        return null;
    }
}
