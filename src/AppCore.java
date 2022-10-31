import core.ApplicationFramework;
import core.Gui;
import gui.swing.SwingGui;

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
        appCore.initialise(gui);
        appCore.run();
    }
}
