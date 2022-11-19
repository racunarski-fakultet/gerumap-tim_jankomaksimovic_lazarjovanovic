package gui.swing.mapRepository.implementation;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }



    @Override
    public void add(MapNode child) {
        if(child != null && child instanceof Project)
        {
            Project project = (Project) child;
            if(!this.getChildren().contains(project))
            {
                this.getChildren().add(project);
            }
        }
    }

    @Override
    public void remove(MapNode child) {

        Project project = (Project) child;
        if(this.getChildren().contains(project))
        {
            this.getChildren().remove(project);
        }
    }
}
