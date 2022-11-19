import core.ApplicationFramework;
import core.Gui;
import core.MapRepository;
import gui.swing.SwingGui;
import gui.swing.mapRepository.MapRepositoryImplementation;

public class AppCore {
    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();

        MapRepository mapRepository = new MapRepositoryImplementation();

        Gui gui = new SwingGui();

        appCore.initialise(gui, mapRepository);
        appCore.run();
    }
}
