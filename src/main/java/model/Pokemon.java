package model;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private int level;

    public Pokemon(int id, String name, String type, int level) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon( String name, String type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getLevel() {
        return level;
    }
}
