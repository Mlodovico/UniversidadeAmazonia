package Model;

public class Student {
    private Integer id;
    private String name;
    private String lastName;
    private String course;
    private Integer np1;
    private Integer np2;
    private Integer repositionNote;
    private Integer examNote;

    public Student(String name, String lastName, String course, Integer np1, Integer np2, Integer repositionNote, Integer examNote) {
        this.name = name;
        this.lastName = lastName;
        this.course = course;
        this.np1 = np1;
        this.np2 = np2;
        this.repositionNote = repositionNote;
        this.examNote = examNote;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getNp1() {
        return np1;
    }

    public void setNp1(Integer np1) {
        this.np1 = np1;
    }

    public Integer getNp2() {
        return np2;
    }

    public void setNp2(Integer np2) {
        this.np2 = np2;
    }

    public Integer getRepositionNote() {
        return repositionNote;
    }

    public void setRepositionNote(Integer repositionNote) {
        this.repositionNote = repositionNote;
    }

    public Integer getExamNote() {
        return examNote;
    }

    public void setExamNote(Integer examNote) {
        this.examNote = examNote;
    }
}
