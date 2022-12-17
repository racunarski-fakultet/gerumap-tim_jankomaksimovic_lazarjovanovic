package gui.swing.tree.model;

import gui.swing.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;

@Getter
@Setter

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

    public void setName(String name) throws IOException {
        this.mapNode.setName(name);
    }

    public MapNode getMapNode() {
        return mapNode;
    }
}
