package gui.swing.comands.implementation;

import gui.swing.comands.AbstractCommand;
import gui.swing.mapRepository.composite.MapNodeComposite;
import gui.swing.tree.model.MapTreeItem;

public class RemoveChildCommand extends AbstractCommand {

    private MapTreeItem parent;
    private MapTreeItem child;

    public RemoveChildCommand(MapTreeItem parent, MapTreeItem child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {
        if(child == null || parent == null) return;

        parent.remove(child);
        ((MapNodeComposite) parent.getMapNode()).remove(child.getMapNode());
    }

    @Override
    public void undoCommand() {
        if(child == null || parent == null) return;

        parent.add(child);
        ((MapNodeComposite)(parent.getMapNode())).add(child.getMapNode());
    }

    }

