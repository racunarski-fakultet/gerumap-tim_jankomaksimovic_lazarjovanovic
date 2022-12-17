package core;

import gui.swing.error.ErrorLogger;
import gui.swing.message.MessageGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ApplicationFramework {
    private static ApplicationFramework instance;

    private ApplicationFramework() {

    }

    public static ApplicationFramework getInstance() {
        if (instance == null) {
            instance = new ApplicationFramework();
        }
        return instance;
    }

    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger consoleLogger;
    protected ErrorLogger fileLogger;
    protected MessageGenerator messageGenerator;

    public void run() {
        this.gui.start();
    }

    public void initialise(Gui gui, MapRepository mapRepository, ErrorLogger consoleLogger, ErrorLogger fileLogger, MessageGenerator messageGenerator) {
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
        this.messageGenerator = messageGenerator;
    }


}
