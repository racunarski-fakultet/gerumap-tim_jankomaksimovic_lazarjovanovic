package gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private InfoAction infoAction;
    private ExitAction exitAction;
    private NewAction newAction;
    private RenameAction renameAction;
    private DeleteAction deleteAction;

    public ActionManager()
    {
        initialiseActions();
    }

    private void initialiseActions()
    {
        exitAction = new ExitAction();
        newAction = new NewAction();
        renameAction = new RenameAction();
        deleteAction = new DeleteAction();
        infoAction  = new InfoAction();
    }

}
