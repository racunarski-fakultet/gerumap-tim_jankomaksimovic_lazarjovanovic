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


    protected GuiInterface guiInterface;
    protected MapRepository mapRepository;
    private Serializer serializer;
    protected ErrorLogger consoleLogger;
    protected ErrorLogger fileLogger;
    protected MessageGenerator messageGenerator;

    public void run() {
        this.guiInterface.start();
    }

    public void initialise(GuiInterface guiInterface, MapRepository mapRepository, ErrorLogger consoleLogger, ErrorLogger fileLogger, MessageGenerator messageGenerator, Serializer serializer) {

        this.guiInterface = guiInterface;
        this.mapRepository = mapRepository;
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
        this.messageGenerator = messageGenerator;
        this.serializer = serializer;
    }


}
