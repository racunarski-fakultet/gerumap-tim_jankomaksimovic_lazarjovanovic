package gui.swing.mapRepository.composite;

import gui.swing.observer.Publisher;
import gui.swing.observer.Subscriber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public abstract class MapNode implements Publisher {
    protected List<Subscriber> subs;
    private String name;
    private MapNode parent;

    public MapNode getParent() {
        return parent;
    }

    public MapNodeComposite getParent(int x) {
        return (MapNodeComposite) parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }



    public MapNode(String name, MapNode parent)
    {
        this.name = name;
        this.parent = parent;
        this.subs = new ArrayList<>();
    }


    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof MapNode)
        {
            MapNode obj2 = (MapNode) obj;
            return this.getName().equals(obj2.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IOException {
        this.name = name;
        notifySubscribers(this);
    }
}
