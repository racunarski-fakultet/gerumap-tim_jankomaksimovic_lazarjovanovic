package gui.swing.tree.view;

import gui.swing.mapRepository.implementation.ProjectExplorer;
import gui.swing.tree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MapTreeCellRenderer extends DefaultTreeCellRenderer {

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
    {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        URL imageURL = null;

        if(((MapTreeItem)value).getMapNode() instanceof ProjectExplorer)
        {
            imageURL = getClass().getResource("");
        }
        else if(((MapTreeItem)value).getMapNode() instanceof ProjectExplorer)
        {
            imageURL = getClass().getResource("");
        }

        Icon icon = null;
        if(imageURL != null)
        {
            icon = new ImageIcon(imageURL);
        }
        setIcon(icon);

        return this;
    }
}
