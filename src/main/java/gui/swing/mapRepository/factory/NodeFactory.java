package gui.swing.mapRepository.factory;

import gui.swing.mapRepository.composite.MapNode;

public abstract class NodeFactory  {
    public MapNode getMapNode(MapNode parent){
        MapNode n = createNode(parent);
        n.setParent(parent);

        return n;
    }

    public abstract MapNode createNode(MapNode node);
}
