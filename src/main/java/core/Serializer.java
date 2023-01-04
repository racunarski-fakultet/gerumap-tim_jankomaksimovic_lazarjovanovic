package core;

import gui.swing.mapRepository.implementation.Project;

import java.io.File;

public interface Serializer {

    Project loadProject(File file);
    void saveProject(Project node);

}
