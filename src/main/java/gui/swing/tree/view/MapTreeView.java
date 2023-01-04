package gui.swing.tree.view;

import gui.swing.tree.controller.MapTreeCellEditor;
import gui.swing.tree.controller.MapTreeSelectionListener;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
@Getter
@Setter

public class MapTreeView extends JTree {

    public MapTreeView (DefaultTreeModel defaultTreeModel)
    {
        setModel(defaultTreeModel);

        MapTreeCellRenderer treeCellRenderer = new MapTreeCellRenderer();

        addTreeSelectionListener(new MapTreeSelectionListener());
        setCellEditor(new MapTreeCellEditor(this, treeCellRenderer));
        setCellRenderer(treeCellRenderer);

        /*MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int selRow = getRowForLocation(e.getX(), e.getY());
                TreePath selPath = getPathForLocation(e.getX(), e.getY());
                if(selRow != -1 && e.getClickCount() == 2) {

                    MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

                    if(selected.getMapNode() instanceof Project){
                        if(((Project) selected.getMapNode()).getAuthor() != null) {
                            MainFrame.getInstance().getProjectView().refreshTabs(selected.getMapNode());
                            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());
                        }else{
                            try {
                                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_SET_AUTHOR);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }

                }
            }
        };
        addMouseListener(ml);*/

        setEditable(true);

    }
}
