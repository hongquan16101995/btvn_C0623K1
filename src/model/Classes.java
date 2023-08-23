package model;

public class Classes {
    private static int INDEX = 0;
    private int id;
    private String name;

    public Classes(){
    }

    public Classes(String name) {
        this.id = ++INDEX;
        this.name = name;
    }

    public Classes(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
