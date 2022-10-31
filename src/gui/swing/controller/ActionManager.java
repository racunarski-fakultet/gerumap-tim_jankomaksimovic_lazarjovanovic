package gui.swing.controller;

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
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewAction getProjectAction()
    {
        return projectAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public void setProjectAction(NewAction projectAction) {
        this.projectAction = projectAction;
    }
}
