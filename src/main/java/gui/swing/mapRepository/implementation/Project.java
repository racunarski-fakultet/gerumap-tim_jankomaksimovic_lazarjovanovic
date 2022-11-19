package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    private static int counter=1;

    public Project(String name, MapNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;
    }

    @Override
    public void add(MapNode child) {
        if(child != null && child instanceof MindMap)
        {
            MindMap mindMap = (MindMap) child;
            if(!this.getChildren().contains(mindMap))
            {
                this.getChildren().add(mindMap);
            }
        }
    }

    @Override
    public void remove(MapNode child) {
        MindMap mindMap = (MindMap) child;
        if(this.getChildren().contains(mindMap))
        {
            this.getChildren().remove(mindMap);
        }

    }
}
