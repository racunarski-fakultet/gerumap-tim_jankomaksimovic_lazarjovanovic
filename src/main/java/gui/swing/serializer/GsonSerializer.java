package gui.swing.serializer;

import com.google.gson.Gson;
import core.Serializer;
import gui.swing.mapRepository.implementation.Project;


import java.io.*;

public class GsonSerializer implements Serializer {

    private final Gson gson = new Gson();

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
