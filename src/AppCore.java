import core.ApplicationFramework;
import core.Gui;
import core.MapRepository;
import gui.swing.SwingGui;
import gui.swing.mapRepository.MapRepositoryImplementation;

public class AppCore extends ApplicationFramework {

    private static AppCore instance;

    private AppCore()
    {

    }

    public static AppCore getInstance()
    {
        if(instance == null)
        {
            instance = new AppCore();
        }
        return instance;
    }

    @Override
    public void run() {

        this.gui.start();
    }

    public static void main(String[] args)
    {
        Gui gui = new SwingGui();
        ApplicationFramework appCore = AppCore.getInstance();
        MapRepository mapRepository = new MapRepositoryImplementation();
        appCore.initialise(gui, mapRepository);
        appCore.run();
    }
}
