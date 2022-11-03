package Model;

public class Student {
    private Integer id;
    private String name;
    private Integer np1;
    private Integer np2;
    private Integer repositionNote;
    private Integer examNote;

    public Student(Integer id, String name, Integer np1, Integer np2, Integer repositionNote, Integer examNote) {
         this.id = id;
         this.name = name;
         this.np1 = np1;
         this.np2 = np2;
         this.repositionNote = repositionNote;
         this.examNote = examNote;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
