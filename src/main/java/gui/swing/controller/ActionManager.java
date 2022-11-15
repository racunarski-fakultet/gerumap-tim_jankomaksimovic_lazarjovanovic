package gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewAction projectAction;

    private RenameAction renameAction;

    private DeleteAction deleteAction;

    public ActionManager()
    {
        initialiseActions();
    }

    private void initialiseActions()
    {
        exitAction = new ExitAction();
        projectAction = new NewAction();
        renameAction = new RenameAction();
        deleteAction = new DeleteAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public NewAction getProjectAction() {
        return projectAction;
    }

    public void setProjectAction(NewAction projectAction) {
        this.projectAction = projectAction;
    }

    public RenameAction getRenameAction() {
        return renameAction;
    }

    public void setRenameAction(RenameAction renameAction) {
        this.renameAction = renameAction;
    }
}
