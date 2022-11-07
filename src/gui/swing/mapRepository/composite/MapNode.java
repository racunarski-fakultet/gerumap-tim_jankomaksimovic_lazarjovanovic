package gui.swing.mapRepository.composite;

public abstract class MapNode {

    private String name;

    private MapNode parent;

    public MapNode(String name, MapNode parent)
    {
        this.name = name;
        this.parent = parent;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof MapNode)
        {
            MapNode obj2 = (MapNode) obj;
            return this.getName().equals(obj2.getName());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
