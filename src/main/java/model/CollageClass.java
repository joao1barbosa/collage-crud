package model;

public class CollageClass {
    private int id;
    private String name;
    private String shift;
    private String course;

    public CollageClass(){}

    public CollageClass(
            String name,
            String shift,
            String course
    ){
        this.name = name;
        this.shift = shift;
        this.course = course;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString(){
        return
                "ID: " + id +
                "\nNome: " + name +
                "\nTurno: " + shift +
                "\nCurso: " + course +
                '\n';
    }
}
