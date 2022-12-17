package gui.swing.mapRepository.factory;

import gui.swing.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter

public abstract class NodeFactory extends MapNode  {
    public MapNode getMapNode(MapNode parent) throws IOException {
        MapNode n = createNode(parent);
        n.setParent(parent);

        return n;
    }

    public abstract MapNode createNode(MapNode node) throws IOException;
}
