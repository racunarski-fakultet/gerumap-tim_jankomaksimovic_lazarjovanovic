package gui.swing.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class MapNodeComposite extends MapNode{

    List<MapNode> children;

    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public MapNodeComposite(String name, MapNode parent, List<MapNode> children)
    {
        super(name, parent);
        this.children = children;
    }

    public List<MapNode> getChildren() {
        return children;
    }

    public void setChildren(List<MapNode> children) {
        this.children = children;
    }

    public abstract void add(MapNode child);


    public abstract void remove(MapNode child);

    public MapNode getByName(String name)
    {
        for(MapNode child : children)
        {
            if(child.getName() == name)
            {
                return child;
            }
        }
        return null;
    }
}

