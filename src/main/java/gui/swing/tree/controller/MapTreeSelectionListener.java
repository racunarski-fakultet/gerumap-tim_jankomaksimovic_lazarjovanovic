package gui.swing.tree.controller;

import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.tree.model.MapTreeItem;
import gui.swing.view.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem) path.getLastPathComponent();
        System.out.println("selected node: "+treeItemSelected.getMapNode().getName());
        System.out.println("getPath: "+e.getPath());

        if(treeItemSelected.getMapNode() instanceof Project){
            Project p = (Project) treeItemSelected.getMapNode();
            MainFrame.getInstance().getProjectView().reloadTabs(p);
        } else if (treeItemSelected.getMapNode() instanceof MindMap){
            MindMap m = (MindMap) treeItemSelected.getMapNode();
            MainFrame.getInstance().getProjectView().reloadTabs((MapNodeComposite) m.getParent());

        }
    }
}
