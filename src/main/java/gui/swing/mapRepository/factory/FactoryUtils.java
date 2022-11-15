package gui.swing.mapRepository.factory;

import gui.swing.mapRepository.composite.MapNode;
import gui.swing.mapRepository.implementation.MindMap;
import gui.swing.mapRepository.implementation.Project;
import gui.swing.mapRepository.implementation.ProjectExplorer;

public class FactoryUtils {
    public static Object getNodeFactory(MapNode parent){
        if(parent instanceof ProjectExplorer)
        {return new ProjectFactory();}
        else if(parent instanceof Project)
        {return new MindMapFactory();}
        else if(parent instanceof MindMap)
        {return new ElementFactory();}

        return null;
    }
}
