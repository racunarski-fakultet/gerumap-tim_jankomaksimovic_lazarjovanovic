package gui.swing.mapRepository;

import core.MapRepository;
import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImplementation implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImplementation() {
        projectExplorer = new ProjectExplorer("Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        System.out.println("e");
        return projectExplorer;
    }

    @Override
    public void add(MapNodeComposite parent, MapNode child) {

    }

}
