package entities;

import java.util.List;

public class SpaceType {
    private int id;
    private String name;
    private List<Space> spaces;

    public SpaceType(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public List<Space> getSpaces(){
        return spaces;
    }
    public void addSpace(Space space){
        spaces.add(space);
        space.setSpaceType(this);
    }
    public void removeSpace(Space space){
        spaces.remove(space);
        space.setSpaceType(null);
    }
}
