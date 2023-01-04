package gui.swing.tree;

import core.ApplicationFramework;
import gui.swing.comands.AbstractCommand;
import gui.swing.comands.implementation.AddChildCommand;
import gui.swing.comands.implementation.RemoveChildCommand;
import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.factory.FactoryUtils;
import gui.swing.mapRepository.factory.NodeFactory;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.tree.view.MapTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.IOException;

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
    public void add(MapTreeItem parent) throws IOException {
        if(parent == null)
            return;

        if(!((parent.getMapNode()) instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        MapTreeItem newC = new MapTreeItem(child);
        parent.add(newC);
        AddChildCommand aCC = new AddChildCommand(parent, newC);
        ApplicationFramework.getInstance().getGuiInterface().getCommandManager().addCommand(aCC);

        ((MapNodeComposite) parent.getMapNode()).add(child);
        mapTreeView.expandPath(mapTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(mapTreeView);


    }

    @Override
    public void delete(MapTreeItem child) {
        MapTreeItem parent = (MapTreeItem) child.getParent();
        if (parent == null) return;
        RemoveChildCommand rCC = new RemoveChildCommand(parent, child);
        ApplicationFramework.getInstance().getGuiInterface().getCommandManager().addCommand(rCC);
        //parent.remove(child);
        mapTreeView.expandPath(mapTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(mapTreeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) mapTreeView.getLastSelectedPathComponent();
    }

    @Override
    public Component getTreeView() {
        return mapTreeView;
    }

    private MapNode createChild(MapNode parent) throws IOException {
        NodeFactory nodeFactory = FactoryUtils.getFactory(parent);
        return nodeFactory.getMapNode(parent);
    }
}
