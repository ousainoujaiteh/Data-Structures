package exercise;

public class StudentGradeClass {

    private String fullName;
    private String major;
    private double score;
    private long matNumber;

    public StudentGradeClass(String name,String major, double score, long mat){
        this.fullName = name;
        this.major = major;
        this.score = score;
        this.matNumber = mat;
    }

    public long getMatNumber(){
        return this.matNumber;
    }
}
