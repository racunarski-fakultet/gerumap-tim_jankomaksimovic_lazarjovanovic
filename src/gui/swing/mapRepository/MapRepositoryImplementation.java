package gui.swing.mapRepository;

import core.MapRepository;
import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImplementation implements MapRepository {
    @Override
    public ProjectExplorer getProjectExplorer() {
        return null;
    }

    @Override
    public void add(MapNodeComposite parent, MapNode child) {

    }
}
