package gui.swing.view;

import core.ApplicationFramework;
import gui.swing.controller.ActionManager;
import gui.swing.tree.MapTree;
import gui.swing.tree.MapTreeImplementation;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class MainFrame extends JFrame {

    private static MainFrame instance;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private MapTree mapTree;

    private JTree projectExplorer;
    private ProjectView projectView;
    private JToolBar options;


    private MainFrame()
    {

    }

    private void initialise()
    {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        projectView = new ProjectView();
        initialiseGUI();
    }

    private void initialiseGUI() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth/2 + screenWidth/4, screenHeight/2 + screenHeight/4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);
        options = new Options();
        add(options, BorderLayout.EAST);

        JTree projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());

        JScrollPane scroll = new JScrollPane(projectExplorer);
        JPanel rightPanel = projectView;
        scroll.setMinimumSize(new Dimension(200,100));

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, rightPanel);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public ActionManager getActionManager()
    {
        return actionManager;
    }

}
