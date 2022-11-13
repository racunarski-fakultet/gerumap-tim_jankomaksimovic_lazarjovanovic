package gui.swing.tree.model;

import gui.swing.mapRepository.composite.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem (MapNode mapNode)
    {
        this.mapNode = mapNode;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name)
    {
        this.mapNode.setName(name);
    }

    public MapNode getMapNode() {
        return mapNode;
    }
}
