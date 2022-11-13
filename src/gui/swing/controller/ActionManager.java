package gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewAction projectAction;

    private RenameAction renameAction;

    public ActionManager()
    {
        initialiseActions();
    }

    private void initialiseActions()
    {
        exitAction = new ExitAction();
        projectAction = new NewAction();
        renameAction = new RenameAction();
    }

}
